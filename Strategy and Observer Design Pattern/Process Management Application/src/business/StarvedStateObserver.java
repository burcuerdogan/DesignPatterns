package business;

public class StarvedStateObserver implements IStateObserver{
	public void update(Process p) {
		System.out.println("Process "+p.getId()+" state is Starved");
		p.setState(new StarvedStateObserver());
	}
}
