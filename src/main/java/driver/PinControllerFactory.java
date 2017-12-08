package driver;

public class PinControllerFactory {

	private static PinController instance = null;

	public static synchronized PinController getPinController() {
		if (instance == null) {
			if ("dummy".equals(System.getProperty("controller"))) {
				instance = new DummyPinController();
			} else {
				instance = new RpiPinController();
			}
		}
		return instance;
	}

}
