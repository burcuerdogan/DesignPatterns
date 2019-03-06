package presentation;

import businessLayer.Mediator;

import java.text.ParseException;

public class TaskUpdateIO {
    private GenericIOFunctions genericIOFunctions = new GenericIOFunctions();
    public void taskUpdateMenu(int projectIndex, int activityNumber, int taskNumber, Mediator mediator) throws ParseException {

        System.out.println("Select what you would like to update:");
        System.out.println("1- Task Description");
        System.out.println("2- Task Start Date");
        System.out.println("3- Task hours");
        int selection = genericIOFunctions.intInputHandler();
        switch (selection){
            case 1:
                System.out.println("Enter the new task description: ");
                String desc = genericIOFunctions.stringLineInputHandler();
                int descResult = mediator.taskUpdater(projectIndex,activityNumber,taskNumber,selection,desc);
                if(descResult==1){
                    System.out.println("Task updated successfully.");
                }
                else{
                    System.out.println("Something went wrong. Please try again.");
                }
                break;
            case 2:
                System.out.println("Enter the new task start date: ");
                String date = genericIOFunctions.stringLineInputHandler();
                int dateResult = mediator.taskUpdater(projectIndex,activityNumber,taskNumber,selection,date);
                if(dateResult==1){
                    System.out.println("Task updated successfully.");
                }
                else{
                    System.out.println("Something went wrong. Please try again.");
                }
                break;
            case 3:
                System.out.println("Enter the new task hours: ");
                String hours = genericIOFunctions.stringLineInputHandler();
                int deliverableResult = mediator.taskUpdater(projectIndex,activityNumber,taskNumber,selection,hours);
                if(deliverableResult==1){
                    System.out.println("Task updated successfully.");
                }
                else{
                    System.out.println("Something went wrong. Please try again.");
                }
                break;
            default:
                System.out.println("Not a valid range for activity update.");
        }
    }

}
