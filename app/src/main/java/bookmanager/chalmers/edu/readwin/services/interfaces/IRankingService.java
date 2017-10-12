package bookmanager.chalmers.edu.readwin.services.interfaces;

import bookmanager.chalmers.edu.readwin.models.RankingMonth;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IRankingService {
    RankingMonth getRankings(RankingMonth.Month month, int year);
}
