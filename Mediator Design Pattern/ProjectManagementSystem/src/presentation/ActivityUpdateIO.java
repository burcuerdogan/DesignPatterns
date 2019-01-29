package presentation;

import businessLayer.Mediator;

import java.text.ParseException;

public class ActivityUpdateIO {
    private GenericIOFunctions genericIOFunctions = new GenericIOFunctions();
    public void activityUpdateMenu(int projectIndex, int activityNumber,Mediator mediator) throws ParseException {

        System.out.println("Select what you would like to update:");
        System.out.println("1- Activity Description");
        System.out.println("2- Start Date");
        System.out.println("3- Deliverable");
        int selection = genericIOFunctions.intInputHandler();
        switch (selection){
            case 1:
                System.out.println("Enter the new activity description: ");
                String desc = genericIOFunctions.stringLineInputHandler();
                int descResult = mediator.activityUpdater(projectIndex,activityNumber,selection,desc);
                if(descResult==1){
                    System.out.println("Activity updated successfully.");
                }
                else{
                    System.out.println("Something went wrong. Please try again.");
                }
                break;
            case 2:
                System.out.println("Enter the new activity start date: ");
                String date = genericIOFunctions.stringLineInputHandler();
                int dateResult = mediator.activityUpdater(projectIndex,activityNumber,selection,date);
                if(dateResult==1){
                    System.out.println("Activity updated successfully.");
                }
                else{
                    System.out.println("Something went wrong. Please try again.");
                }
                break;
            case 3:
                System.out.println("Enter the new activity description: ");
                String deliverable = genericIOFunctions.stringLineInputHandler();
                int deliverableResult = mediator.activityUpdater(projectIndex,activityNumber,selection,deliverable);
                if(deliverableResult==1){
                    System.out.println("Activity updated successfully.");
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
