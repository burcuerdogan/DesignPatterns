package dataAccessLayer;

import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessLayer.Project;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileIO {
	private static String filePath = "src/dataAccessLayer/projects";
	private static final Type PROJECT_TYPE = new TypeToken<List<Project>>() {}.getType();

	public Project[] readProjects() throws IOException,ParseException{
		String lastProjectFile = getLastFile();
		Gson gson = new Gson();
		return gson.fromJson(new FileReader(filePath + "/" + lastProjectFile), Project[].class);
	}

	public void saveProjects(ArrayList<Project> projects) throws  IOException{
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String fileName = "/Projects-"+localDate+".json";
		FileWriter jsonWriter = new FileWriter(filePath+fileName);
		BufferedWriter out = new BufferedWriter(jsonWriter);
		gson.toJson(projects,out);
		out.close();
		}
	private String getLastFile() throws ParseException{
		File dir = new File("src/dataAccessLayer/projects");
		File[] projectFiles = dir.listFiles((dir1, name) -> name.startsWith("Projects-"));
		String tempName = projectFiles[0].getName();
		for(File file : projectFiles){
			tempName = compareDate(tempName,file.getName());
		}
		return tempName;
	}

	private String compareDate(String dateOne, String dateTwo) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDateFirst = dateOne.substring(dateOne.indexOf("-")+1).replaceFirst("[.][^.]+$", "");
		String strDateTwo  = dateTwo.substring(dateTwo.indexOf("-")+1).replaceFirst("[.][^.]+$", "");

		Date firstDate = sdf.parse(strDateFirst);
		Date secondDate = sdf.parse(strDateTwo);
		if(secondDate.compareTo(firstDate) >= 0){
			return dateTwo;
		}
		return dateOne;
	}
}
