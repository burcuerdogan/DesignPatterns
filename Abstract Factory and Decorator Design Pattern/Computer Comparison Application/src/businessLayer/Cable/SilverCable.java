package businessLayer.Cable;

import businessLayer.Factory.Computer;

public class SilverCable extends CableDecorator{
	private Computer computer;
	
	public SilverCable(Computer computer) {
		
		super(computer);
		setCablePrice(computer);
	}
	
	public void setCablePrice(Computer decoratedComputer)
	{
		decoratedComputer.setTotalPrice(350);
	}
}
