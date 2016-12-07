package homework.lab12;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppendDataForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    private JTextField houseNumberTextField;
    private JTextField apartmentNumberTextField;
    private JTextField addressTextField;
    private JTextField ownerTextField;
    private JTextField paymentDateTextField;
    private JTextField paymentSumTextField;
    private JTextField penaltyPercentTextField;
    private JTextField daysExpiredTextField;
    private JLabel houseNumberLabel;
    private JLabel apartmentNumberLabel;
    private JLabel addressLabel;
    private JLabel ownerLabel;
    private JLabel paymentDateLabel;
    private JLabel paymentSumLabel;
    private JLabel penaltyPercentLabel;
    private JLabel daysExpiredLabel;

    private Bill bill = null;

    public AppendDataForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(),
                                                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                                                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setVisible(true);
    }

    private void onOK() {
        String s = fin.nextLine();
        String[] strings = s.split(" ");
        StringBuilder sB = new StringBuilder();
        if (strings.length == 3) {
            bill.owner = sB.append(strings[0]).append(" ")
                    .append(strings[1]).append(" ")
                    .append(strings[2]).toString();
        } else {
            throw new IllegalArgumentException("Invalid full name data");
        }
        if (!nextRead(P_paymentDate, fin, out)) {
            return null;
        }

        bill = new Bill(Integer.parseInt(houseNumberTextField.getText()),
                        Integer.parseInt(apartmentNumberTextField.getText()),
                        addressTextField.getText(),
                        ownerTextField.getText(),
                        LocalDate.parse(paymentDateTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        Double.parseDouble(paymentSumTextField.getText()),
                        penaltyPercentTextField.getText(),
                        Integer.parseInt(daysExpiredTextField.getText()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Bill getBill() {
        return bill;
    }
}
