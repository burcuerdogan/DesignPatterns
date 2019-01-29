package presentation;

import java.io.IOException;
import java.text.ParseException;

import businessLayer.CustomExceptions;
import businessLayer.Mediator;

public class MainMenuIO {
	private GenericIOFunctions genericIOFunctions = new GenericIOFunctions();
	private TaskUpdateIO taskUpdater = new TaskUpdateIO();
	private ProjectUpdateIO projectUpdater = new ProjectUpdateIO();
	private ActivityUpdateIO activityUpdater = new ActivityUpdateIO();


	public void startUserInterface(Mediator mediator) throws ParseException, CustomExceptions.NotAcceptedDateFormat, CustomExceptions.EmptyFieldNotAllowedException, CustomExceptions.ProjectNotFoundException, IOException {
		while(true){
			System.out.println("......Welcome......");
			System.out.println("Please type a number to select your operation.");
			System.out.println("1. Display a Projects");
			System.out.println("2. Create");
			System.out.println("3. Remove");
			System.out.println("4. Update");
			System.out.println("5. Resource Assigned/Unassigned");
			System.out.println("6. Calculating Hours");
			System.out.println("7. Finding Number of Distinct Resources");
			System.out.println("8. Save&Exit");
			mainMenuSelectionHandler(genericIOFunctions.intInputHandler(),mediator);
		}
	}
	private void mainMenuSelectionHandler(int selection, Mediator mediator) throws ParseException, CustomExceptions.EmptyFieldNotAllowedException, CustomExceptions.NotAcceptedDateFormat, CustomExceptions.ProjectNotFoundException, IOException {
		switch (selection){
			case 1:
				genericIOFunctions.printProjects(mediator);
				break;
			case 2:
				submenuCreator(mediator);
				break;
			case 3:
				submenuRemover(mediator);
				break;
			case 4:
				if(!mediator.listProjects().isEmpty()){
					int projectIndex = genericIOFunctions.projectSelector(mediator);
					projectUpdateOpsHandler(projectIndex,mediator);
				}else{
					System.out.println("There is no project to update.");
				}
				break;
			case 5:
				resourceOps(mediator);
				break;
			case 6:
				timeOps(mediator);
				break;
			case 7:
				System.out.println("Distinct Resources: " + mediator.findNumberOfDistinctPerson());
				break;
			case 8:
				mediator.exitSave();
				System.exit(1);
				break;
			default:
				System.out.println("You have entered invalid input. Please re-enter.");
		}
	}

	private void timeOps(Mediator mediator){
		System.out.println("Please select hour you want to calculate:");
		System.out.println("1- Project");
		System.out.println("2- Activity");
		System.out.println("3- Task");
		int selection = genericIOFunctions.intInputHandler();
		switch (selection){
			case 1:
				int project = genericIOFunctions.projectSelector(mediator);
				System.out.println("This project will be finished in hours: "+mediator.calculateProjectHours(project));
				break;
			case 2:
				int projectAct = genericIOFunctions.projectSelector(mediator);
				int activity = genericIOFunctions.activitySelector(projectAct,mediator);
				System.out.println("This activity will be finished in hours: "+mediator.calculateActivityHours(projectAct,activity));
				break;
			case 3:
				int prjTask = genericIOFunctions.projectSelector(mediator);
				int actTask = genericIOFunctions.activitySelector(prjTask,mediator);
				int task  =genericIOFunctions.taskSelector(prjTask,mediator,actTask);
				System.out.println("This task will be finished in hours: "+mediator.calculateTaskHours(prjTask,actTask,task));
				break;
			default:
				System.out.println("You have entered invalid input. Please re-enter.");
		}
	}

	private void resourceOps(Mediator mediator){
		System.out.println("Select operation");
		System.out.println("1. Assign a resource to a task");
		System.out.println("2. Unassign a resource from a task");
		int resourceOps = genericIOFunctions.intInputHandler();
		switch (resourceOps){
			case 1:
				int rscAssign = genericIOFunctions.resourceSelector(mediator);
				int prjAssign = genericIOFunctions.projectSelector(mediator);
				int actAssign = genericIOFunctions.activitySelector(prjAssign,mediator);
				int tskAssign = genericIOFunctions.taskSelector(prjAssign,mediator, actAssign);
				int assignResult = mediator.assignResource(prjAssign,actAssign,tskAssign,rscAssign);
				if(assignResult==1) System.out.println("Resource is assigned to task successfully");
				else System.out.println("Something went wrong. Please try again.");
				break;
			case 2:
				int prjUnassign = genericIOFunctions.projectSelector(mediator);
				int actUnassign = genericIOFunctions.activitySelector(prjUnassign,mediator);
				int tskUnassign = genericIOFunctions.taskSelector(prjUnassign,mediator, actUnassign);
				int unassignResult = mediator.unassignResource(prjUnassign,actUnassign,tskUnassign);
				if(unassignResult==1) System.out.println("Resource is unassigned succesfully.");
				else System.out.println("Something went wrong. Please try again.");
				break;

		}

	}

