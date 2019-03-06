package presentation;

import businessLayer.Mediator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericIOFunctions {
    public void printProjects(Mediator mediator){
        ArrayList<String> projects = mediator.listProjects();
        int projectSize = projects.size();
        for(int i=0;i<projectSize;i++){
            System.out.println(i + "- " + projects.get(i));
        }
    }

    public String[] stringInputHandler(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return input.split(",");
    }
    public String stringLineInputHandler(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int intInputHandler(){
        System.out.println("Your choice:");
        Scanner input = new Scanner(System.in);
        int intSelection;
        while(true){
            try{
                intSelection = input.nextInt();
                return intSelection;
            }
            catch(InputMismatchException e){
                System.out.println("Enter a valid integer that is associated with type.");
                input.next();
            }
        }
    }

    public int projectSelector(Mediator mediator){
        System.out.println("Select the project:");
        ArrayList<String> projects = mediator.listProjects();
        int size= projects.size();
        for(int i=0;i<size;i++){
            System.out.println(i + ". " +projects.get(i));
        }
        return intInputHandler();
    }

    public int activitySelector(int projectIndex, Mediator mediator){
        System.out.println("Select the activity:");
        ArrayList<String> activities = mediator.getActivitiesForProject(projectIndex);
        int size = activities.size();
        for(int i=0;i<size;i++){
            System.out.println(i +". " +activities.get(i));
        }
        return intInputHandler();
    }

    public int taskSelector(int projectIndex, Mediator mediator, int activityNumber){
        System.out.println("Select the task: ");
        ArrayList<String> tasks = mediator.getTasksForActivity(projectIndex,activityNumber);
        int size= tasks.size();
        for(int i=0;i<size;i++){
            System.out.println(i + ". " + tasks.get(i));
        }
        return intInputHandler();
    }

    public int resourceSelector(Mediator mediator){
        System.out.println("Select the resource");
        ArrayList<String> resources = mediator.listResources();
        int size = resources.size();
        for(int i=0;i<size;i++){
            System.out.println(i + ". " + resources.get(i));
        }
        return intInputHandler();
    }

}
