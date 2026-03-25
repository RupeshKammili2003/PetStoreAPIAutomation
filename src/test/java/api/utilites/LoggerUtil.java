package api.utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

	//Logger is an interface, and LogManager gives you a fully configured, ready-to-use instance.
	public static final Logger logger = LogManager.getLogger(LoggerUtil.class);

	// Example log methods (optional)
	public static void info(String message) {
		logger.info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

}
