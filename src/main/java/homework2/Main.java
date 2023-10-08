package homework2;

import homework2.client.Client;
import homework2.server.Server;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        new Client(server);
        new Client(server);
    }
}
