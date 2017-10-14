package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by benedikt on 12/10/2017.
 */

public class UserScore {
    private int UserId;
    private String UserName;
    private int Score;

    public UserScore(int userId, String userName, int score) {
        UserId = userId;
        UserName = userName;
        Score = score;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
