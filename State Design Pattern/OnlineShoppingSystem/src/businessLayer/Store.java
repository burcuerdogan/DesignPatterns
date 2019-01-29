package businessLayer;

import dataAccessLayer.FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private FileIO fileIO;
    private List<Customer> customerList;

    public Store() throws IOException {
        fileIO = new FileIO();
        customerList = fileIO.readCustomers();
        assignOrders(fileIO.readOrders());
    }

    private void assignOrders(List<Order> readOrders) {
        for (Order o : readOrders) {
            if (getCustomer(o.getCustomerId()) != null) {
                getCustomer(o.getCustomerId()).addOrder(o);
            }
        }
    }

    public Customer addCustomer(String[] arr) {
        Customer newCustomer = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        customerList.add(newCustomer);
        return newCustomer;
    }

    public boolean checkCustomer(String name, String password) {
        for (Customer c : customerList) {
            if (c.getName().equals(name) && c.getPassword().equals(password)) return true;
        }
        return false;
    }

    public Customer getCustomer(String name) {
        for (Customer c : customerList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    private Customer getCustomer(int id) {
        for (Customer c : customerList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void chargeCustomer(Shopping shopping) {
        shopping.chargeCustomer();
    }

    public void shipOrder(Shopping shopping) {
        shopping.shipOrder();
    }

    public void deliverOrder(Shopping shopping) {
        shopping.deliverOrder();
    }

    public void exitSave() throws IOException {
        List<Order> deliveredOrders = new ArrayList<>();
        for (Customer c : customerList) {
            deliveredOrders.addAll(c.getOrderList());
        }
        fileIO.saveAll(customerList, deliveredOrders);
    }

}
