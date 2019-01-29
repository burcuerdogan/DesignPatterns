package businessLayer.Cable;

import businessLayer.Factory.Computer;

public class DefaultCable extends CableDecorator {
	private Computer computer;
	
	public DefaultCable(Computer computer) {
		super(computer);
		setCablePrice(computer);
	}
	
	public void setCablePrice(Computer decoratedComputer)
	{
		decoratedComputer.setTotalPrice(0);
	}

}
