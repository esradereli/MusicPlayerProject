package musicapp;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UpdateDeleteArtists extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UpdateDeleteArtists.class.getName());

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UpdateDeleteArtists() 
    {
        initComponents();
        DeleteConfirmation_Def();
        conn = OnlineDB.connectOnlineDB();
        loadArtists();
    }

    // Verification part code 1;
    public void DeleteConfirmation_Def() 
    {
        AYS.setVisible(false);
        AYS_Yes.setVisible(false);
        AYS_No.setVisible(false);
    }

    // Verification part code 2;
    public void DeleteConfirmation_Act() 
    {
        AYS.setVisible(true);
        AYS_Yes.setVisible(true);
        AYS_No.setVisible(true);
    }

    // Empty Inputs operations for after updating/deleting:
    public void EmptyInputs() 
    {
        ID.setText("");
        ArtistFullName.setText("");
    }

    // For Loading artists to Table:
    public void loadArtists() 
    {
        try 
        {
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            String sql = "SELECT *FROM Group7_Artist";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            DefaultTableModel tm = (DefaultTableModel) Artists.getModel();
            tm.setRowCount(0);

            while (rs.next()) 
            {
                int ArtistID = rs.getInt("ArtistID");
                String ArtistFullName = rs.getString("ArtistFullName");

                tm.addRow(new Object[]{ArtistID, ArtistFullName});
            }

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Artists = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        AYS_Yes = new javax.swing.JButton();
        AYS_No = new javax.swing.JButton();
        AYS = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ArtistFullName = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Artists.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Artists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Artists.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Artists.setRowMargin(2);
        Artists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArtistsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Artists);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Update Chosen Artist");

        Update.setBackground(new java.awt.Color(255, 204, 51));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(this::UpdateActionPerformed);

        AYS_Yes.setBackground(new java.awt.Color(255, 0, 0));
        AYS_Yes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AYS_Yes.setForeground(new java.awt.Color(255, 255, 255));
        AYS_Yes.setText("Yes");
        AYS_Yes.addActionListener(this::AYS_YesActionPerformed);

        AYS_No.setBackground(new java.awt.Color(0, 255, 51));
        AYS_No.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AYS_No.setText("No");
        AYS_No.addActionListener(this::AYS_NoActionPerformed);

        AYS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AYS.setText("Are You Sure?");

        Delete.setBackground(new java.awt.Color(255, 0, 0));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(this::DeleteActionPerformed);

        jLabel10.setText("Please think twice before deleting.");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("This action is irreversible. ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Warning!");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delete Chosen Artist");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ID (You Cannot Change)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Artist's FullName");

        ArtistFullName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ArtistFullName.addActionListener(this::ArtistFullNameActionPerformed);

        ID.setEditable(false);
        ID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(178, 178, 178))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ArtistFullName)
                                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(147, 147, 147))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                                .addGap(15, 15, 15)))
                                        .addGap(17, 17, 17))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(AYS_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(AYS_No, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(AYS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(102, 102, 102))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ArtistFullName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AYS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AYS_No, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AYS_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed

        // SQL UPDATE Query for Artists:
        String sql = "UPDATE Group7_Artist SET ArtistFullName = ? WHERE ArtistID = ?";

        try 
        {
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            pst = conn.prepareStatement(sql);
            pst.setString(1, ArtistFullName.getText());;
            pst.setString(2, ID.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chosen Artist Updated!");
            EmptyInputs();
            loadArtists();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Failed. Please check the informations.");
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void AYS_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AYS_YesActionPerformed

        // SQL DELETE Query for Artists:
        String sql = "delete from Group7_Artist Where ArtistID = ?";

        try 
        {
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chosen Artist Deleted!");
            DeleteConfirmation_Def();
            EmptyInputs();
            loadArtists();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Failed.");
        }

    }//GEN-LAST:event_AYS_YesActionPerformed

    private void AYS_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AYS_NoActionPerformed
        //To turn of verification:
        DeleteConfirmation_Def();
    }//GEN-LAST:event_AYS_NoActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        //To turn on verification:
        DeleteConfirmation_Act();
    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ArtistFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArtistFullNameActionPerformed

    private void ArtistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArtistsMouseClicked

        // To print the data from the selected rows into textfields when any data is selected in the list:    
        int selectedRow = Artists.getSelectedRow();
        String ArtistID = Artists.getValueAt(selectedRow, 0).toString();
        String ArtistFullName_ = Artists.getValueAt(selectedRow, 1).toString();

        ID.setText(ArtistID);
        ArtistFullName.setText(ArtistFullName_);

    }//GEN-LAST:event_ArtistsMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UpdateDeleteArtists().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AYS;
    private javax.swing.JButton AYS_No;
    private javax.swing.JButton AYS_Yes;
    private javax.swing.JTextField ArtistFullName;
    private javax.swing.JTable Artists;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField ID;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
