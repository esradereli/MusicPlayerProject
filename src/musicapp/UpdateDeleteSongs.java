package musicapp;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UpdateDeleteSongs extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UpdateDeleteSongs.class.getName());

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // For loading songs to table:
    public void loadSongs() 
    {
        try 
        {
            String sql = "SELECT *FROM Group7_Songs";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            DefaultTableModel tm = (DefaultTableModel) SongList.getModel();
            tm.setRowCount(0);

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

    // For Loading artists to combobox:
    public void loadArtists() 
    {
        try 
        {
            String sql = "SELECT ArtistFullName FROM Group7_Artist";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            Artist.removeAllItems();

            while (rs.next()) 
            {
                Artist.addItem(rs.getString("ArtistFullName"));
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
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
        SongName.setText("");
        Artist.setSelectedItem("");
        Album.setText("");
        ReleaseYear.setText("");
    }

    public UpdateDeleteSongs() 
    {
        initComponents();
        DeleteConfirmation_Def();
        conn = OnlineDB.connectOnlineDB();
        loadSongs();
        loadArtists();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        SongList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        SongName = new javax.swing.JTextField();
        Album = new javax.swing.JTextField();
        ReleaseYear = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Artist = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        AYS = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AYS_Yes = new javax.swing.JButton();
        AYS_No = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SongList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SongList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Song Name", "Artist", "Album", "Release Year", "Who Added"
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
        SongList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SongList.setRowMargin(2);
        SongList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SongListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SongList);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delete Chosen Song");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Update Chosen Song");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID (You Cannot Change)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Song Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Artist");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Album");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Release Year");

        ID.setEditable(false);
        ID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        SongName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SongName.addActionListener(this::SongNameActionPerformed);

        Album.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Album.addActionListener(this::AlbumActionPerformed);

        ReleaseYear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReleaseYear.addActionListener(this::ReleaseYearActionPerformed);

        Delete.setBackground(new java.awt.Color(255, 0, 0));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(this::DeleteActionPerformed);

        Update.setBackground(new java.awt.Color(255, 204, 51));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(this::UpdateActionPerformed);

        Artist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Artist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Warning!");

        AYS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AYS.setText("Are You Sure?");

        jLabel10.setText("Please think twice before deleting.");

        AYS_Yes.setBackground(new java.awt.Color(255, 0, 0));
        AYS_Yes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AYS_Yes.setForeground(new java.awt.Color(255, 255, 255));
        AYS_Yes.setText("Yes");
        AYS_Yes.addActionListener(this::AYS_YesActionPerformed);

        AYS_No.setBackground(new java.awt.Color(0, 255, 51));
        AYS_No.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AYS_No.setText("No");
        AYS_No.addActionListener(this::AYS_NoActionPerformed);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("This action is irreversible. ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ReleaseYear)
                                    .addComponent(Album)
                                    .addComponent(Artist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SongName)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addGap(178, 178, 178)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(147, 147, 147))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addGap(15, 15, 15)))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(AYS_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(AYS_No, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(AYS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(ID))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SongName)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Artist)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Album)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(AYS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(AYS_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(AYS_No))))
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SongNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SongNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SongNameActionPerformed

    private void AlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlbumActionPerformed

    private void ReleaseYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReleaseYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReleaseYearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        //To turn of verification:
        DeleteConfirmation_Act();
    }//GEN-LAST:event_DeleteActionPerformed

    private void AYS_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AYS_NoActionPerformed
        //To turn on verification:
        DeleteConfirmation_Def();
    }//GEN-LAST:event_AYS_NoActionPerformed

    private void SongListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SongListMouseClicked

        // To print the data from the selected rows into textfields when any data is selected in the list:    
        int selectedRow = SongList.getSelectedRow();
        String songID = SongList.getValueAt(selectedRow, 0).toString();
        String songName = SongList.getValueAt(selectedRow, 1).toString();
        String artist = SongList.getValueAt(selectedRow, 2).toString();
        String album = SongList.getValueAt(selectedRow, 3).toString();
        String releaseYear = SongList.getValueAt(selectedRow, 4).toString();

        ID.setText(songID);
        SongName.setText(songName);
        Artist.setSelectedItem(artist);
        Album.setText(album);
        ReleaseYear.setText(releaseYear);

    }//GEN-LAST:event_SongListMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed

        // SQL UPDATE Query for Songs:
        String sql = "UPDATE Group7_Songs SET SongName = ?, Artist = ?, Album = ?, ReleaseYear = ? WHERE SongID = ?";

        try 
        {
            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            pst = conn.prepareStatement(sql);
            pst.setString(1, SongName.getText());
            pst.setString(2, (String) Artist.getSelectedItem());
            pst.setString(3, Album.getText());
            pst.setString(4, ReleaseYear.getText());
            pst.setString(5, ID.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chosen Song Updated!");
            EmptyInputs();
            loadSongs();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Failed. Please check the informations.");
            e.printStackTrace();
        }


    }//GEN-LAST:event_UpdateActionPerformed

    private void AYS_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AYS_YesActionPerformed

        // SQL DELETE Query for Songs:
        String sql = "delete from Group7_Songs Where SongId = ?";

        try 
        {

            if (conn == null || conn.isClosed()) 
            {
                conn = OnlineDB.connectOnlineDB();
            }

            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chosen Song Deleted!");
            DeleteConfirmation_Def();
            EmptyInputs();
            loadSongs();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Failed.");
            e.printStackTrace();
        }

    }//GEN-LAST:event_AYS_YesActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new UpdateDeleteSongs().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AYS;
    private javax.swing.JButton AYS_No;
    private javax.swing.JButton AYS_Yes;
    private javax.swing.JTextField Album;
    private javax.swing.JComboBox<String> Artist;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ReleaseYear;
    private javax.swing.JTable SongList;
    private javax.swing.JTextField SongName;
    private javax.swing.JButton Update;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
