package businessLayer;

import java.util.Date;

public class Order {
	private int id;
	private Integer trackingNumber;
	private int customerId;
	private String customerName;
	private Double weight;
	private String shippingAddress;
	private Date dateShipped;
	private Date dateDelivered;
	private Double productPrice;
	private Double cargoPrice;
	private Double totalPrice;
	private State state;
	
	public Order(int id, Integer trackingNumber, int customerId, String customerName, Double weight,
			String shippingAddress, Date dateShipped, Date dateDelivered, Double productPrice, Double cargoPrice,
			Double totalPrice, State state) {
		setId(id);
		setTrackingNumber(trackingNumber);
		setCustomerId(customerId);
		setCustomerName(customerName);
		setWeight(weight);
		setShippingAddress(shippingAddress);
		setDateShipped(dateShipped);
		setDateDelivered(dateDelivered);
		setProductPrice(productPrice);
		setCargoPrice(cargoPrice);
		setTotalPrice(totalPrice);
		setState(state);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(Integer trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(Date dateShipperd) {
		this.dateShipped = dateShipperd;
	}
	public Date getDateDelivered() {
		return dateDelivered;
	}
	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getCargoPrice() {
		return cargoPrice;
	}
	public void setCargoPrice(Double cargoPrice) {
		this.cargoPrice = cargoPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", trackingNumber=" + trackingNumber + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", weight=" + weight + ", shippingAddress=" + shippingAddress
				+ ", dateShipped=" + dateShipped + ", dateDelivered=" + dateDelivered + ", productPrice=" + productPrice
				+ ", cargoPrice=" + cargoPrice + ", totalPrice=" + totalPrice + ", state=" + state + "]";
	}

}
