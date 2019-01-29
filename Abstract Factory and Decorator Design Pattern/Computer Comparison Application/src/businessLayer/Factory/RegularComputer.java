package businessLayer.Factory;

import businessLayer.Devices.*;
import businessLayer.GenericHelperFunctions;

public class RegularComputer extends Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;
    private Headphone headphone;
    private CPU cpu;
    private RAM ram;
    private double totalPrice;
    public RegularComputer(){
        this.keyboard = new Keyboard(GenericHelperFunctions.randomNumberGenerator(80,450),false);
        this.mouse = new Mouse(GenericHelperFunctions.randomNumberGenerator(27,78),true);
        this.monitor = new Monitor(GenericHelperFunctions.randomNumberGenerator(900,1500));
        this.headphone = new Headphone(
                GenericHelperFunctions.randomNumberGenerator(40,400),
                true,
                false);
        this.cpu = new CPU(GenericHelperFunctions.randomNumberGenerator(8000,12000));
        this.ram = new RAM(GenericHelperFunctions.randomNumberGenerator(1500,3500));
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

	@Override
	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}

	public void setTotalPrice() {
		}

	@Override
	public void setTotalPrice(double cablePrice) {
		this.totalPrice = cablePrice+keyboard.getPrice()+mouse.getPrice()+monitor.getPrice()+headphone.getPrice()+cpu.getPrice()+ram.getPrice();
		
	}
}
