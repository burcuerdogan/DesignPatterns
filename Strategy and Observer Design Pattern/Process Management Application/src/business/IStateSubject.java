package business;

public interface IStateSubject {

	public void notify(IStateObserver observer, Process process);
	public void attach(IStateObserver observer);
}
