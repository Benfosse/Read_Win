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
        List<UserScore> userScores = new ArrayList<>();
        userScores.add(userScore1);
        userScores.add(userScore2);

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
