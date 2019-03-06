package businessLayer;

import java.util.Random;

public class Saved implements State {
    private static int counter;

    @Override
    public void doShopping(Order context) {
        context.setState(new Placed());
    }

    public void setOrderInfo(Customer customer, Order context) {

        counter = counter + 1;
        context.setId(counter);
        Random rnd = new Random();
        int trackingNumber = rnd.nextInt(999999);
        String.format("%06d", trackingNumber);

        context.setTrackingNumber(trackingNumber);
        context.setCustomerId(customer.getId());
        context.setCustomerName(customer.getName());
        context.setShippingAddress(customer.getAddress());
    }

    public void saveOrder(Order context) {
        System.out.println(context);
        context.setState(this);
    }

}
