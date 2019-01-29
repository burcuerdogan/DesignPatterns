package business;

public class TerminatedStateObserver implements IStateObserver{
	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is Terminated");
		p.setState(new BlockedStateObserver());

	}
}
