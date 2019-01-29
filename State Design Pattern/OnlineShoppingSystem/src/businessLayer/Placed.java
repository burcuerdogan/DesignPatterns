package businessLayer;

import java.util.Random;

public class Placed implements State {
    @Override
    public void doShopping(Order context) {
        calculatePrice(context);
        context.setState(new Charged());
    }

    public void calculatePrice(Order order){

        Random rnd = new Random();
        int deliveryDistance = rnd.nextInt(400) + 100;
        Double cargoPrice = 0.53 * deliveryDistance;
        Double productPrice = (double) (order.getWeight() * 55);

        order.setCargoPrice(cargoPrice);
        order.setProductPrice(productPrice);

    }

}
