package businessLayer.Devices;

import businessLayer.GenericHelperFunctions;

public class Keyboard implements InputDevice {

    private double price;
    private int numberOfKeys;
    private  boolean hasBacklight;

    public Keyboard(double price, boolean hasBacklight){
        setNumberOfKeys(GenericHelperFunctions.randomNumberGenerator(84,109));
        setPrice(price);
        setHasBacklight(hasBacklight);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void setNumberOfKeys(int numberOfKeys){
        this.numberOfKeys = numberOfKeys;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public boolean isHasBacklight() {
        return hasBacklight;
    }

    public void setHasBacklight(boolean hasBacklight) {
        this.hasBacklight = hasBacklight;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Keyboard has " + numberOfKeys +" keys" + " , Backlight is " + hasBacklight;
    }
}
