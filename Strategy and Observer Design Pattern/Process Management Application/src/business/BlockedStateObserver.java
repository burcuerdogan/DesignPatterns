package business;

public class BlockedStateObserver implements IStateObserver{

	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is Blocked");
		p.setState(new BlockedStateObserver());
	}

}
