package driver.program;

public abstract class AbstractProgram extends Thread {
	
	protected boolean stopThread = false;
	
	public void signalStop() {
		stopThread = true;
	}

}
