package musicapp;

public class Session {

    // It was written using the singleton design pattern. 
    // To prevent multiple sessions from running simultaneously 
    // while the program is open, the object was created statically.
    private static Session instance;

    private int userID;
    private String username;
    private boolean loggedIn;

    private Session() 
    {
        loggedIn = false;
    }

    public static Session getInstance() 
    {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // MORE IMPORTANT!
    public void login(int userID, String username) 
    {
        this.userID = userID;
        this.username = username;
        this.loggedIn = true;
    }

    // MORE IMPORTANT!
    public void logout() 
    {
        this.userID = -1;
        this.username = null;
        this.loggedIn = false;
    }

    public int getUserID() 
    {
        return userID;
    }

    public String getUsername() 
    {
        return username;
    }

    public boolean isLoggedIn() 
    {
        return loggedIn;
    }
    
}
