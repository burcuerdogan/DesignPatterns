package business;

public class NewStateObserver implements IStateObserver {

	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is New");
		p.setState(new NewStateObserver());
	}

}
