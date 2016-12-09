package homework.lab12;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
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
    private JPanel mainPanel;
    private JTextPane textPane;
    private JPanel statusBar;
    private JLabel statusBarLabel;

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

        menuItem = new JMenuItem("New");
        menu.add(menuItem);
        menuItem = new JMenuItem("Open");
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menu.add(menuItem);

        menu = new JMenu("Commands");
        menu.setEnabled(false);
        menuBar.add(menu);

        menuItem = new JMenuItem("Append data");
        menu.add(menuItem);

        menuItem = new JMenuItem("Append data, compress every record");
        menu.add(menuItem);

        menuItem = new JMenuItem("Clear all data");
        menu.add(menuItem);

        submenu = new JMenu("Clear data by key");
        menu.add(submenu);
        addFieldsButtons();

        menuItem = new JMenuItem("Print data unsorted");
        menu.add(menuItem);

        submenu = new JMenu("Print data sorted (by key)");
        menu.add(submenu);
        addFieldsButtons();

        submenu = new JMenu("Print data reverse sorted (by key)");
        menu.add(submenu);
        addFieldsButtons();

        submenu = new JMenu("Find records by key");
        menu.add(submenu);
        addFieldsButtons();

        submenu = new JMenu("Find records > key");
        menu.add(submenu);
        addFieldsButtons();

        submenu = new JMenu("Find records < key");
        menu.add(submenu);
        addFieldsButtons();

        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menu.add(menuItem);

        for (Component menu : menuBar.getComponents()) {
            menu.addMouseMotionListener(new menuItemMouseMotionListener());
            for (Component menuItem : ((JMenu) menu).getMenuComponents()) {
                if (!(menuItem instanceof JMenu) && !(menuItem instanceof JPopupMenu.Separator)) {
                    menu.addMouseMotionListener(new menuItemMouseMotionListener());

                    ((JMenuItem) menuItem).setActionCommand(((JMenuItem) menuItem).getText());
                    ((JMenuItem) menuItem).addActionListener(new menuItemListener());
                    menuItem.addMouseMotionListener(new menuItemMouseMotionListener());
                } else {
                    if (!(menuItem instanceof JPopupMenu.Separator)) {
                        menuItem.addMouseMotionListener(new menuItemMouseMotionListener());
                        for (Component submenuItem : ((JMenu) menuItem).getMenuComponents()) {
                            ((JMenuItem) submenuItem).setActionCommand(((JMenu) menuItem).getText() + " " +
                                                                        ((JMenuItem) submenuItem).getText());
                            ((JMenuItem) submenuItem).addActionListener(new menuItemListener());
                            submenuItem.addMouseMotionListener(new menuItemMouseMotionListener());
                        }
                    }
                }
            }
        }

        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(mainPanel);

    }

    private void addFieldsButtons() {
        menuItem = new JMenuItem("houseNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("apartmentNumber");
        submenu.add(menuItem);
        menuItem = new JMenuItem("owner");
        submenu.add(menuItem);
        menuItem = new JMenuItem("paymentDate");
        submenu.add(menuItem);
    }

    private void showForm() {
        mainFrame.setLocationRelativeTo(null);
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setEnabled(true);
        textPane = new JTextPane();
        textPane.setBackground(new Color(-1529488));
        textPane.setEditable(false);
        mainPanel.add(textPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    private class menuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "New":
                    String filename = new NewFileForm().getFilename();
                    if (!filename.isEmpty()) {
                        if (checkFiles()) {
                            JOptionPane.showMessageDialog(mainFrame,
                                    "Your files will be backed up and deleted!");
                            Bills.deleteFile();
                        }
                        setFilenamePaths(new File(filename).getAbsolutePath());

                        for (Component menu : menuBar.getComponents()) {
                            if (!menu.isEnabled()) {
                                menu.setEnabled(true);
                            }
                        }
                    }

                    for (Component menu : menuBar.getComponents()) {
                        if (!menu.isEnabled()) {
                            menu.setEnabled(true);
                        }
                    }
                    break;

                case "Open":
                    JFileChooser chooser = new JFileChooser();

                    int returnVal = chooser.showOpenDialog(mainFrame);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        setFilenamePaths(chooser.getSelectedFile().getAbsolutePath());

                        try {
                            textPane.setText(null);
                            Bills.printFile(textPane);
                        } catch (IOException |
                                ClassNotFoundException |
                                BadLocationException exception) {
                            JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                        }
                    }

                    for (Component menu : menuBar.getComponents()) {
                        if (!menu.isEnabled()) {
                            menu.setEnabled(true);
                        }
                    }
                    break;

                case "Exit":
                    mainFrame.dispose();
                    break;

                case "About":
                    JOptionPane.showMessageDialog(mainFrame, "Made by Artyom Nesterenko (9th group)");
                    break;

                case "Append data":
                    try {
                        Bills.appendFile(false, new AppendDataForm().getBill(), filenamePath);
                        Bills.printFile(textPane);
                    } catch (IOException |
                            ClassNotFoundException |
                            KeyNotUniqueException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Append data, compress every record":
                    try {
                        Bills.appendFile(true, new AppendDataForm().getBill(), filenamePath);
                        Bills.printFile(textPane);
                    } catch (IOException |
                            ClassNotFoundException |
                            KeyNotUniqueException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Clear all data":
                    try {
                        Bills.deleteFile();
                        JOptionPane.showMessageDialog(mainFrame, "All data was cleared");
                        Bills.printFile(textPane);
                    } catch (IOException |
                            ClassNotFoundException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;
                    
                case "Clear data by key houseNumber":
                case "Clear data by key apartmentNumber":
                case "Clear data by key owner":
                case "Clear data by key paymentDate":
                    try {
                        Bills.deleteFile(e.getActionCommand()
                                                .substring(e.getActionCommand().lastIndexOf("key") + 4),
                                        new KeyEnter().getKey());
                        Bills.printFile(textPane);
                    } catch (IOException |
                            ClassNotFoundException |
                            KeyNotUniqueException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data unsorted":
                    try {
                        Bills.printFile(textPane);
                    } catch (IOException |
                            ClassNotFoundException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data sorted (by key) houseNumber":
                case "Print data sorted (by key) apartmentNumber":
                case "Print data sorted (by key) owner":
                case "Print data sorted (by key) paymentDate":
                    try {
                        Bills.printFile(textPane,
                                        e.getActionCommand()
                                                .substring(e.getActionCommand().lastIndexOf("key") + 5),
                                false);
                    } catch (IOException |
                            ClassNotFoundException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Print data reverse sorted (by key) houseNumber":
                case "Print data reverse sorted (by key) apartmentNumber":
                case "Print data reverse sorted (by key) owner":
                case "Print data reverse sorted (by key) paymentDate":
                    try {
                        Bills.printFile(textPane,
                                        e.getActionCommand()
                                                .substring(e.getActionCommand().lastIndexOf("key") + 5),
                                true);
                    } catch (IOException |
                            ClassNotFoundException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records by key houseNumber":
                case "Find records by key apartmentNumber":
                case "Find records by key owner":
                case "Find records by key paymentDate":
                    try {
                        String key = new KeyEnter().getKey();
                        if (!key.isEmpty()) {
                            Bills.findByKey(textPane,
                                    e.getActionCommand()
                                            .substring(e.getActionCommand().lastIndexOf("key") + 4),
                                    key);
                        }
                    } catch (IOException |
                            ClassNotFoundException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records > key houseNumber":
                case "Find records > key apartmentNumber":
                case "Find records > key owner":
                case "Find records > key paymentDate":
                    try {
                        String key = new KeyEnter().getKey();
                        if (!key.isEmpty()) {
                            Bills.findByKey(textPane,
                                    e.getActionCommand()
                                            .substring(e.getActionCommand().lastIndexOf("key") + 4),
                                    key,
                                    new KeyComparators.KeyComparator());
                        }
                    } catch (IOException |
                            ClassNotFoundException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;

                case "Find records < key houseNumber":
                case "Find records < key apartmentNumber":
                case "Find records < key owner":
                case "Find records < key paymentDate":
                    try {
                        String key = new KeyEnter().getKey();
                        if (!key.isEmpty()) {
                            Bills.findByKey(textPane,
                                    e.getActionCommand()
                                            .substring(e.getActionCommand().lastIndexOf("key") + 4),
                                    key,
                                    new KeyComparators.KeyComparatorReverse());
                        }
                    } catch (IOException |
                            ClassNotFoundException |
                            IllegalArgumentException |
                            BadLocationException exception) {
                        JOptionPane.showMessageDialog(mainFrame, exception.getMessage());
                    }
                    break;
            }

            statusBarLabel.setText(null);
        }
    }

    private class menuItemMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            statusBarLabel.setText(((JMenuItem) e.getComponent()).getText());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusBarLabel.setText(((JMenuItem) e.getComponent()).getText());
        }
    }

    private void setFilenamePaths(String filePath) {
        filenamePath = filePath;
        filenameBakPath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".~dat";
        idxnamePath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".idx";
        idxnameBakPath = filenamePath.substring(0, filenamePath.lastIndexOf(".")) + ".~idx";
    }

    private boolean checkFiles() {
        return !(filenamePath == null && idxnamePath == null);
    }
}
