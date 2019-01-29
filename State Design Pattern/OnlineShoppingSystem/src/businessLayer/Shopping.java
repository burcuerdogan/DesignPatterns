package businessLayer;

public class Shopping {
    private Customer customer;
    private Order order;

    public Shopping(){
        order=new Order();
    }

    public void saveOrder(){
        order.saveOrder(customer);
    }

    public void submitOrder(){
        order.submitOrder(customer);
    }

    public void cancelOrder(){

        System.out.println("delete order shopping");
        order.cancelOrder();
    }

    public void chargeCustomer(){
        order.chargedCustomer(customer);
    }
    public void cancelPayment(){
        order.placeOrder();
    }

    public void shipOrder(){
        order.shippedOrder();
    }

    public void deliverOrder(){
        order.deliveredOrder();
    }

    public void assignOrder(){
        customer.getOrderList().add(order);
    }

    public void assignCustomer(Customer customer){
        this.customer = customer;
    }
}
