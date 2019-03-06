package businessLayer.Cable;

import businessLayer.Factory.Computer;

public class GoldenCable extends CableDecorator {
	private Computer computer;
	
	public GoldenCable(Computer computer) {
		super(computer);
		setCablePrice(computer);
	}
	
	public void setCablePrice(Computer decoratedComputer)
	{
		decoratedComputer.setTotalPrice(500);
	}
	

}
