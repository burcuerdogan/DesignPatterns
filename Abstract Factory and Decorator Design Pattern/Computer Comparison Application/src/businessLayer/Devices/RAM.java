package businessLayer.Devices;

import businessLayer.GenericHelperFunctions;

public class RAM implements HardwareDevice {

    private double price;
    private int capacity;

    public RAM(double price){
        this.capacity = (int) Math.pow(2, GenericHelperFunctions.randomNumberGenerator(5,9,5));
        setPrice(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "RAM capacity " + capacity;
    }
}
