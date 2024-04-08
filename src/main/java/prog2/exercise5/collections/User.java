package prog2.exercise5.collections;

public class User {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userID;
    public User(String firstName, String lastName, String userEmail, String userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userID = userID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    @Override
    public String toString() {
        return "The user details:"+"\n"+
        "User ID:"+ userID+"\n"+  
        "User First Name:" + firstName + "\n"+
        "User Last Name:" + lastName + "\n"+
        "User Email:" + userEmail; 
    }
    
}
