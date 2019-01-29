package businessLayer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Project {
	private String name;
	private String projectDesc;
	private Date startDate;
	private ArrayList<Activity> activities;
	
	public Project(String name, String projectDesc, String startDate) throws ParseException,
			CustomExceptions.EmptyFieldNotAllowedException,
			CustomExceptions.NotAcceptedDateFormat {
		setName(name);
		setDesc(projectDesc);
		setStartDate(startDate);
		activities = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws CustomExceptions.EmptyFieldNotAllowedException {
		try{
			if(!name.equals("")){
				this.name = name;
			}
		}catch (NullPointerException e) {
			throw new CustomExceptions.EmptyFieldNotAllowedException("Empty fields are not allowed.",e);
		}
	}
	public String getDesc() {
		return projectDesc;
	}
	public void setDesc(String projectDesc) throws CustomExceptions.EmptyFieldNotAllowedException {
		try{
			if(!projectDesc.equals("")){
				this.projectDesc = projectDesc;
			}
		}catch (NullPointerException e) {
			throw new CustomExceptions.EmptyFieldNotAllowedException("Empty fields are not allowed.",e);
		}
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws ParseException,
			CustomExceptions.EmptyFieldNotAllowedException,
			CustomExceptions.NotAcceptedDateFormat
		{

			try{
				if(!startDate.equals("")){
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					this.startDate = format.parse(startDate);
				}
			}catch (NullPointerException e) {
				throw new CustomExceptions.EmptyFieldNotAllowedException("Empty fields are not allowed.",e);
			}catch (ParseException p){
				throw new CustomExceptions.NotAcceptedDateFormat("Date format is not accepted.",p);
			}
		}
	public ArrayList<Activity> getActivities() {
		return activities;
	}
	public void addActivity(Activity activity) {
		if (activity != null) {
			this.activities.add(activity);
		}
	}

	public int calculateHours(){
		int totalHour = 0;
		for(Activity act : activities){
			totalHour += act.getHours();
		}
		return totalHour;
	}

	public String toString()
	{
		return ("Project name: "+name+"\nDescription: "+projectDesc+"\nStartDate: "+startDate);
	}

}
