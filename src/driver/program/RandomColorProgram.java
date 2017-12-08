package driver.program;

import java.util.Random;

import driver.PinController;
import driver.PinControllerFactory;

public class RandomColorProgram extends AbstractProgram {
	
	PinController pins = PinControllerFactory.getPinController();
	
	@Override
	public void run() {
		Random random = new Random(System.currentTimeMillis());
		pins.setRow(0, true);
		while (!stopThread) {
			int wait = random.nextInt(2000) + 500;
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				// do nothing
			}
			int color = random.nextInt(6) + 1;
			pins.setRed(((color & 1) != 0)?1:0);
			pins.setGreen(((color & 2) != 0)?1:0);
			pins.setBlue(((color & 4) != 0)?1:0);
		}
		pins.setRow(0, false);
	}

}
