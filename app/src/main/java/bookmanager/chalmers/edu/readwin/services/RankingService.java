package bookmanager.chalmers.edu.readwin.services;

import android.content.Context;

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
    Context context; // TODO: Remove this when API has been implemented

    public RankingService(Context context) {
        this.context = context;
    }

    public RankingMonth getRankings(RankingMonth.Month month, int year) {

        UserService userService = new UserService(context);
        List<User> users = userService.getUserList();
        ArrayList<UserScore> scores = new ArrayList<UserScore>();

        for (User u: users) {
            scores.add(new UserScore(u.getId(), u.getUserName(), u.getCurrentScore()));
        }

        if(month == null)
            month = RankingMonth.Month.OCTOBER;
        if(year == 0)
            year = 2017;

        RankingMonth rankings = new RankingMonth();
        rankings.setId(1);
        rankings.setYear(year);
        rankings.setMonth(month);
        rankings.setUserScores(scores);

        return rankings;
    }
}
