package businessLayer.Factory;

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getMonitor();
    public abstract String getHeadphone();
    public abstract String getMouse();
    public abstract String getKeyboard();

    @Override
    public String toString(){
        return  getRAM()
                + "\n" + getCPU()
                + "\n" + getMonitor()
                + "\n" + getHeadphone()
                + "\n" + getMouse()
                + "\n" + getKeyboard();

    }
	public abstract double getTotalPrice();
	
	public abstract void setTotalPrice(double cablePrice);
	
}
