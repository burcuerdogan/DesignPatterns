package presentationLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericIOFunctions {

    public String[] stringInputHandler(String infoMsg){
        System.out.println(infoMsg);
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return input.split(",");
    }
    public String stringLineInputHandler(String infoMsg){
        System.out.println(infoMsg);
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

}

