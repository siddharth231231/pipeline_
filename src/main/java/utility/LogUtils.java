package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

    // Logger instance, created using LogManager
    private static final Logger logger = LogManager.getLogger(LogUtils.class);

    // This method will return the logger for the calling class
    public static Logger getLogger() {
        return logger;
    }

    // You can also create utility methods for common logging actions
    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
}
