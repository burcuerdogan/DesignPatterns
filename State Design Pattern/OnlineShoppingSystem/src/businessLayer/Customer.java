package businessLayer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int countId = 0;
    private int id;
    private String name;
    private String address;
    private Double savings;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private transient List<Order> orderList;

    public Customer(String name, String address, String savings, String phoneNumber, String emailAddress, String password) {
        setId();
        setName(name);
        setAddress(address);
        setSavings(savings);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        setPassword(password);
        orderList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        countId = countId + 1;
        this.id = countId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        double value = Double.parseDouble(savings);
        this.savings = value;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        if(orderList==null){
            return (new ArrayList<>());
        }
        return orderList;
    }

    public void addOrder(Order o){
        if(orderList==null){
            orderList = new ArrayList<>();
        }
        orderList.add(o);
    }

    public void saveOrder(Shopping shopping){
        shopping.saveOrder();
    }

    public void submitOrder(Shopping shopping){
        shopping.submitOrder();
    }

    public void cancelOrder(Shopping shopping){
        shopping.cancelOrder();
    }

    public void deleteOrder(Shopping shopping){
        cancelOrder(shopping);
    }

    public String toString() {
        return "Customer id: " + id + " name: " + name + " address: " + address + " phone number: " + phoneNumber + " email address: " + emailAddress;
    }


}
