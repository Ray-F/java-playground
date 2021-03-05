package nz.ac.aucklanduni.rfen629.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import nz.ac.aucklanduni.rfen629.Main;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;
import static nz.ac.aucklanduni.rfen629.util.Constants.OUTPUT;

/**
 * A logger class for logging anything produced by this application.
 */
public class Logger {

    /**
     * The logger for this application.
     */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getCanonicalName());

    private static File logFile;


    // Set the logger format to single lines
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS [%4$s] %5$s%6$s%n");
        logger.setUseParentHandlers(false);

        try {
            logFile = setupLogFile(LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a log file.
     */
    private static File setupLogFile(LocalDateTime runtime) throws IOException {
        String logsDir = OUTPUT + "/logs";

        // Make directories if they are not made
        new File(logsDir).mkdirs();

        // Set file output path and set to simple no-markup formatting (i.e., what is logged to console is saved to file)
        String datetimeStr = DateTimeFormatter.ISO_DATE_TIME.format(runtime);
        String filePath = logsDir + "/SERVER_LOG_" + datetimeStr + ".log";

        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        return new File(filePath);
    }

    /**
     * Logs an info message.
     */
    public static void logInfo(String message) {
        logger.log(INFO, message);
    }

    /**
     * Logs a warning message with a cause.
     */
    public static void logWarn(String message, Exception cause) {
        logger.log(WARNING, message, cause);
    }

    /**
     * Logs a warning message.
     */
    public static void logWarn(String message) {
        logger.log(WARNING, message);
    }

    /**
     * Logs an error message with a cause.
     */
    public static void logError(String message, Exception cause) {
        logger.log(SEVERE, message, cause);
    }

    /**
     * Returns the log file.
     */
    public static File getLogFile() {
        return logFile;
    }

}
