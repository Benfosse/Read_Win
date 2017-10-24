package bookmanager.chalmers.edu.readwin.services.interfaces;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.User;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IUserService {
    User getCurrentUser();
    void modifyCurrentUser(User user);
    User createUser(String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, String password);
    User getUser(String email); // TODO: Remove when API has been implemented
    void login(User user); // TODO: Remove when API has been implemented
    List<User> getUserList(); // TODO: Remove when API has been implemented
}
