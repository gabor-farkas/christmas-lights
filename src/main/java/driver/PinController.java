package driver;

public interface PinController {
	
	public void setEnabled(boolean enabled, boolean pwm);
	
	public void setRedState(boolean redState);
	public void setGreenState(boolean greenState);
	public void setBlueState(boolean blueState);
	
	public void setRed(double red);
	public void setGreen(double green);
	public void setBlue(double blue);
	
	public void setRow(int row, boolean enabled);

}
