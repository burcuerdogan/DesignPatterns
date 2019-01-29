package business;

import java.util.List;

public interface ISchedulingStrategy {
	public void schedule(List<Process> processList);
}
