package bookmanager.chalmers.edu.readwin.models;

import java.time.Year;
import java.util.List;

/**
 * Created by benedikt on 12/10/2017.
 */

public class User {
    private int Id;
    private String UserName;
    private String Email;
    private String FirstName;
    private String LastName;
    private int YearOfBirth;
    private String Avatar;
    private int CurrentScore;
    private String password;
    private String passwordhash;
    private List<User> Users;

    public User(int id, String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, int currentScore) {
        Id = id;
        UserName = userName;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        YearOfBirth = yearOfBirth;
        Avatar = avatar;
        CurrentScore = currentScore;
    }

    public List addUser(List<User> Users, User User1){
        Users.add(User1);
        return Users;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getCurrentScore() {
        return CurrentScore;
    }

    public void setCurrentScore(int currentScore) {
        CurrentScore = currentScore;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public String getPassword() {
        return password;
    }
}
