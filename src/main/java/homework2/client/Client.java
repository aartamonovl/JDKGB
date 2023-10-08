package homework2.client;

import homework2.server.Server;
import homework2.server.ServerWindow;

public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;

    public Client(Server server) {
        this.clientView = new ClientGUI(this);
        this.server = server;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            printText("Connection success!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Connection error!\n");
            return false;
        }
    }

    public void sendMessage(String message) {
        if (connected){
            if (!message.isEmpty()){
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("No connection to server\n");
        }
    }

    public void serverAnswer(String answer) {
        printText(answer);
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            printText("You was disconnected to server\n");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text){
        clientView.showMessage(text);
    }
}
