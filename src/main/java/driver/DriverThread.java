package driver;

public class DriverThread extends Thread {
	
	private static DriverThread instance = new DriverThread();
	
	public boolean stop = false;

	private static PinController pinController = PinControllerFactory.getPinController();
	
	private int red = 1;
	private int green = 1;
	private int blue = 1;
	private int rc;
	private int gc;
	private int bc;
	
	@Override
	public void run() {
		System.out.println("Thread started");
		pinController.setRow(0, true);
		bc = red;
		gc = green;
		bc = blue;
		while (!stop) {
			try {
				Thread.sleep(0, 500);
				if (--rc <= 0) {
					pinController.setRedState(true);
					rc = red;
				} else
				if (--gc <= 0) {
					pinController.setGreenState(true);
					gc = green;
				} else
				if (--bc <= 0) {
					pinController.setBlueState(true);
					bc = blue;
				}
				Thread.sleep(0, 500);
				if (rc == red) {
					pinController.setRedState(false);
				}
				if (gc == green) {
					pinController.setGreenState(false);
				}
				if (bc == blue) {
					pinController.setBlueState(false);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		pinController.setRow(0, false);
		System.out.println("Thread stopped");
	}
	
	/**
	 * 0..255 
	 */
	public void setRGB(int r, int g, int b) {
		System.out.println("rgb: " + r + ", " + g + ", " + b);
		red = transform(r);
		green = transform(g);
		blue = transform(b);
		System.out.println("transformed: " + red + ", " + green + ", " + blue);
	}
	
	public void setTimings(int r, int g, int b) {
		System.out.println("rgb: " + r + ", " + g + ", " + b);
		red = r;
		green = g;
		blue = b;
		System.out.println("transformed: " + red + ", " + green + ", " + blue);
	}

	protected int transform(int c) {
		return 256 - c;
	}

	public static DriverThread getInstance() {
		return instance;
	}
}
