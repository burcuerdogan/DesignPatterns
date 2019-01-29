package businessLayer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	private String address;
	private List<Order> savings;
	private String phoneNumber;
	private String emailAddress;
	private String password;
	
	public Customer(int id, String name, String address, String phoneNumber, String emailAddress, String password)
	{
		savings=new ArrayList<Order>();
		setId(id);
		setName(name);
		setAdress(address);
		setPhoneNumber(phoneNumber);
		setEmailAddress(emailAddress);
		setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
	public List<Order> getSavings() {
		return savings;
	}
	public void addSaving(Order order) {
		savings.add(order);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
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
	
	//TODO saveOrder
	//TODO submitOrder
	//TODO cancelOrder
	//TODO deleteOrder
	
	public String toString()
	{
		return "Customer id: "+id+" name: "+name+" address: "+address+" phone number: "+phoneNumber+" email address: "+emailAddress;
	}
		
	
	
}
