package homework.lab12;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm {
    private JFrame mainFrame;
    private JPanel controlPanel;

    public MainForm() {
        prepateGUI();
    }

    private void prepateGUI() {
        mainFrame = new JFrame("Bills Application");
        mainFrame.setSize(640, 480);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuView = new JMenu("View");
        JMenu menuEdit = new JMenu("Edit");

        menuBar.add(menuFile);
        menuBar.add(menuView);
        menuBar.add(menuEdit);
        mainFrame.setJMenuBar(menuBar);
    }

    private void showForm() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MainForm form = new MainForm();
        form.showForm();
    }
}
