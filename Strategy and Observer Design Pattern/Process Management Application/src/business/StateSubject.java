package business;

import java.util.ArrayList;
import java.util.List;

public class StateSubject implements IStateSubject {

	
	private List<IStateObserver> observerList = new ArrayList<IStateObserver>();
	
	public StateSubject()
	{
	}

	public void attach(IStateObserver observer)
	{
		observerList.add(observer);
	}
	
	public void notify(IStateObserver observer, Process process) {
		observer.update(process);		
	}

}
