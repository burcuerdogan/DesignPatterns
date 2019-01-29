package business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProcessBatch {

	private IStateSubject subject;
	private List<Process> processList= new ArrayList<>();
	private Queue<Process> readyQueue;
	public ProcessBatch(IStateSubject subject)
	{
		this.subject=subject;
		readyQueue= new LinkedList<>();
	}
	public void scheduleProcesses(ISchedulingStrategy scheduling)
	{
		scheduling.schedule(processList);
	}
	
	public void determineProcessWaitingTime()
	{
		
		processList.get(0).setWaitingTime(0);
		
		for (int i = 1; i < processList.size()-1; i++) 
		{
			int waitingTime=0;
			for (int j = i; j >= 0; j--) 
			{
				waitingTime+=processList.get(j).getBurstTime();
				
			}
			processList.get(i).setWaitingTime(waitingTime);
			
			if (waitingTime>50) 
			{
				subject.notify(new StarvedStateObserver(), processList.get(i));
				
			}
		}
		
	}
	
	public void addProcess(Process process)
	{
		processList.add(process);
		subject.notify(new NewStateObserver(), process);
	}
	public List<Process> getList()
	{
		return processList;
	}
	
	public void inReady()
	{
		for(Process p: processList)
		{
			if(!(p.getState() instanceof StarvedStateObserver))
			{
				subject.notify(new ReadyStateObserver(), p);
				readyQueue.add(p);
			}
		}
		
	}
	
	public Queue<Process> getReadyQueue()
	{
		return readyQueue;
	}
	
	
	
	
}
