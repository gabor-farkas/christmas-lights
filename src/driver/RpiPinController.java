package driver;

import pipwm4j.Pwm;

public class RpiPinController implements PinController {
	
	private Pwm row1;
	private Pwm pinB;
	private Pwm pinR;
	private Pwm pinG;
	
	private long span = 1000;	//usecs
	
	@Override
	public void setRow(int row, boolean enabled) {
		row1.setState(enabled);
	}
	
	@Override
	public void setEnabled(boolean enabled, boolean pwm) {
		if (enabled) {
			row1 = new Pwm(18);
			pinB = new Pwm(27);
			pinG = new Pwm(22);
			pinR = new Pwm(23);
			if (pwm) {
				pinB.start();
				pinG.start();
				pinR.start();
			}
		} else {
			if (row1 != null) {
				row1.setState(false);
				row1.close();
				pinB.close();
				pinR.close();
				pinG.close();
			}
		}
	}
	
	@Override
	public void setBlueState(boolean blueState) {
		pinB.setState(!blueState); // inverted control
	}
	
	@Override
	public void setGreenState(boolean greenState) {
		pinG.setState(!greenState); 	// inverted control
	}
	
	@Override
	public void setRedState(boolean redState) {
		pinR.setState(redState);
	}
	

	@Override
	public void setBlue(double blue) {
		pinB.setParams(span, span - (int) (blue * span));
	}
	
	@Override
	public void setGreen(double green) {
		pinG.setParams(span, span - (int) (green * span));
	}
	
	@Override
	public void setRed(double red) {
		pinR.setParams(span, (int) (red * span));
	}
}
