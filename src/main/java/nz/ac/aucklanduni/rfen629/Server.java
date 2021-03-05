package nz.ac.aucklanduni.rfen629;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * A web server that hosts a server on port 8001 by default.
 *
 * @author Raymond Feng (rfen629@aucklanduni.ac.nz)
 */
public class Server extends Logger {

    private static final int PORT = 8_001;
    private final String serverAdmin;

    private HttpServer server;

    /**
     * Handler for the base route "/".
     */
    class DefaultHttpHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Logger.logInfo("Handled request to the website.");

            Headers requestHeaders = exchange.getRequestHeaders();
            System.out.println("\n\n-- START OF USER --");
            requestHeaders.forEach((header, action) -> System.out.printf("%s: %s%n", header, action));
            System.out.println("-- END OF USER --\n\n");

            byte[] responseMsg = ("You are currently accessing " + serverAdmin + "'s web server hosted on Java").getBytes();
            exchange.sendResponseHeaders(200, responseMsg.length);
            OutputStream response = exchange.getResponseBody();
            response.write(responseMsg);
            response.close();

            exchange.close();
        }

    }

    /**
     * @param serverAdmin - The name of the server admin who is starting the web server.
     */
    public Server(String serverAdmin) {
        this.serverAdmin = serverAdmin;

        try {
            this.server = HttpServer.create(new InetSocketAddress(PORT), 0);

            server.start();
            Logger.logInfo("Server has started on port " + PORT);

            server.createContext("/", new DefaultHttpHandler());
        } catch (IOException e) {
            Logger.logError("Error when trying to start the server", e);
        }
    }


    public void exit(int exitCode) {
        server.stop(0);

        switch (exitCode) {
            case 0 -> Logger.logInfo("Server stopped with exit code 0");
            case 1 -> Logger.logWarn("Server stopped unexpectedly with exit code 1");
            default -> Logger.logWarn("Server stopped unexpectedly with exit code " + exitCode);
        }
    }

}
