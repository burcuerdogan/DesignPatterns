package businessLayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Delivered implements State {
    @Override
    public void doShopping(Order context) {
        planDelivery(context);
    }

    public boolean planDelivery(Order context){

        Random rnd = new Random();
        int realDeliveryDurationDay = rnd.nextInt(9) + 3;
        int plannedDeliveryDurationDay = rnd.nextInt(9) + 3;

        if (realDeliveryDurationDay - plannedDeliveryDurationDay > 8){
            context.setState(new Charged());
            System.out.println("Lost in shipping.");
            return false;
        }
        else{
            context.setState(new Canceled());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            localDate = localDate.plusDays(realDeliveryDurationDay);
            context.setDateDelivered(dtf.format(localDate));
            return true;
        }
    }
}
