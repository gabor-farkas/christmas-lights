package driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import driver.program.AbstractProgram;
import driver.program.RandomColorProgram;
import driver.program.SineColorProgram;
import driver.program.SmoothColorsProgram;

@WebServlet(urlPatterns="/program", loadOnStartup=2)
public class ProgramServlet extends HttpServlet {
	
	AbstractProgram program = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		program = new SmoothColorsProgram();
		program.start();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nextProgramName = req.getParameter("program");
		AbstractProgram nextProgram = null;
		if ("randomcolors".equals(nextProgramName)) {
			nextProgram = new RandomColorProgram();
		}
		if ("sinecolors".equals(nextProgramName)) {
			nextProgram = new SineColorProgram();
		}
		if ("smoothcolors".equals(nextProgramName)) {
			nextProgram = new SmoothColorsProgram();
		}
		if (program != null) {
			// close the previous program
			program.signalStop();
		}
		if (nextProgram != null) {
			nextProgram.start();
			program = nextProgram;
		}
	}

}
