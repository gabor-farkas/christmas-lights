package driver.program;

import java.util.Random;

import driver.PinController;
import driver.PinControllerFactory;

public class SineColorProgram extends AbstractProgram {

	PinController pins = PinControllerFactory.getPinController();
	
	@Override
	public void run() {
		Random random = new Random(System.currentTimeMillis());
		pins.setRow(0, true);
		double red = random.nextDouble() * 0.2 + 0.8;
		double green = random.nextDouble() * 0.2 + 0.8;
		double blue = random.nextDouble() * 0.2 + 0.8;
		double time = 0;
		while (!stopThread) {
			try {
				Thread.sleep(10);
				time += 0.01;
			} catch (Exception e) {
				// do nothing
			}
			pins.setRed(Math.sin(red * time) / 2 + 0.5);
			pins.setGreen(Math.sin(green * time) / 2 + 0.5);
			pins.setBlue(Math.sin(blue * time) / 2 + 0.5);
		}
		pins.setRow(0, false);
	}
}
