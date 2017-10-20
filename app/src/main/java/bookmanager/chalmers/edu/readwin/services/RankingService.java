package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.RankingMonth;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.models.UserScore;
import bookmanager.chalmers.edu.readwin.services.interfaces.IRankingService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class RankingService implements IRankingService {
    public RankingMonth getRankings(RankingMonth.Month month, int year) {
        UserScore userScore1 = new UserScore(1, "Jens", 350);
        UserScore userScore2 = new UserScore(2, "Rasmus", 550);
        UserScore userScore3 = new UserScore(3, "Niklas", 220);
        UserScore userScore4 = new UserScore(4, "Harry", 110);
        UserScore userScore5 = new UserScore(5, "Rebekka", 700);

        ArrayList<UserScore> userScores = new ArrayList<>();
        userScores.add(userScore1);
        userScores.add(userScore2);
        userScores.add(userScore3);
        userScores.add(userScore4);
        userScores.add(userScore5);

        if(month == null)
            month = RankingMonth.Month.OCTOBER;
        if(year == 0)
            year = 2017;

        RankingMonth rankings = new RankingMonth();
        rankings.setId(1);
        rankings.setYear(year);
        rankings.setMonth(month);
        rankings.setUserScores(userScores);

        return rankings;
    }
}
