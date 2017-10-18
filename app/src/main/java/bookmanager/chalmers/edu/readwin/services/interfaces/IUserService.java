package bookmanager.chalmers.edu.readwin.services.interfaces;

import java.util.ArrayList;

import bookmanager.chalmers.edu.readwin.models.User;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IUserService {
    User getCurrentUser();
    void modifyCurrentUser(User user);
    User createUser(int id, String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, int currentScore, String password);
    public ArrayList<User> addUsers(User user);
    public User getUser(String email);
}
