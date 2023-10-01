package homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.event.KeyEvent.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private final JTextArea log = new JTextArea();
    private boolean isUserInChat = false;
    private final JPanel panTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("0.0.0.0");
    private final JTextField tfPort = new JTextField("8080");
    private final JTextField tfLogin = new JTextField("Petr Petrov");
    private final JPasswordField tfPassword = new JPasswordField("0000000");
    private final JButton btnLogin = new JButton("Login");
    private ServerWindow serverWindow;
    private final JPanel panButton = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private boolean connected;

    ClientGUI(ServerWindow serWindow) {
        serverWindow = serWindow;
        connected = connection();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panTop.add(tfIPAddress);
        panTop.add(tfPort);
        panTop.add(tfLogin);
        panTop.add(tfPassword);
        panTop.add(btnLogin);
        add(panTop, BorderLayout.NORTH);

        panButton.add(tfMessage, BorderLayout.CENTER);
        panButton.add(btnSend, BorderLayout.EAST);
        add(panButton, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connected) {
                    if (isUserInChat)
                        System.out.println("User " + tfLogin.getText() + "is already in the chat.");
                    else {
                        isUserInChat = true;
                        log.append("User " + tfLogin.getText() + " joined the chat.\n");
                        serverWindow.appendServerLog("User " + tfLogin.getText() + " joined the chat.\n");
                    }
                }
            }
        });

        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (connected) {
                    if (isUserInChat) {
                        if (e.getKeyCode() == VK_ENTER) {
                            log.append(tfLogin.getText() + ": " + tfMessage.getText() + "\n");
                            serverWindow.appendServerLog(tfLogin.getText() + ": " + tfMessage.getText() + "\n");
                        }
                    } else {
                        System.out.println("Please join to the chat");
                    }
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connected) {
                    if (isUserInChat) {
                        log.append(tfLogin.getText() + ": " + tfMessage.getText() + "\n");
                        serverWindow.appendServerLog(tfLogin.getText() + ": " + tfMessage.getText() + "\n");
                    } else
                        System.out.println("Please join to the chat");
                }
            }
        });
    }

    private boolean connection() {
        if (ServerWindow.isServerWorking()) {
            log.append("Connection is done.");
            serverWindow.read();
            log.append(serverWindow.getLog());
            return true;
        } else {
            log.append("Connection failed");
            return false;
        }
    }
}
