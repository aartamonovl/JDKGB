package homework2.server;

import homework2.client.Client;
import homework2.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Server {
    List<Client> clientList;

    private boolean work;

    private Repository repository;
    private ServerView serverView;

    public Server() {
        this.clientList = new ArrayList<>();
        this.repository = new Repository();
        this.serverView = new ServerWindow(this);
    }

    public void startServer(){
        if (isWork()) {
            printText("Сервер уже был запущен\n");
        } else {
            setWork(true);
            printText("Сервер запущен!\n");
        }
    }

    public void stopServer(){
        if (!isWork()) {
            printText("Сервер уже был остановлен\n");
        } else {
            setWork(false);
            serverView.disconnectAll();
            printText("Сервер остановлен!\n");
        }
    }

    protected void answerAll(String text) {
        for (Client client : clientList) {
            client.serverAnswer(text);
        }
    }

    public void sendMessage(String text) {
        if (!isWork()) {
            return;
        }
        printText(text);
        answerAll(text);
        saveToRepo(text);
    }

    private void saveToRepo(String text){
        repository.save(text);
    }

    private void printText(String text) {
        serverView.showMessage(text + "\n");
    }

    public String getHistory() {
        return repository.load();
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (client != null) {
            client.disconnect();
        }
    }

    public void disconnectAllUsers() {
        for (int i = clientList.size() - 1; i > -1; i--) {
            disconnectUser(clientList.get(i));
        }
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }
}
