package homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 400;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private static boolean isServerWorking;
    private final String path = "log.txt";

    public static boolean isServerWorking() {
        return isServerWorking;
    }

    public String getLog() {
        return log.getText();
    }

    public void appendServerLog(String text) {
        log.append(text);
        writeFile(text);
    }

    public void read() {
        readFile();
    }

    private void writeFile(String text) {
        String[] logArray = log.getText().split("\n");
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try (FileReader fileReader = new FileReader(path)) {
            char[] buf = new char[256];
            int c;
            while ((c = fileReader.read(buf)) > 0) {
                for (int i = 0; i < c; i++) {
                    log.append(String.valueOf(buf[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ServerWindow() {
        isServerWorking = true;
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    System.out.println("Server is already running");
                } else {
                    isServerWorking = true;
                    System.out.println("Server started");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    System.out.println("Server was stopped");
                } else {
                    isServerWorking = false;
                    System.out.println("Server stopped");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Char server");
        setAlwaysOnTop(true);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);
        add(panBottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
