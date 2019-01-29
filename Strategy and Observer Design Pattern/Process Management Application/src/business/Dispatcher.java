package business;

import java.util.LinkedList;
import java.util.Queue;

public class Dispatcher {

	private Queue<Process> readyQueue;
	private IStateSubject subject;
	
	public Dispatcher(Queue<Process> readyQueue, IStateSubject subject)
	{
		this.readyQueue=readyQueue;
		this.subject=subject;
	}
	
	public void extractReadyProcesses()
	{
		//Process readyProcess=readyQueue.remove();
		for(Process p: readyQueue)
		{
			subject.notify(new RunningStateObserver(),p);
				
		}
		CPU cpu = CPU.getInstance();
		cpu.processor(readyQueue, subject);
	}
	
	
}
