package businessLayer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;;

public class Activity{
	
	private static int counter=0;
	private Integer activityNumber;
	private String activityDesc;
	private Date startDate;
	private String deliverable;
	private ArrayList<Task> tasks;
	
	public Activity(String activityDesc, String activityStartDate, String activityDel) throws ParseException {
		setDesc(activityDesc);
		setStartDate(activityStartDate);
		setDeliverable(activityDel);
		tasks = new ArrayList<>();
	}
	
	public Integer getNumber() {
		return activityNumber;
	}
	public void setNumber(Integer number) {
		this.activityNumber +=counter;
		counter +=1;
	}
	public String getDesc() {
		return activityDesc;
	}
	public void setDesc(String desc) {
		this.activityDesc = desc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws ParseException {
		if (!startDate.isEmpty()) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = format.parse(startDate);
			this.startDate = date;
		}
	}
	public String getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}
	
	public Integer getHours()
	{
		int hoursSum=0;
		
		for(Task task: this.tasks) {
			hoursSum+=task.getHours();
		}
		return hoursSum;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public String toString()
	{
		return ("Activity number: " + activityNumber
				+"\nActivity Description: "+activityDesc
				+"\nStartDate: "+startDate
				+ "\nDeliverable : " + deliverable);
	}


	
}
