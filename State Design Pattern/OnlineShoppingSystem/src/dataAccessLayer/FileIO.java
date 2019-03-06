package dataAccessLayer;

import businessLayer.Customer;
import businessLayer.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    private String customerFile = "src/dataAccessLayer/customers.json";
    private String orderFile = "src/dataAccessLayer/orders.json";

    public List<Order> readOrders() throws IOException {
        Gson gson = new Gson();
        Order[] readData = gson.fromJson(new FileReader(orderFile), Order[].class);
        List<Order> orders = Arrays.asList(readData);
        return orders;
    }

    public List<Customer> readCustomers() throws IOException {
        Gson gson = new Gson();
        Customer[] readData = gson.fromJson(new FileReader(customerFile), Customer[].class);
        List<Customer> customers = new ArrayList<>();
        customers.addAll(Arrays.asList(readData));
        return customers;
    }


    public void saveAll(List<Customer> customerList, List<Order> deliveredOrders) throws IOException {
        Gson gsonCustomers = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter customerWriter = new FileWriter(customerFile);
        BufferedWriter customerOut = new BufferedWriter(customerWriter);
        gsonCustomers.toJson(customerList, customerOut);
        customerOut.close();

        Gson gsonOrders = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter orderWriter = new FileWriter(orderFile);
        BufferedWriter orderOut = new BufferedWriter(orderWriter);
        gsonOrders.toJson(deliveredOrders, orderOut);
        orderOut.close();
    }
}
