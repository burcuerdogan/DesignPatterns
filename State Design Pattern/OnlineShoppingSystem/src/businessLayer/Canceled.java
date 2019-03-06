package businessLayer;

public class Canceled implements State {
    @Override
    public void doShopping(Order context) {
        System.out.println("canceled state");
        context.setState(new Canceled());

    }
}
