package businessLayer.Devices;

public class Mouse implements InputDevice {

    private double price;
    private boolean isWireless;

    public Mouse(double price, boolean isWireless){
        setPrice(price);
        setWireless(isWireless);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Mouse Wireless " + isWireless;
    }
}
