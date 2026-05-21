package musicapp;

import java.sql.*;


public class MusicApp {

    public static void main(String[] args) {

        // Testing DB Connection
        Connection con = OnlineDB.connectOnlineDB();
        
        // Creating Tables
        //TableManager tm = new TableManager();
        //tm.createTables();
        
        // Testing Querys
        //TestQuery tq = new TestQuery();
        //tq.QueryList();
        
        
        
        //Loading the Theme (Flatlaf Carbon)
         try {
            com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //Login Page
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
        
        

        

        
        
        

    }

}
