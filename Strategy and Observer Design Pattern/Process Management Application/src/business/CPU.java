package business;

import java.util.Queue;

public class CPU {

	private static CPU cpu;
	private CPU()
	{
		
	}

	public static CPU getInstance()
	{
		if (cpu==null) 
		{
			cpu=new CPU();
			
		}
		return cpu;
	}
	
	public void processor(Queue<Process> readyQueue, IStateSubject subject)
	{
		for(Process p: readyQueue)
		{
			subject.notify(new TerminatedStateObserver(), p);
		}
	}
}
