package businessLayer.Devices;

import businessLayer.GenericHelperFunctions;

public class Monitor implements OutputDevice {

    private double price;
    private int inch;
    private int[] inches = {18,21,25,27};

    public Monitor(double price){
        this.inch = inches[GenericHelperFunctions.randomNumberGenerator(0,3)];
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Monitor " + inch +" inch";
    }
}
