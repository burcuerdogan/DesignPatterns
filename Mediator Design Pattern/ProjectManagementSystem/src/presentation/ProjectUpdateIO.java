package presentation;

import businessLayer.CustomExceptions;
import businessLayer.Mediator;

import java.text.ParseException;

public class ProjectUpdateIO {
    private GenericIOFunctions genericIOFunctions = new GenericIOFunctions();
    public void projectUpdateMenu(int projectIndex,Mediator mediator) throws CustomExceptions.EmptyFieldNotAllowedException,
            ParseException,
            CustomExceptions.NotAcceptedDateFormat {
        System.out.println("Select what you would like to update:");
        System.out.println("1- Project Name");
        System.out.println("2- Project Description");
        System.out.println("3- Start Date");
        int selection = genericIOFunctions.intInputHandler();
        switch (selection){
            case 1:
                System.out.println("Enter a project name:");
                String nameInput = genericIOFunctions.stringLineInputHandler();
                int nameResult = mediator.projectUpdater(projectIndex,selection,nameInput);
                if(nameResult<0){
                    System.out.println("Something went wrong. Please try again.");
                }
                else {
                    System.out.println("All changes made.");
                }
                break;
            case 2:
                System.out.println("Enter a project description:");
                String descInput = genericIOFunctions.stringLineInputHandler();
                int descResult = mediator.projectUpdater(projectIndex,selection,descInput);
                if(descResult<0){
                    System.out.println("Something went wrong. Please try again.");
                }
                else {
                    System.out.println("All changes made.");
                }
                break;
            case 3:
                System.out.println("Enter project date:");
                String dateInput = genericIOFunctions.stringLineInputHandler();
                int dateResult = mediator.projectUpdater(projectIndex,selection,dateInput);
                if(dateResult<0){
                    System.out.println("Something went wrong. Please try again.");
                }
                else {
                    System.out.println("All changes made.");
                }
                break;
            default:
                System.out.println("You have entered invalid integer.");
        }
    }
}
