package lab17;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import static lab17.StatisticsFrame.dtm2;

/**
 *
 * @author hp
 */
public class MainFrame extends javax.swing.JFrame {

    private String connection = "jdbc:mysql://localhost:3306/lab17";
    private String user = "root";
    private String password = "";
    private DefaultTableModel dtm = new DefaultTableModel();
    private StatisticsFrame statistics = new StatisticsFrame();
    private static final Pattern regex = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
    private static final Pattern regex2 = Pattern.compile("\\d+(\\.\\d{1,2})?");
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private int total;
    private int limit = 15;
    private int currentPage = 1;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.getContentPane().setBackground(new Color(204, 204, 255));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        dtm.addColumn("ID");
        dtm.addColumn("Êàòåãîð³ÿ");
        dtm.addColumn("Ñóìà âèòðàò");
        jTable.setModel(dtm);
        loadData(currentPage, limit);
    }

    public static String format(BigDecimal amount) {
        return formatter.format(amount);
    }

    private void getTotal() {
        String sql = "SELECT COUNT(*) FROM Expenses";
        int count = 0;
        try (Connection conn = DriverManager.getConnection(connection, user, password)) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    count = res.getInt(1);
                }
                total = (int) Math.ceil((double) count / limit);
                res.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData(int currentPage, int limit) {
        getTotal();
        try (Connection conn = DriverManager.getConnection(connection, user, password)) {
            int offset = (currentPage - 1) * limit;
            String sql = "SELECT Id, Category, Amount FROM Expenses LIMIT ? OFFSET ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, limit);
                preparedStatement.setInt(2, offset);
                ResultSet res = preparedStatement.executeQuery();
                while (res.next()) {
                    int id = res.getInt(1);
                    String category = res.getString(2);
                    BigDecimal amount = res.getBigDecimal(3);
                    String formattedAmount = format(amount);
                    dtm.addRow(new Object[]{id, category, formattedAmount});
                }
                res.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    private static BigDecimal parseAmount(String input) throws Exception {
        if (input.matches("\\d+(,\\d{1,2})?|\\d+(\\.\\d{1,2})?")) {
            return new BigDecimal(input.replace(",", "."));
        } else {
            throw new NumberFormatException("Íåïðàâèëüíèé ôîðìàò ñóìè");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        showStatisticsButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        clearButton = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();
        openButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ëàáîðàòîðíà ðîáîòà ¹17");
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);

        addButton.setText("Äîäàòè");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ïðîäóêòè", "Îäÿã òà âçóòòÿ", "Êîìóíàëüí³ ïîñëóãè", "Ë³êè", "²íøe" }));
        jComboBox.setToolTipText("");

        jLabel1.setText("Ñóìà âèòðàò:");

        jLabel2.setText("Âèáåð³òü êàòåãîð³þ:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable.setCellSelectionEnabled(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        updateButton.setText("Îíîâèòè");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        showStatisticsButton.setText("Ñòàòèñòèêà");
        showStatisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStatisticsButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Âèäàëèòè");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Ïîïåðåäíÿ");
        previousButton.setEnabled(false);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Íàñòóïíà");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jMenu.setText("Ôàéë");

        clearButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        clearButton.setText("Î÷èñòèòè");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jMenu.add(clearButton);

        saveButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveButton.setText("Çáåðåãòè ÿê");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jMenu.add(saveButton);

        openButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openButton.setText("Â³äêðèòè");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        jMenu.add(openButton);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showStatisticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showStatisticsButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try (Connection con = DriverManager.getConnection(connection, "root", "")) {
            String sql = "INSERT INTO Expenses (Category, Amount) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                String category = (String) jComboBox.getSelectedItem();
                BigDecimal amount = parseAmount(jTextField1.getText());
                preparedStatement.setString(1, category);
                preparedStatement.setBigDecimal(2, amount);
                preparedStatement.executeUpdate();
                String output = format(amount);
                int id = (int) dtm.getValueAt((dtm.getRowCount() - 1), 0);
                if (currentPage == total) {
                    dtm.addRow(new Object[]{id + 1, category, output});
                }
                System.out.println("Çàïèñ çàíåñåíî â òàáëèöþ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè çàïèñ³", "Ïîìèëêà", 1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè ï³äêëþ÷åíí³: " + e.getMessage(), "Ïîìèëêà", 1);
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        try (Connection con = DriverManager.getConnection(connection, "root", "")) {
            String sql = "TRUNCATE TABLE Expenses";
            try (Statement st = con.createStatement()) {
                st.executeUpdate(sql);
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè âèêîíàíí³ SQL-çàïèòó: " + se.getMessage(), "Ïîìèëêà", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè ï³äêëþ÷åíí³: " + e.getMessage(), "Ïîìèëêà", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        dtm.setRowCount(0);
        JOptionPane.showMessageDialog(null, "Òàáëèöÿ î÷èùåíà.", "Óñï³øíî", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = new File(fc.getSelectedFile().getAbsolutePath());
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    FileWriter fl = new FileWriter(file);
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        fl.write((String) dtm.getValueAt(i, 0) + "_" + (String) dtm.getValueAt(i, 1) + "_ãðí_\n");
                    }
                    fl.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = new File(fc.getSelectedFile().getAbsolutePath());
            String text = "";
            try {
                FileReader fr = new FileReader(file);
                int c;
                while ((c = fr.read()) != -1) {
                    text += (char) c;
                }
                String[] items = text.split("_");
                dtm.setRowCount(0);
                int j = 0;
                for (int i = 0; i < items.length / 3; i++) {
                    dtm.addRow(new Object[]{items[j], items[j + 1]});
                    j += 3;
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }//GEN-LAST:event_openButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            try (Connection con = DriverManager.getConnection(connection, "root", "")) {
                String sql = "UPDATE Expenses SET Amount = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        int id = (int) dtm.getValueAt(i, 0);
                        String cellValue = (String) dtm.getValueAt(i, 2);
                        String cleanedValue = cellValue.replaceAll("[^\\d.,]", "");
                        BigDecimal amount = parseAmount(cleanedValue);
                        preparedStatement.setBigDecimal(1, amount);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null, "Òàáëèöþ îíîâëåíî.", "Óñï³øíî", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè îíîâëåíí³ òàáëèö³: " + e.getMessage(), "Ïîìèëêà", 1);
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè ï³äêëþ÷åíí³ äî áàçè äàíèõ: " + e.getMessage(), "Ïîìèëêà", 1);
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Íåêîðåêòíèé ââ³ä äëÿ ñóìè îïëàòè", "Ïîìèëêà", 1);
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void showStatisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStatisticsButtonActionPerformed
        try (Connection con = DriverManager.getConnection(connection, "root", "")) {
            String sql = "SELECT Category, SUM(Amount) FROM Expenses GROUP BY Category";
            try (Statement st = con.createStatement()) {
                ResultSet result = st.executeQuery(sql);
                dtm2.setRowCount(0);
                while (result.next()) {
                    String output = format(result.getBigDecimal(2));
                    dtm2.addRow(new Object[]{result.getString(1), output});
                }
                statistics.setVisible(true);
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè âèêîíàíí³ SQL-çàïèòó: " + se.getMessage(), "Ïîìèëêà", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ïîìèëêà ïðè ï³äêëþ÷åíí³: " + e.getMessage(), "Ïîìèëêà", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_showStatisticsButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (jTable.getSelectedRow() != -1) {
            int id = (int) dtm.getValueAt(jTable.getSelectedRow(), 0);
            try (Connection con = DriverManager.getConnection(connection, user, password)) {
                String sql = "DELETE FROM expenses WHERE id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                dtm.removeRow(jTable.getSelectedRow());
                deleteButton.setEnabled(false);
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Помилка при виконанні SQL-запиту: " + se.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        if (jTable.getSelectedRow() != -1) {
            deleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        nextButton.setEnabled(true);
        dtm.setRowCount(0);
        if (currentPage > 1) {
            currentPage--;
            loadData(currentPage, limit);
        }
        if (currentPage == 1) {
            previousButton.setEnabled(false);
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        previousButton.setEnabled(true);
        dtm.setRowCount(0);
        getTotal();
        if (currentPage < total) {
            currentPage++;
            loadData(currentPage, limit);
        }
        if (currentPage == total) {
            nextButton.setEnabled(false);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem openButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JMenuItem saveButton;
    private javax.swing.JButton showStatisticsButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
