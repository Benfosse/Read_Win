package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;

import bookmanager.chalmers.edu.readwin.Cryptor;
import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.interfaces.IBookService;
import bookmanager.chalmers.edu.readwin.services.interfaces.IUserService;

/**
 * Created by benedikt on 13/10/2017.
 */


public class UserService implements IUserService {

    ArrayList<User> users = new ArrayList<User>();

    String passwordhash = Cryptor.encryptIt("password");

    public UserService() {
        this.addUsers(this.createUser(0, "Error", "error@chalmers.se", "Error", "Error", 0000, "none", 0, passwordhash));
        this.addUsers(this.createUser(1, "Ben", "benjamin@chalmers.se", "Benjamin", "Fosse", 1995, "none", 0, passwordhash));
        this.addUsers(this.createUser(2, "Andre", "andre@chalmers.se", "Andre", "Ranito", 1994, "none", 0, passwordhash));
        this.addUsers(this.createUser(3, "Bene", "benedikt@chalmers.se", "Benedikt", "Sigurleifsson", 1992, "none", 0, passwordhash));
        this.addUsers(this.createUser(4, "Steph", "stephane@chalmers.se", "Stephane", "Wagner", 1995, "none", 0, passwordhash));

    }

    public User getCurrentUser() {
        return new User(1, "Jens", "Jens123456789@gmail.com", "Jens", "Rasmusson", 2002, null, 350);
    }

    public void modifyCurrentUser(User user) {

    }

    public User createUser(int id, String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, int currentScore, String password) {
        User user = new User(id, userName, email, firstName, lastName, yearOfBirth, avatar, currentScore, passwordhash);
        return user;
    }

    public ArrayList<User> addUsers(User user) {
        users.add(user);
        return users;
    }

    public ArrayList<User> getUserList (){
        return users;
    }

    public User getUser(String email) {
        int i = 0;
        while ((users.get(i).getEmail().equals(email) != true) && i < users.size()-1) {
            i += 1;
        }
        if(users.get(i).getEmail().equals(email)){
        return users.get(i);
        }
        else{
            return users.get(0);
        }
    }
}
