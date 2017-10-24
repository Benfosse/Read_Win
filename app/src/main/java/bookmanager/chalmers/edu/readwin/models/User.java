package bookmanager.chalmers.edu.readwin.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by benedikt on 12/10/2017.
 */

public class User implements Parcelable {
    private int Id;
    private String UserName;
    private String Email;
    private String FirstName;
    private String LastName;
    private int YearOfBirth;
    private String Avatar;
    private int CurrentScore;
    private String Password;
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

    public User(int id, String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, int currentScore, String password) {
        Id = id;
        UserName = userName;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        YearOfBirth = yearOfBirth;
        Avatar = avatar;
        CurrentScore = currentScore;
        Password=password;
    }

    public List addUser(List<User> Users, User User1){
        Users.add(User1);
        return Users;
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
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(Parcel parcel) {
        String[] data = new String[9];

        parcel.readStringArray(data);

        this.Id = Integer.parseInt(data[0]);
        this.Email = data[1];
        this.UserName = data[2];
        this.FirstName = data[3];
        this.LastName = data[4];
        this.YearOfBirth = Integer.parseInt(data[5]);
        this.Avatar = data[6];
        this.CurrentScore = Integer.parseInt(data[7]);
        this.Password = data[8];
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] { String.valueOf(this.Id), this.Email, this.UserName, this.FirstName, this.LastName, String.valueOf(this.YearOfBirth), this.Avatar, String.valueOf(this.CurrentScore), this.Password });
    }
}
