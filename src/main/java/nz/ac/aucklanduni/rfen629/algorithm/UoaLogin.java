package nz.ac.aucklanduni.rfen629.algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Raymond Feng (raymond@fundafuture.co.nz)
 */
public class UoaLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Boolean loggedIn = false;

        String email;
        String password;

        while (!loggedIn) {
            System.out.print("UOA Email: \\u001B[37m");
            email = scanner.next();

            System.out.print("Password: ");
            password = scanner.next();

            loggedIn = access(email, password);

            if (loggedIn) {
                System.out.println("Welcome to the UOA Network!");
            } else {
                System.out.println("Error, that email and password combination was not correct.");
            }
        }

    }

    public static boolean access(String username, String password) {

        try {
            URL endpoint = new URL("http://blockly.auckland.ac.nz/api/authenticate/login");

            HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json;charset=UTF-8");
            headers.forEach(connection::setRequestProperty);

            connection.connect();

            try (OutputStream out = connection.getOutputStream()) {
                String payload = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", username, password);
                out.write(payload.getBytes(StandardCharsets.UTF_8));
            }

            return connection.getResponseCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
