package musicapp;
import java.sql.Connection;
import java.sql.Statement;

public class TableManager {

    public void createTables() 
    {

        // To Creating All Tables:
        String sql1 = "CREATE TABLE IF NOT EXISTS Group7_Artist(ArtistID INT AUTO_INCREMENT PRIMARY KEY, ArtistFullName VARCHAR(150));";

        String sql2 = "CREATE TABLE IF NOT EXISTS Group7_Songs (SongID INT AUTO_INCREMENT PRIMARY KEY, SongName VARCHAR(150), Artist VARCHAR(150), Album VARCHAR(100), ReleaseYear INT, WhoAdded VARCHAR(100));";
        
        String sql3 = "CREATE TABLE IF NOT EXISTS Group7_Users (UserID INT AUTO_INCREMENT PRIMARY KEY, Username VARCHAR(100) NOT NULL UNIQUE, Password VARCHAR(100) NOT NULL);";

        try 
        {
            Connection con = OnlineDB.connectOnlineDB();
            Statement st = con.createStatement();

            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);

            System.out.println("Tables created successfully!");

        } 
        catch (Exception e) 
        {
            System.out.println("Tables not created!");
        }
    }
}