	private void submenuRemover(Mediator mediator) {
		System.out.println("Please select what you want to remove:");
		System.out.println("1- Project");
		System.out.println("2- Activity");
		System.out.println("3- Task");
		int selection = genericIOFunctions.intInputHandler();
		switch (selection){
			case 1:
				int projectRemoveResult = mediator.removeProject(genericIOFunctions.projectSelector(mediator));
				if(projectRemoveResult==1){
					System.out.println("Project removed successfully");
				}else{
					System.out.println("Something went wrong.");
				}
				break;
			case 2:
				int actRemoveProject = genericIOFunctions.projectSelector(mediator);
				int actRemoveActivity = genericIOFunctions.activitySelector(actRemoveProject,mediator);
				int activityRemoveResult = mediator.removeActivity(actRemoveProject,actRemoveActivity);
				if(activityRemoveResult==1){
					System.out.println("Activity removed successfully");
				}else{
					System.out.println("Something went wrong.");
				}
				break;
			case 3:
				int taskRemoveProject = genericIOFunctions.projectSelector(mediator);
				int taskRemoveActivity = genericIOFunctions.activitySelector(taskRemoveProject,mediator);
				int taskRemoveTask = genericIOFunctions.taskSelector(taskRemoveProject,mediator,taskRemoveActivity);
				int	taskRemoveResult = mediator.removeTask(taskRemoveProject,taskRemoveActivity,taskRemoveTask);
				if(taskRemoveResult==1){
					System.out.println("Task removed successfully");
				}else{
					System.out.println("Something went wrong.");
				}
				break;
		}
	}

	private void projectUpdateOpsHandler(int projectIndex,Mediator mediator) throws CustomExceptions.EmptyFieldNotAllowedException, CustomExceptions.NotAcceptedDateFormat, ParseException {
		System.out.println("Please select what you want to update:");
		System.out.println("1- Project");
		System.out.println("2- Activity");
		System.out.println("3- Task");
		int selection = genericIOFunctions.intInputHandler();
		switch (selection){
			case 1:
				projectUpdater.projectUpdateMenu(projectIndex,mediator);
				break;
			case 2:
				int activityNumber = genericIOFunctions.activitySelector(projectIndex,mediator);
				activityUpdater.activityUpdateMenu(projectIndex,activityNumber,mediator);
				break;
			case 3:
				int activityForTask = genericIOFunctions.activitySelector(projectIndex,mediator);
				int taskNumberSelector = genericIOFunctions.taskSelector(projectIndex,mediator,activityForTask);
				taskUpdater.taskUpdateMenu(projectIndex,activityForTask,taskNumberSelector,mediator);
				break;
			default:
				System.out.println("You have selected invalid choice. Please enter integer in given range.");
		}

	}

	private void submenuCreator(Mediator mediator) throws ParseException, CustomExceptions.NotAcceptedDateFormat, CustomExceptions.EmptyFieldNotAllowedException, CustomExceptions.ProjectNotFoundException {
		System.out.println("Please choose to operate:");
		System.out.println("1-Project");
		System.out.println("2-Activity");
		System.out.println("3-Task");
		System.out.println("4-Resource");
		int submenuSelection = genericIOFunctions.intInputHandler();
		switch (submenuSelection){
			case 1:
				System.out.println("Enter the project name, description and date as comma separated(Ex. date: 2018-10-31).");
				String[] projectInput = genericIOFunctions.stringInputHandler();
				try{
					mediator.createProject(projectInput[0],projectInput[1],projectInput[2]);
				}catch (IndexOutOfBoundsException e){
					System.out.println("You have entered more parameters than needed.");
				}
				break;
			case 2:
				int projectSelAct = genericIOFunctions.projectSelector(mediator);
				System.out.println("Please enter description, start date and deliverable as comma seperated for activity: ");
				String[] activityToCreate = genericIOFunctions.stringInputHandler();
				mediator.addActivity(projectSelAct,activityToCreate[0],activityToCreate[1],activityToCreate[2]);
				break;
			case 3:
				int projectSelTask = genericIOFunctions.projectSelector(mediator);
				int activitySelTask = genericIOFunctions.activitySelector(projectSelTask,mediator);
				System.out.println("Please enter description, start date, hours and resource as comma seperated for task: ");
				String[] taskInput= genericIOFunctions.stringInputHandler();
				int resourceSelection = genericIOFunctions.resourceSelector(mediator);
				mediator.addTask(projectSelTask,activitySelTask,taskInput[0],taskInput[1],Integer.parseInt(taskInput[2]),resourceSelection);
				break;
			case 4:
				System.out.println("Type of the resource:");
				System.out.println("1- Employee");
				System.out.println("2- Consultant");
				int typeSelection = genericIOFunctions.intInputHandler();
				System.out.println("Name :");
				String name = genericIOFunctions.stringLineInputHandler();
				System.out.println("Last Name :");
				String lastName = genericIOFunctions.stringLineInputHandler();
				mediator.addResource(typeSelection,name,lastName);
				break;
			default:
				System.out.println("You have entered wrong input try again.");
		}

	}
}
