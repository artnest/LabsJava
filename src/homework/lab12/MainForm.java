package homework.lab12;

import javax.swing.*;
import javax.swing.text.BadLocationException;
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

    private static String filenamePath;
    private static String filenameBakPath;
    private static String idxnamePath;
    private static String idxnameBakPath;

    public static String getFilenamePath() {
        return filenamePath;
    }

    public static void setFilenamePath(String filenamePath) {
        MainForm.filenamePath = filenamePath;
    }

    public static String getIdxnamePath() {
        return idxnamePath;
    }

    public static void setIdxnamePath(String idxnamePath) {
        MainForm.idxnamePath = idxnamePath;
    }

    public static String getFilenameBakPath() {
        return filenameBakPath;
    }

    public static void setFilenameBakPath(String fileBakPath) {
        MainForm.filenameBakPath = fileBakPath;
    }

    public static String getIdxnameBakPath() {
        return idxnameBakPath;
    }

    public static void setIdxnameBakPath(String idxnameBakPath) {
        MainForm.idxnameBakPath = idxnameBakPath;
    }

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
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
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
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        menuItem = new JMenuItem("Print data unsorted");
        menu.add(menuItem);

        submenu = new JMenu("Print data sorted (by key)");
        menu.add(submenu);
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Print data reverse sorted (by key)");
        menu.add(submenu);
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records by key");
        menu.add(submenu);
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records > key");
        menu.add(submenu);
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("numberApartment");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);

        submenu = new JMenu("Find records < key");
        menu.add(submenu);
        menuItem = new JMenuItem("houseNumber");
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
        menu.add(menuItem);

        // Рома
        // +375297731699 - magnet  // TODO delete
        // TODO < till 20:00

        for (Component menu : menuBar.getComponents()) {
            for (Component menuItem : ((JMenu) menu).getMenuComponents()) {
                if (!(menuItem instanceof JMenu) && !(menuItem instanceof JPopupMenu.Separator)) {
                    ((JMenuItem) menuItem).setActionCommand(((JMenuItem) menuItem).getText());
                    ((JMenuItem) menuItem).addActionListener(new menuItemListener());
                } else {
                    if (!(menuItem instanceof JPopupMenu.Separator)) {
                        for (Component submenuItem : ((JMenu) menuItem).getMenuComponents()) {
                            ((JMenuItem) submenuItem).setActionCommand(((JMenu) menuItem).getText() + " " +
                                                                        ((JMenuItem) submenuItem).getText());
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
                        filenamePath = file.getAbsolutePath();
                        filenameBakPath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".~dat";
                        idxnamePath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".idx";
                        idxnameBakPath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".~idx";

                        try {
                            textPane.setText(null);
                            Bills.printFile(textPane);
                        } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                            JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                        }
                    }
                    break;

                case "Exit":
                    mainFrame.dispose();
                    break;

                case "About":
                    JOptionPane.showMessageDialog(mainFrame, "Made by Artyom Nesterenko");
                    break;

                case "Append data":
                    if (filenamePath == null && idxnamePath == null) {
                        filenamePath = new File("Bills.dat").getPath();
                        idxnamePath = new File("Bills.idx").getPath();
                    }

                    try {
                        Bills.appendFile(false, new AppendDataForm().getBill(), filenamePath);
                        Bills.printFile(textPane);
                    } catch (IOException | ClassNotFoundException | KeyNotUniqueException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Append data, compress every record":
                    try {
                        Bills.appendFile(true, new AppendDataForm().getBill(), filenamePath);
                        Bills.printFile(textPane);
                    } catch (IOException | ClassNotFoundException | KeyNotUniqueException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Clear all data":
                    Bills.deleteFile();
                    JOptionPane.showMessageDialog(mainFrame, "All data was cleared");
                    break;
                    
                case "Clear data by key houseNumber":
                case "Clear data by key apartmentNumber":
                case "Clear data by key owner":
                case "Clear data by key paymentDate":
                    try {
                        Bills.deleteFile(e.getActionCommand().substring(e.getActionCommand().lastIndexOf("Clear data by") + 1), new KeyEnter().getKey());
                        Bills.printFile(textPane);
                    } catch (IOException | ClassNotFoundException | KeyNotUniqueException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data unsorted":
                    try {
                        Bills.printFile(textPane);
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data sorted (by key) houseNumber":
                case "Print data sorted (by key) apartmentNumber":
                case "Print data sorted (by key) owner":
                case "Print data sorted (by key) paymentDate":
                    try {
                        Bills.printFile(textPane, new KeyEnter().getKey(), false);
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data reverse sorted (by key) houseNumber":
                case "Print data reverse sorted (by key) apartmentNumber":
                case "Print data reverse sorted (by key) owner":
                case "Print data reverse sorted (by key) paymentDate":
                    try {
                        Bills.printFile(textPane, e.getActionCommand().substring(e.getActionCommand().lastIndexOf("Clear data by") + 1), true);
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records by key numberHouse":
                case "Find records by key apartmentNumber":
                case "Find records by key owner":
                case "Find records by key paymentDate":
                    try {
                        Bills.findByKey(textPane, e.getActionCommand().substring(e.getActionCommand().lastIndexOf("Find records by key") + 1), new KeyEnter().getKey());
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records > key numberHouse":
                case "Find records > key apartmentNumber":
                case "Find records > key owner":
                case "Find records > key paymentDate":
                    try {
                        Bills.findByKey(textPane, e.getActionCommand().substring(e.getActionCommand().lastIndexOf("Find records > key") + 1), new KeyEnter().getKey(), new KeyComparators.KeyComparator());
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records < key numberHouse":
                case "Find records < key apartmentNumber":
                case "Find records < key owner":
                case "Find records < key paymentDate":
                    try {
                        Bills.findByKey(textPane, e.getActionCommand().substring(e.getActionCommand().lastIndexOf("Find records < key") + 1), new KeyEnter().getKey(), new KeyComparators.KeyComparatorReverse());
                    } catch (IOException | ClassNotFoundException | BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;
            }
        }
    }
}
