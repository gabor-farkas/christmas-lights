package driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns="/startup", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		PinControllerFactory.getPinController().setEnabled(true, true);
	}
	
	@Override
	public void destroy() {
		PinControllerFactory.getPinController().setEnabled(false, false);
	}
}
