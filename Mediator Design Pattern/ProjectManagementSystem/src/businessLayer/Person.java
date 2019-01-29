package businessLayer;

public abstract class Person extends Resource{
	private String name;
	private String lastName;

	public Person(Integer resourceId) {
		super(resourceId);
	}
	public Person(String name, String lastName){
		setName(name);
		setLastName(lastName);
	}

	public void setName(String name){
		this.name = name;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getName(){
		return name;
	}

	public String getLastName(){
		return lastName;
	}

	public String toString(){
		return ("Resource ID: " + getResourceId()
				+ "\nName: " + getName()
				+"\nLast name: "+getLastName());
	}
}
