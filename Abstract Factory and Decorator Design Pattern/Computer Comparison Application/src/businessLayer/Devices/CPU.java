package businessLayer.Devices;

import businessLayer.GenericHelperFunctions;

public class CPU implements HardwareDevice {

    private double price;
    private String version;
    private double frequency;

    public CPU(double price){
        this.version = "i" + (GenericHelperFunctions.randomNumberGenerator(0,3)*2+1);
        setPrice(price);
        setFrequency();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVersion(){
        return version;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency() {
        if(this.version.equals("i3")) this.frequency = 2.3;
        else if (this.version.equals("i5")) this.frequency = 3.2;
        else this.frequency = 5.4;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CPU version " + version
                + " , clock speed " + frequency;
    }
}
