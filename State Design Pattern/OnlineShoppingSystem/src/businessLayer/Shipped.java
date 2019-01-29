package businessLayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Shipped implements State {
    @Override
    public void doShopping(Order context) {
        planShipping(context);
    }

    public boolean planShipping(Order context){

        Random rnd = new Random();
        int realShippingDurationDay = rnd.nextInt(9) + 1;
        int plannedShippingDurationDay = rnd.nextInt(9) + 1;

        if (realShippingDurationDay - plannedShippingDurationDay > 7){
            context.setState(new Charged());
            System.out.println("Order is not shipped.");
            return false;
        }
        else{
            context.setState(new Delivered());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            context.setDateShipped(dtf.format(localDate));
            return true;
        }
    }
}
