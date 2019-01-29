package businessLayer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
	
	private static int counter=0;
	private Integer taskNumber;
	private String taskDesc;
	private Date startDate;
	private Integer hours;
	private Integer resourceId;
	
	public Task(String taskDesc, String taskStartDate, Integer taskHours, Integer resourceId) throws ParseException {
		setDesc(taskDesc);
		setStartDate(taskStartDate);
		setHours(taskHours);
		setResourceId(resourceId);
	}
	
	public Integer getNumber() {
		return taskNumber;
	}
	public void setNumber(Integer number) {
		this.taskNumber +=counter;
	}
	public String getDesc() {
		return taskDesc;
	}
	public void setDesc(String desc) {
		this.taskDesc = desc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = sdf.parse(startDate);
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String toString()
	{
		return ("Task number: "+ taskNumber
				+"\nDescription: "+taskDesc
				+"\nStartDate: " +startDate
				+"\nResource ID: " +resourceId);
	}

}
