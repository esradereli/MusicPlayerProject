package musicapp;

import java.sql.*;

public class TestQuery {

    public void QueryList() {

        // Test Querys:
        String sql1 = "select *from Group7_Songs";

        String sql2 = "select *from Group7_Artist";

        String sql3 = "select *from Group7_Users";

        try 
        {
            Connection con = OnlineDB.connectOnlineDB();
            Statement st = con.createStatement();

            // Listing Songs
            ResultSet rs1 = st.executeQuery(sql1);
            System.out.println("\nSongs:");        
            while (rs1.next()) 
            {
                System.out.println(
                        rs1.getInt("SongID") + " | "
                        + rs1.getString("SongName") + " | "
                        + rs1.getString("Artist") + " | "
                        + rs1.getString("Album") + " | "
                        + rs1.getInt("ReleaseYear") + " | "
                        + rs1.getString("WhoAdded")
                );
            }

            // Listing Artists
            ResultSet rs2 = st.executeQuery(sql2);
            System.out.println("\nArtists:");
            while (rs2.next()) 
            {
                System.out.println(
                        rs2.getInt("ArtistID") + " | "
                        + rs2.getString("ArtistFullName")
                );
            }

            // Listing Users
            ResultSet rs3 = st.executeQuery(sql3);
            System.out.println("\nUsers:");
            while (rs3.next()) 
            {
                System.out.println(
                        rs3.getInt("UserID") + " | "
                        + rs3.getString("Username") + " | "
                        + rs3.getString("Password")
                );
            }

            System.out.println("Tables Listed Successfully!");

        } 
        catch (Exception e) 
        {
            System.out.println("Error!");
        }
    }
}

