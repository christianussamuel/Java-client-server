package learn.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DatabaseServer {
    private final List<Person> people;
    private final Map<String, Location> locations;

    private DatabaseServer() {
        people = createPersonTable();
        locations = createLocationTable();
    }

    private static List<Person> createPersonTable() {
        return Arrays.asList(
                new Person("John Doe", 23),
                new Person("Jane Doe", 24));
    }

    private static Map<String, Location> createLocationTable() {
        Map<String, Location> locations = new HashMap<>();
        locations.put("ITB", new Location(107.61, -6.89));
        locations.put("ITHB", new Location(107.62, -6.78));
        return locations;
    }

    private void start() throws Exception {
        ServerSocket ss = new ServerSocket(8788);
        while (true) {
            Socket clientSocket = ss.accept();

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                handleRequest(line, os);
            }
        }
    }

    private void handleRequest(String req, OutputStream os) {
        if ("SELECT * FROM people".equals(req)) {
            // Iterate over table people
            //   convert People to bytes
            //   send bytes to client
        } else if ("SELECT * FROM locations".equals(req)) {
            // Iterate over table locations
            //   convert String, Location to bytes
            //   send bytes to client
        }
    }

    public static void main(String[] args) throws Exception {
        new DatabaseServer().start();
    }
}
