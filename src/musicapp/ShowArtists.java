package musicapp;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ShowArtists extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ShowArtists.class.getName());

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void loadArtists() 
    {
        try 
        {
            // To check if the database connection has been lost:
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            // SQL SELECT Query to Loading Artists:
            String sql = "SELECT *FROM Group7_Artist";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            DefaultTableModel tm = (DefaultTableModel) Artists.getModel();

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

    public void loadArtists_Filtered() {
        try 
        {
            // To check if the database connection has been lost:
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            // SQL SELECT Query to Loading Filtered Artists:
            // So we used "Like" Keyword. Like Keyword Means "Not an exact match, bring something similar."
            String sql = "SELECT *FROM Group7_Artist Where ArtistFullName LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + ArtistFullName.getText() + "%");
            rs = pst.executeQuery();

            // To creating Table Model:
            DefaultTableModel tm = (DefaultTableModel) Artists.getModel();
            // To Reset All Rows for avoid repetitive data:
            tm.setRowCount(0);

            // Writing datas:
            while (rs.next()) 
            {
                int ArtistID = rs.getInt("ArtistID");
                String ArtistFullName = rs.getString("ArtistFullName");

                tm.addRow(new Object[]{ArtistID, ArtistFullName});
            }

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Search Error!");
        }
    }

    public ShowArtists() 
    {
        initComponents();
        conn = OnlineDB.connectOnlineDB();
        loadArtists();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Artists = new javax.swing.JTable();
        ArtistFullName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(Artists);

        ArtistFullName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ArtistFullName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ArtistFullName.addActionListener(this::ArtistFullNameActionPerformed);
        ArtistFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ArtistFullNameKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Write the Artist's Name:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArtistFullName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(105, 105, 105)))
                        .addGap(50, 50, 50)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArtistFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArtistFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArtistFullNameActionPerformed

    private void ArtistFullNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ArtistFullNameKeyReleased
        //To activate it if a key is pressed in the search section:
        loadArtists_Filtered();
    }//GEN-LAST:event_ArtistFullNameKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
    }//GEN-LAST:event_jButton1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ShowArtists().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ArtistFullName;
    private javax.swing.JTable Artists;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
