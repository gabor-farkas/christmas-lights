package driver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/rgb")
public class RgbServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PinController pins = PinControllerFactory.getPinController();
		String rgb = req.getParameter("rgb");
		String [] components = rgb.split(",");
		double r = Double.parseDouble(components[0]);
		double g = Double.parseDouble(components[1]);
		double b = Double.parseDouble(components[2]);
		pins.setRow(0, true);
		pins.setRed(r / 256);
		pins.setGreen(g / 256);
		pins.setBlue(b / 256);
		PrintWriter pw = resp.getWriter();
		pw.write("OK");
	}

}
