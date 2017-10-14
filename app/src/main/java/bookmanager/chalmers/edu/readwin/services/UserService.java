package bookmanager.chalmers.edu.readwin.services;

import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.interfaces.IUserService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class UserService implements IUserService{
    public User getCurrentUser() {
        return new User(1, "Jens", "Jens123456789@gmail.com", "Jens", "Rasmusson", 2002, null, 350);
    }

    public void modifyCurrentUser(User user) {

    }

    public int createUser(User user) {
        return 1;
    }

}
