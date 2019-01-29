package businessLayer;


public class Resource {
	private Integer resourceId;

	public Resource(Integer resourceId) {
		setResourceId(resourceId);
	}

	public Resource() {
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String toString(){
		return ("Resource Id: " + resourceId);
	}
}