package business;

public class ReadyStateObserver implements IStateObserver{

	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is Ready");
		p.setState(new BlockedStateObserver());
	}

}
