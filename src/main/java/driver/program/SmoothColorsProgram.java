package driver.program;

import java.util.Random;

import driver.PinController;
import driver.PinControllerFactory;

public class SmoothColorsProgram extends AbstractProgram {

	PinController pins = PinControllerFactory.getPinController();
	
	@Override
	public void run() {
		Random random = new Random(System.currentTimeMillis());
		pins.setRow(0, true);
		double [] prev = new double [] {0, 0, 0};
		while (!stopThread) {
			try {
				int color = random.nextInt(6) + 1;
				double next [] = new double [] { ((color & 1) != 0)?1:0, ((color & 2) != 0)?1:0, ((color & 4) != 0)?1:0 };
				int transition = random.nextInt(250) + 250;
				for (int i = 0; i < transition; i += 10) {
					Thread.sleep(10);
					double t = ((double)i) / transition;
					double tt = 1 - t;
					pins.setRed(t * next[0] + tt * prev[0]);
					pins.setGreen(t * next[1] + tt * prev[1]);
					pins.setBlue(t * next[2] + tt * prev[2]);
				}
				pins.setRed(next[0]);
				pins.setGreen(next[1]);
				pins.setBlue(next[2]);
				prev = next;
				int wait = random.nextInt(1500) + 500;
				Thread.sleep(wait);
			} catch (Exception e) {
				// do nothing
			}
			
		}
		pins.setRow(0, false);
	}
	
}
