package driver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/timings")
public class TimingServlet extends HttpServlet {
	
	DriverThread thread = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String timingsString = req.getParameter("timings");
		if ("stop".equals(timingsString)) {
			thread.stop = true;
			thread = null;
		}
		String [] timings = timingsString.split(",");
		if (thread == null) {
			thread = DriverThread.getInstance();
			thread.start();
		}
		int r = Integer.parseInt(timings[0]);
		int g = Integer.parseInt(timings[1]);
		int b = Integer.parseInt(timings[2]);
		thread.setTimings(r, g, b);
		PrintWriter pw = resp.getWriter();
		pw.write("OK");
	}
	
	

}
