package businessLayer;

import java.util.Random;

public class Order {
    private int id;
    private Integer trackingNumber;
    private int customerId;
    private String customerName;
    private int weight;
    private String shippingAddress;
    private String dateShipped;
    private String dateDelivered;
    private Double productPrice;
    private Double cargoPrice;
    private Double totalPrice;
    private transient State state;

    private transient Saved saved;
    private transient Placed placed;
    private transient Charged charged;
    private transient Shipped shipped;
    private transient Delivered delivered;
    private transient Canceled canceled;

    public Order() {
        saved = new Saved();
        placed = new Placed();
        charged = new Charged();
        shipped = new Shipped();
        delivered = new Delivered();
        canceled = new Canceled();
        setWeight();
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
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

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public int getWeight() {

        return weight;
    }

    public void setWeight() {

        Random rnd = new Random();
        int weight = rnd.nextInt(10) + 1;
        this.weight = weight;
    }

    public void setShippingAddress(String shippingAddress) {

        this.shippingAddress = shippingAddress;
    }

    public void setDateShipped(String dateShipped) {

        this.dateShipped = dateShipped;
    }

    public void setDateDelivered(String dateDelivered) {

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

    public void setState(State state) {

        this.state = state;
    }

    public void saveOrder(Customer customer) {
        saved.setOrderInfo(customer, this);
        saved.saveOrder(this);
    }

    public void submitOrder(Customer customer) {

        placed.calculatePrice(this);
        saved.doShopping(this);
    }

    public void cancelOrder() {
        canceled.doShopping(this);
    }

    public void placeOrder() {
        placed.doShopping(this);
    }

    public void chargedCustomer(Customer customer) {
        charged.calculateTotalPrice(this);
        charged.checkSavings(customer, this);
    }

    public void shippedOrder() {
        shipped.doShopping(this);
    }

    public void deliveredOrder() {
        delivered.doShopping(this);
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", trackingNumber=" + trackingNumber + ", customerId=" + customerId
                + ", customerName=" + customerName + ", weight=" + weight + ", shippingAddress=" + shippingAddress
                + ", dateShipped=" + dateShipped + ", dateDelivered=" + dateDelivered + ", productPrice=" + productPrice
                + ", cargoPrice=" + cargoPrice + ", totalPrice=" + totalPrice + ", state=" + state + "]";
    }

}
