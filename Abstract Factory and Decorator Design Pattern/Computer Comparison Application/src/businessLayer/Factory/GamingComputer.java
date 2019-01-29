package businessLayer.Factory;

import businessLayer.Devices.*;
import businessLayer.GenericHelperFunctions;

public class GamingComputer extends Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;
    private Headphone headphone;
    private CPU cpu;
    private RAM ram;
    private double totalPrice;

    public GamingComputer(){
        this.keyboard = new Keyboard(GenericHelperFunctions.randomNumberGenerator(500,1500),true);
        this.mouse = new Mouse(GenericHelperFunctions.randomNumberGenerator(300,850),false);
        this.monitor = new Monitor(GenericHelperFunctions.randomNumberGenerator(2500,3500));
        this.headphone = new Headphone(
                GenericHelperFunctions.randomNumberGenerator(600,1900),
                false,
                true);
        this.cpu = new CPU(GenericHelperFunctions.randomNumberGenerator(14000,24000));
        this.ram = new RAM(GenericHelperFunctions.randomNumberGenerator(7000,19000));
    }

    @Override
    public String getRAM() {
        return ram.toString();
    }

    @Override
    public String getCPU() {
        return cpu.toString();
    }

    @Override
    public String getMonitor() {
        return monitor.toString();
    }

    @Override
    public String getHeadphone() {
        return headphone.toString();
    }

    @Override
    public String getMouse() {
        return mouse.toString();
    }

    @Override
    public String getKeyboard() {
        return keyboard.toString();
    }

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double cablePrice) {
		this.totalPrice = cablePrice+keyboard.getPrice()+mouse.getPrice()+monitor.getPrice()+headphone.getPrice()+cpu.getPrice()+ram.getPrice();
	}


}
