package business;

public class RunningStateObserver implements IStateObserver{

	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is Running");
		p.setState(new BlockedStateObserver());
	}

}
