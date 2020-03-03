package learn.socket;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseClient {
    private InputStream inputStream;
    private OutputStream outputStream;

    private void connect(InetAddress address, int port) throws Exception {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(address, port));
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    private Map<String, Location> findAllLocations() throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        // Send query to server
        writer.write("SELECT * FROM locations");

        // Read from server: ???

        Map<String, Location> locations = new HashMap<>();
        return locations;
    }

    private List<Person> findAllPeople() throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        // Send query to server
        writer.write("SELECT * FROM people");

        // Read from server: ???

        List<Person> people = new ArrayList<>();
        return people;
    }

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        int port = 8788;

        DatabaseClient client = new DatabaseClient();
        client.connect(address, port);

        Map<String, Location> locations = client.findAllLocations();
        System.out.println(locations);

        List<Person> people = client.findAllPeople();
        System.out.println(people);
    }
}
