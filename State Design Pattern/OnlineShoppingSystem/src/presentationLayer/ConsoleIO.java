package presentationLayer;

import businessLayer.Customer;
import businessLayer.Shopping;
import businessLayer.Store;

import java.io.IOException;

public class ConsoleIO {

    GenericIOFunctions genericIOFunctions = new GenericIOFunctions();

    public void startUserInterface(Store store, Shopping shopping) throws IOException {
        while (true) {
            System.out.println("......Welcome......");
            System.out.println("Please type a number to select your operation.");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Save&Exit");
            mainMenuSelectionHandler(genericIOFunctions.intInputHandler(), store, shopping);
        }
    }

    private void mainMenuSelectionHandler(int selection, Store store, Shopping shopping) throws IOException {
        switch (selection) {
            case 1:
                String[] arr = genericIOFunctions.stringInputHandler("Please enter name, address, money, phone, e-mail," +
                        " password.\nExample input: dilek,iyte,1000,123,123@email,123456");
                Customer c = store.addCustomer(arr);
                shopping.assignCustomer(c);
                shoppingStarter(c, store, shopping);
                break;
            case 2:
                String name = genericIOFunctions.stringLineInputHandler("Enter your name: ");
                String password = genericIOFunctions.stringLineInputHandler("Enter your password: ");
                if (store.checkCustomer(name, password)) {
                    shopping.assignCustomer(store.getCustomer(name));
                    shoppingStarter(store.getCustomer(name), store, shopping);
                } else {
                    System.out.println("Invalid name, password");
                }
                break;
            case 3:
                store.exitSave();
                System.exit(1);
                break;
            default:
                System.out.println("You have entered invalid input. Please re-enter.");
        }
    }

    private void shoppingStarter(Customer customer, Store store, Shopping shopping) {
        customer.saveOrder(shopping);
        System.out.println("Order is saved.");
        String delete = genericIOFunctions.stringLineInputHandler("Do you want to delete? Type (y/n)");
        if (delete.equals("n")) {
            customer.submitOrder(shopping);
            System.out.println("Order is submitted.");
            store.chargeCustomer(shopping);
            String chargeControl = genericIOFunctions.stringLineInputHandler("Do you want to cancel? Type (y/n)");
            if (chargeControl.equals("n")) {
                store.shipOrder(shopping);
                System.out.println("Order is shipped.");
                store.deliverOrder(shopping);
                System.out.println("Your order is successfully delivered");
                shopping.assignOrder();

            } else {
                shopping.cancelOrder();
            }
        } else {
            customer.deleteOrder(shopping);
        }
    }
}
