package homework.lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainForm {
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu submenu;
    private JMenuItem menuItem;
    private JPanel panel;
    private JTextPane textPane;

    public MainForm() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Bills Application");
        mainFrame.setSize(640, 480);

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("Open");
        /*menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

                int returnVal = chooser.showOpenDialog(mainFrame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();

                    String filePath = file.getAbsolutePath();

                    //This is where a real application would open the file.
//                    log.append("Opening: " + file.getName() + "." + newline);
                } else {
//                    log.append("Open command cancelled by user." + newline);
                }
            }
        });*/
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
//        menuItem.addActionListener(e -> mainFrame.dispose());
        menu.add(menuItem);

        menu = new JMenu("Commands");
        menuBar.add(menu);

        menuItem = new JMenuItem("Append data");
        menu.add(menuItem);

        menuItem = new JMenuItem("Append data, compress every record");
        menu.add(menuItem);

        menuItem = new JMenuItem("Clear all data");
        menu.add(menuItem);

        submenu = new JMenu("Clear data by key");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Print data unsorted");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Print data sorted (by field)");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Print data reverse sorted (by field)");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records by key");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records > key");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records < key");
        menu.add(submenu);
        menuItem = new JMenuItem("numberHouse");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menuItem.addActionListener(e -> JOptionPane.showMessageDialog(mainFrame, "Made by Artyom Nesterenko"));
        menu.add(menuItem);

        for (Component menu : menuBar.getComponents()) {
            for (Component menuItem : ((JMenu) menu).getMenuComponents()) {
                if (!(menuItem instanceof JMenu) && !(menuItem instanceof JPopupMenu.Separator)) {
                    ((JMenuItem) menuItem).setActionCommand(((JMenuItem) menuItem).getText());
                    ((JMenuItem) menuItem).addActionListener(new menuItemListener());
                } else {
                    if (!(menuItem instanceof JPopupMenu.Separator)) {
                        for (Component submenuItem : ((JMenu) menuItem).getMenuComponents()) {
                            ((JMenuItem) submenuItem).setActionCommand(((JMenuItem) submenuItem).getText());
                            ((JMenuItem) submenuItem).addActionListener(new menuItemListener());
                        }
                    }
                }
            }
        }

        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(panel);
    }

    private void showForm() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MainForm form = new MainForm();
        form.showForm();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.setEnabled(true);
        textPane = new JTextPane();
        textPane.setBackground(new Color(-1529488));
        textPane.setEditable(false);
        textPane.setText("Hello");
        panel.add(textPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

    private class menuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Open":
                    JFileChooser chooser = new JFileChooser();

                    int returnVal = chooser.showOpenDialog(mainFrame);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = chooser.getSelectedFile();

                        String filePath = file.getAbsolutePath();

                        try {
                            Bills.printFile(textPane); // TODO (draft) rework
                        } catch (IOException | ClassNotFoundException exception) {
                            System.err.println("go away");
                        }

                        //This is where a real application would open the file.
//                    log.append("Opening: " + file.getName() + "." + newline);
                    } else {
//                    log.append("Open command cancelled by user." + newline);
                    }
                    break;

                case "Exit":
                    mainFrame.dispose();
                    break;

                case "Append data":
                    // TODO addForm
                    AppendDataForm appendDataForm = new AppendDataForm();
                    try {
                        Bills.appendFile(false, appendDataForm);
                    } catch (IOException | ClassNotFoundException | KeyNotUniqueException exception) {
                        exception.printStackTrace();
                    }
                    break;
            }
        }
    }
}
