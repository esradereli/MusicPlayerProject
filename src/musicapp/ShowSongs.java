package musicapp;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ShowSongs extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ShowSongs.class.getName());

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void loadSongs() 
    {
        try 
        {

            // To check if the database connection has been lost:
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            // SQL SELECT Query to Loading Songs:
            String sql = "SELECT *FROM Group7_Songs";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            // To creating Table Model:
            DefaultTableModel tm = (DefaultTableModel) Songs.getModel();

            // Writing datas:
            while (rs.next()) 
            {
                int SongId = rs.getInt("SongId");
                String SongName = rs.getString("SongName");
                String Artist = rs.getString("Artist");
                String Album = rs.getString("Album");
                int ReleaseYear = rs.getInt("ReleaseYear");
                String WhoAdded = rs.getString("WhoAdded");

                tm.addRow(new Object[]{SongId, SongName, Artist, Album, ReleaseYear, WhoAdded});

            }

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }

    public void loadSongs_Filtered() {
        try 
        {
            // To check if the database connection has been lost:
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            // SQL SELECT Query to Loading Filtered Songs:
            // So we used "Like" Keyword. Like Keyword Means "Not an exact match, bring something similar."
            String sql = "SELECT *FROM Group7_Songs Where SongName LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + SongName.getText() + "%");
            rs = pst.executeQuery();

            // To creating Table Model:
            DefaultTableModel tm = (DefaultTableModel) Songs.getModel();
            // To Reset All Rows for avoid repetitive data:
            tm.setRowCount(0);

            // Writing datas:
            while (rs.next()) 
            {
                int SongId = rs.getInt("SongId");
                String SongName = rs.getString("SongName");
                String Artist = rs.getString("Artist");
                String Album = rs.getString("Album");
                int ReleaseYear = rs.getInt("ReleaseYear");
                String WhoAdded = rs.getString("WhoAdded");

                tm.addRow(new Object[]{SongId, SongName, Artist, Album, ReleaseYear, WhoAdded});
            }

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Search Error!");
        }
    }

    public ShowSongs() {
        initComponents();
        conn = OnlineDB.connectOnlineDB();
        loadSongs();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Songs = new javax.swing.JTable();
        SongName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        Songs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Songs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Song Name", "Artist", "Album", "Release Year", "Who Added?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Songs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Songs.setRowMargin(2);
        jScrollPane1.setViewportView(Songs);
        if (Songs.getColumnModel().getColumnCount() > 0) {
            Songs.getColumnModel().getColumn(0).setResizable(false);
            Songs.getColumnModel().getColumn(1).setResizable(false);
            Songs.getColumnModel().getColumn(2).setResizable(false);
            Songs.getColumnModel().getColumn(3).setResizable(false);
            Songs.getColumnModel().getColumn(4).setResizable(false);
            Songs.getColumnModel().getColumn(5).setResizable(false);
        }

        SongName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SongName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SongName.addActionListener(this::SongNameActionPerformed);
        SongName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SongNameKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Write the Song Name:");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SongName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(115, 115, 115))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(66, 66, 66)))
                        .addGap(61, 61, 61)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SongName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SongNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SongNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SongNameActionPerformed

    private void SongNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SongNameKeyReleased
        //To activate it if a key is pressed in the search section:
        loadSongs_Filtered();
    }//GEN-LAST:event_SongNameKeyReleased

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
        java.awt.EventQueue.invokeLater(() -> new ShowSongs().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SongName;
    private javax.swing.JTable Songs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
