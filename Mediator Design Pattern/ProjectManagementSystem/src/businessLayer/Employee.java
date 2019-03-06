package businessLayer;

public class Employee extends Person{

	public Employee(String name, String lastName)
	{
		super(name,lastName);
	}
	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getLastName() {
		return super.getLastName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

}
