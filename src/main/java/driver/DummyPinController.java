package driver;

public class DummyPinController implements PinController {
	
	@Override
	public void setEnabled(boolean enabled, boolean pwm) {
		System.out.println("Pins enabled: " + enabled);
	}
	
	@Override
	public void setRow(int row, boolean enabled) {
	}

	@Override
	public void setBlueState(boolean blueState) {
		
	}
	@Override
	public void setGreenState(boolean greenState) {
		
	}

	@Override
	public void setRedState(boolean redState) {}

	@Override
	public void setRed(double red) {
	}

	@Override
	public void setGreen(double green) {
	}

	@Override
	public void setBlue(double blue) {
	}
}
