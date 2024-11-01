package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITransfer extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTextField noRek;
    JTextField jumlahTf;
    JPasswordField pin;
    GUIMenuM gMen;
    loginConstructor lC;
    int saldoUser;
    int saldoUserTujuan;
    queryDB lDB = new queryDB();
    String usrCode;
    int i = 0;
    int j = 0;

    public GUITransfer(loginConstructor lC) {
        this.frame = new JFrame();
        this.lC = new loginConstructor(); // Initialize lC here

        usrCode = lC.getUserCode();

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(92, 225, 230));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal resizing
        constraints.weightx = 0.5; // Allow the text field to grow in width

        // Menambahkan gambar ke dalam JFrame
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel imageLabel = new JLabel(logo);
        constraints.gridy = 0;
        panel.add(imageLabel, constraints);

        noRek = new JTextField();
        noRek.setEditable(true);
        noRek.setFocusable(true);
        noRek.setHorizontalAlignment(SwingConstants.CENTER);
        noRek.setBackground(new Color(246,246,246));
        noRek.setFont(new Font("", Font.BOLD, 14));

        JLabel rek = new JLabel("Rekening Yang Dituju : ");

        jumlahTf = new JTextField(6);
        jumlahTf.setEditable(true);
        jumlahTf.setFocusable(true);
        jumlahTf.setHorizontalAlignment(SwingConstants.CENTER);
        jumlahTf.setBackground(new Color(246,246,246));
        jumlahTf.setFont(new Font("", Font.BOLD, 14));

        JLabel tf = new JLabel("Jumlah Saldo Yang Ingin Di Transfer : ");

        pin = new JPasswordField(4);
        pin.setEditable(true);
        pin.setFocusable(true);
        pin.setHorizontalAlignment(SwingConstants.CENTER);
        pin.setBackground(new Color(246,246,246));
        pin.setFont(new Font("", Font.BOLD, 14));

        JLabel pinL = new JLabel("Masukkan Pin Anda : ");

        JButton mEnter = new JButton("Transfer");
        mEnter.setFocusable(false);
        mEnter.setBackground(new Color(38, 74, 77));
        mEnter.setForeground(new Color(246, 246, 246));
        mEnter.setPreferredSize(new Dimension(200, 30));
        mEnter.addActionListener(this);
        mEnter.setActionCommand("entLog");

        constraints.gridy = 1; // Set the position for the first button
        panel.add(rek, constraints);

        constraints.gridy = 2; // Set the position for the first button
        panel.add(noRek, constraints);

        constraints.gridy = 3; // Set the position for the first button
        panel.add(tf, constraints);

        constraints.gridy = 4; // Set the position for the first button
        panel.add(jumlahTf, constraints);

        constraints.gridy = 5; // Set the position for the first button
        panel.add(pinL, constraints);

        constraints.gridy = 6; // Set the position for the first button
        panel.add(pin, constraints);

        constraints.gridy = 7; // Set the position for the second button
        panel.add(mEnter,constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Transfer");
        frame.setSize(300, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk action button
        String ac = e.getActionCommand();
        if ("entLog".equals(ac)){
            if(lDB.cekRekTujuan(Integer.parseInt(noRek.getText()))){
                try {
                    Integer.parseInt(jumlahTf.getText());
                    if(lDB.cekPin(pin.getText(), usrCode)) {
                        saldoUser = lDB.uangUser(usrCode) - Integer.parseInt(jumlahTf.getText());
                        lDB.updateUangUser(saldoUser, lDB.noRekUser(usrCode));

                        saldoUserTujuan = lDB.uangNoRekTujuan(Integer.parseInt(noRek.getText())) + Integer.parseInt(jumlahTf.getText());
                        lDB.updateUangNoRekTujuan(saldoUserTujuan, Integer.parseInt(noRek.getText()));
                        frame.dispose();

                        i = lDB.getRowCount() + 1;
                        lDB.updateMutasiUser(i, lDB.noRekUser(usrCode), Integer.parseInt(jumlahTf.getText()));

                        i = lDB.getRowCount() + 1;
                        lDB.updateMutasiMasuk(i, Integer.parseInt(noRek.getText()), Integer.parseInt(jumlahTf.getText()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Pin Yang Anda Masukkan Salah!!!", "Pin Tidak Valid", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukkan Input Saldo Transfer Yang Benar", "Input Tidak Valid", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Nomor Rekening Yang Anda Masukkan Salah!!!", "Rekening Tidak Valid", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

