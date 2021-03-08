package Model;

public abstract class User { //Can't create an instance of itself except from an inherited class
    protected String userId;
    protected String username;

    public User(String userId, String username){
        this.userId = userId;
        this.username = username;
    }

    public User(String username){
        this.userId = Utility.generateId("user.txt", "U");
        this.username = username;
    }
    
    public User(){
        
    }
   
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
