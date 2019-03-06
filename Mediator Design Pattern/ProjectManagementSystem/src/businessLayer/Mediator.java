package businessLayer;

import dataAccessLayer.FileIO;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Mediator {
	private ArrayList<Project> projects;
	private ArrayList<Resource> resources;
	FileIO fileIO;

	public Mediator(){
		projects = new ArrayList<>();
		resources= new ArrayList<>();
	}

	public void initializer() throws IOException, ParseException {
		fileIO = new FileIO();
		projects = new ArrayList<>(Arrays.asList(fileIO.readProjects()));
		resourceExtractor();
	}

	public void exitSave() throws IOException {
		fileIO.saveProjects(projects);
	}

	public void createProject(String projectName, String projectDesc, String startDate) throws ParseException, CustomExceptions.NotAcceptedDateFormat, CustomExceptions.EmptyFieldNotAllowedException {
		Project project= new Project(projectName, projectDesc, startDate);
		this.projects.add(project);
	}
	public void addActivity(int projetIndex, String activityDesc, String activityDate , String activityDel) throws ParseException, CustomExceptions.ProjectNotFoundException {
		Activity act = new Activity(activityDesc,activityDate,activityDel);
		Project prj = projects.get(projetIndex);
		try{
			prj.addActivity(act);
		}catch (NullPointerException e){
			throw new CustomExceptions.ProjectNotFoundException("Something went wrong. Try again.", e);
		}
	}
	public void addTask(int projectIndex, Integer activityNumber, String taskDesc,String taskStartDate, Integer taskHours, Integer resourceId) throws ParseException {
		Task tsk = new Task(taskDesc,taskStartDate,taskHours,resourceId);
		Project prj = projects.get(projectIndex);
		ArrayList<Activity> acts = prj.getActivities();
		for(Activity act : acts){
			if(act.getNumber().equals(activityNumber)){
				act.addTask(tsk);
			}
		}

	}

	public void addResource(int type, String name, String lastName){
		if(type==1){
			Resource rc = new Employee(name,lastName);
			resources.add(rc);
		}else if(type==2){
			Resource rc = new Consultant(name,lastName);
			resources.add(rc);
		}
	}

	public int removeProject(int projectIndex){
		try {
			projects.remove(projectIndex);
			return 1;
		}catch (IndexOutOfBoundsException e){
			return -1;
		}
	}

	public int removeActivity(int projectIndex, int activityNumber){
		try{
			projects.get(projectIndex).getActivities().remove(activityNumber);
			return 1;
		}catch (IndexOutOfBoundsException e){
			return -1;
		}
	}

	public int removeTask(int projectIndex, int activityNumber, int taskNumber){
		try{
			projects
					.get(projectIndex)
					.getActivities()
					.get(activityNumber)
					.getTasks()
					.remove(taskNumber);
			return 1;
		}catch (IndexOutOfBoundsException e){
			return -1;
		}
	}

	public int assignResource(int project, int activity, int taskNumber,int resourceId){
		taskExtractor(project,activity,taskNumber).setResourceId(resourceId);
		return 1;
	}

	public int unassignResource(int project, int activity, int taskNumber){
		taskExtractor(project,activity,taskNumber).setResourceId(null);
		return 1;
	}

	public ArrayList<String> getActivitiesForProject(int projectIndex){
		ArrayList<String> activities = new ArrayList<>();
		ArrayList<Activity> tempSelected = projects.get(projectIndex).getActivities();
		for(Activity act : tempSelected){
			activities.add(act.toString());
		}
		return activities;
	}

	public ArrayList<String> getTasksForActivity(int projectIndex, int activityNumber){
		ArrayList<String> tasks = new ArrayList<>();
		ArrayList<Task> tempSelectedTask = projects.get(projectIndex).getActivities().get(activityNumber).getTasks();
		for(Task task : tempSelectedTask){
			tasks.add(task.toString());
		}
		return tasks;
	}


	public int projectUpdater(int projectIndex,int selectedField ,String newValue) throws
			CustomExceptions.EmptyFieldNotAllowedException,
			ParseException,
			CustomExceptions.NotAcceptedDateFormat {
		switch (selectedField){
			case 1:
				projects.get(projectIndex).setName(newValue);
				return 1;
			case 2:
				projects.get(projectIndex).setDesc(newValue);
				return 1;
			case 3:
				projects.get(projectIndex).setStartDate(newValue);
				return 1;
			default:
				return -1;
		}
	}

	public int activityUpdater(int projectIndex,int activityNumber, int selectedField, String newValue) throws ParseException {
		Activity temp = activityExtractor(projectIndex,activityNumber);
		switch (selectedField){
			case 1:
				temp.setDesc(newValue);
				return 1;
			case 2:
				temp.setStartDate(newValue);
				return 1;
			case 3:
				temp.setDeliverable(newValue);
				return 1;
			default:
				return -1;
		}
	}

	public int taskUpdater(int projectIndex,int activityNumber,int taskNumber ,int selectedField, String newValue) throws ParseException {
		Task temp = taskExtractor(projectIndex,activityNumber,taskNumber);
		switch (selectedField){
			case 1: //For description
				temp.setDesc(newValue);
				return 1;
			case 2: // date
				temp.setStartDate(newValue);
				return 1;
			case 3:
				temp.setHours(Integer.parseInt(newValue));
				return 1;
			case 4:
				temp.setResourceId(Integer.parseInt(newValue));
			default:
				return -1;
		}
	}

	private void resourceExtractor(){
		for(Project prj : projects){
			for(Activity act : prj.getActivities()){
				for(Task tsk : act.getTasks()){
					if(resourceCheck(tsk.getResourceId())){
						Resource rc = new Resource(tsk.getResourceId());
						resources.add(rc);
					}
				}
			}
		}
	}

	private boolean resourceCheck(int resourceId){
		for (Resource rc : resources){
			if(rc.getResourceId() == resourceId){
				return false;
			}
		}
		return true;
	}

	public int calculateProjectHours(int project) {
		return projects.get(project).calculateHours();
	}
	public int calculateActivityHours(int project, int activity) {
		return activityExtractor(project,activity).getHours();
	}
	public int calculateTaskHours(int project, int activity, int task) {
		return taskExtractor(project,activity,task).getHours();
	}
	public Integer findNumberOfDistinctPerson() {
		return resources.size();
	}

	private ArrayList<Resource> getResources() {
		return resources;
	}

	private void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}
	private Task taskExtractor(int projectIndex,int activityNumber,int taskNumber){
		// returns task with given conditions.
		return projects.get(projectIndex).getActivities().get(activityNumber).getTasks().get(taskNumber);
	}
	private Activity activityExtractor(int projectIndex, int activityNumber){
		return projects.get(projectIndex).getActivities().get(activityNumber);
	}


	public ArrayList<String> listResources(){
		ArrayList<String> allResources = new ArrayList<>();
		for(Resource rc : this.resources){
			allResources.add(rc.toString());
		}
		return allResources;
	}

	public ArrayList<String> listProjects() {
		ArrayList<String> allProjects= new ArrayList<>();
		for(Project project:this.projects)
		{
			allProjects.add(project.toString());
		}
		return allProjects;
	}

	public ArrayList<Project> getProjects(){
		return projects;
	}
}
