
import business.Dispatcher;
import business.ISchedulingStrategy;
import business.IStateSubject;
import business.Priority;
import business.Process;
import business.ProcessBatch;
import business.StateSubject;


public class ProcessManagementApplication {

	public static void main(String[] args) {
		Process p1 = new Process(1, 5);
		Process p2 = new Process(2, 15);
		Process p3 = new Process(3, 7);
		Process p4 = new Process(4, 20);
		Process p5 = new Process(5, 8);
		
		IStateSubject subject = new StateSubject();
		ISchedulingStrategy strategy = new Priority();
		
		ProcessBatch pb = new ProcessBatch(subject);
		
		pb.addProcess(p1);
		pb.addProcess(p2);
		pb.addProcess(p3);
		pb.addProcess(p4);
		pb.addProcess(p5);
		
		pb.scheduleProcesses(strategy);
		
		pb.determineProcessWaitingTime();
		
		pb.inReady();
		
		Dispatcher dp = new Dispatcher(pb.getReadyQueue(), subject);
		
		dp.extractReadyProcesses();
		
		
	}

}
