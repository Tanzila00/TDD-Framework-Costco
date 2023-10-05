package reports;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;

import org.slf4j.Logger;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggers {

//	static Logger loggers = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);// initialized logger
//
//	public static void log(String msg) {
//		loggers.log(Level.INFO, msg);// no need syso as we did logger method
//		Reporter.log(msg + "<br>");
//		ExtentTestManager.getTest().log(Status.INFO, msg);
//	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(Loggers.class);

    public static void log(String msg) {
        logger.info(msg);
        Reporter.log(msg + "<br>");
        ExtentTestManager.getTest().log(Status.INFO, msg);
    }
}

