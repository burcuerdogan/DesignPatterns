package businessLayer.Cable;

import businessLayer.Factory.Computer;

public abstract class CableDecorator {
	private Computer decoratedComputer;
	
	public CableDecorator(Computer computer)
	{
		this.decoratedComputer=computer;
	}
	
	public void getTotalPrice()
	{
		decoratedComputer.getTotalPrice();
	}
}
