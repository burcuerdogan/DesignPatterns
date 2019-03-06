package businessLayer.Devices;

public class Headphone implements OutputDevice {

    private double price;
    private boolean isWireless;
    private boolean hasMicrophone;

    public Headphone(double price, boolean isWireless, boolean hasMicrophone) {
        setPrice(price);
        setWireless(isWireless);
        setHasMicrophone(hasMicrophone);
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

    public boolean isHasMicrophone() {
        return hasMicrophone;
    }

    public void setHasMicrophone(boolean hasMicrophone) {
        this.hasMicrophone = hasMicrophone;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Headphone Wireless " + isWireless
        		+" , Microphone " + hasMicrophone;
    }
}
