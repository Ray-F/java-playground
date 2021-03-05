package nz.ac.aucklanduni.rfen629;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 * @author Raymond Feng (rfen629@aucklanduni.ac.nz)
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startServer();
    }

    /**
     * Starts the server.
     */
    public void startServer() {
        Server server = new Server("Raymond Feng");

        Scanner scanner = new Scanner(System.in);

        // Synonyms that can be used to command the server to end
        String[] synExit = { "end", "stop", "exit" };

        // Allow user to stop the input
        while (true) {
            System.out.print("Enter any command here (e.g. stop): ");
            if (scanner.hasNext()) {
                if (Arrays.asList(synExit).contains(scanner.next())) {
                    server.exit(0);
                    break;
                } else {
                    System.out.println("Unexpected command!");
                }
            }
        }
    }

}
