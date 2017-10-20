package bookmanager.chalmers.edu.readwin.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benedikt on 12/10/2017.
 */

public class RankingMonth {
    public enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}

    private int Id;
    private int Year;
    private Month Month;
    private ArrayList<UserScore> UserScores;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public RankingMonth.Month getMonth() {
        return Month;
    }

    public void setMonth(RankingMonth.Month month) {
        Month = month;
    }

    public ArrayList<UserScore> getUserScores() {
        return UserScores;
    }

    public void setUserScores(ArrayList<UserScore> userScores) {
        UserScores = userScores;
    }
}
