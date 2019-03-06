package businessLayer;

public class Consultant extends Person {

	public Consultant(String name, String lastName)
	{
		super(name,lastName);
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getLastName() {
		return super.getLastName();
	}
	
}
