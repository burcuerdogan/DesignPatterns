package business;

import java.util.Random;

public class Process {
	
	private int id;
	private int  arrivalTime;
	private int burstTime;
	private int completionTime;
	private int waitingTime;
	private int priority;
	private IStateObserver state;
	
	private static  Random rand = new Random();
	public Process (int id, int completionTime)
	{
		this.arrivalTime=rand.nextInt(20) + 1;
		this.burstTime=rand.nextInt(20)+1;
		this.priority=rand.nextInt(10)+1;
		setId(id);
		setCompletionTime(completionTime);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getBurstTime() {
		return burstTime;
	}
	
	public int getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}
	public int getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	public int getPriority() {
		return priority;
	}
	
	public IStateObserver getState() {
		return state;
	}
	public void setState(IStateObserver state) {
		this.state = state;
	}
	
}
