package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIMutasi extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;
    GUIMenuM gMen;
    loginConstructor lC;
    queryDB lDB = new queryDB();
    String userCode;
    int noRek;

    public GUIMutasi(loginConstructor lC) {
        this.frame = new JFrame();
        this.lC = lC; // Initialize lC here

        userCode = lC.getUserCode();

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(92, 225, 230));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;

        JLabel rek = new JLabel("Mutasi Rekening Anda : ");

        // Add Title Label
        JLabel rekLabel = new JLabel("Mutasi Rekening Anda:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(rekLabel, constraints);

        // Fetch and Prepare Table Data
        noRek = lDB.noRekUser(userCode);
        List<queryDB.Mutasi> mutasiList = lDB.MutasiRekening(noRek);

        String[][] mutasiRows = new String[mutasiList.size()][3];
        for (int i = 0; i < mutasiList.size(); i++) {
            queryDB.Mutasi mutasi = mutasiList.get(i);
            mutasiRows[i][0] = mutasi.tanggal;
            mutasiRows[i][1] = mutasi.tipeMutasi;
            mutasiRows[i][2] = mutasi.saldoMutasi;
        }

        String[] columnNames = {"Tanggal", "Tipe Mutasi", "Saldo Mutasi"};
        JTable table = new JTable(mutasiRows, columnNames);
        table.setBackground(Color.WHITE);

        // Center text in "Tipe Mutasi" column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        // Adjust column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(170);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

        // Add Table to ScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        panel.add(tableScrollPane, constraints);

        JButton mEnter = new JButton("Done");
        mEnter.setFocusable(false);
        mEnter.setBackground(new Color(38, 74, 77));
        mEnter.setForeground(new Color(246, 246, 246));
        mEnter.setPreferredSize(new Dimension(200, 30));
        mEnter.addActionListener(this);
        mEnter.setActionCommand("entLog");

        constraints.gridy = 1; // Set the position for the first button
        panel.add(rek, constraints);

        constraints.gridy = 3; // Set the position for the first button
        panel.add(mEnter, constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Mutasi");
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk action button
        String ac = e.getActionCommand();
        if ("entLog".equals(ac)){
            GUIMenuM gM = new GUIMenuM(lC);
            frame.dispose();
        }
    }
}