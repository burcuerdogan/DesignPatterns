package businessLayer;

public class Charged implements State{
    @Override
    public void doShopping(Order context) {
        context.setState(new Shipped());
    }

    public void calculateTotalPrice(Order order){

        Double totalPrice = order.getCargoPrice() + order.getProductPrice();
        order.setTotalPrice(totalPrice);
    }

    public void checkSavings(Customer customer, Order context){
        if (Double.compare(context.getTotalPrice(), customer.getSavings()) > 0){
            context.setState(new Canceled());
        }
        else{
            doShopping(context);
        }
    }

}
