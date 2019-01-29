package business;

import java.util.Comparator;
import java.util.List;

public class Priority implements ISchedulingStrategy{

	@Override
	public void schedule(List<Process> processList) {
		processList.sort(Comparator.comparing(Process::getPriority));
				
	}

}
