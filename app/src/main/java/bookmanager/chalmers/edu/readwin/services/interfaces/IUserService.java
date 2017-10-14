package bookmanager.chalmers.edu.readwin.services.interfaces;

import bookmanager.chalmers.edu.readwin.models.User;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IUserService {
    User getCurrentUser();
    void modifyCurrentUser(User user);
    int createUser(User user);
}
