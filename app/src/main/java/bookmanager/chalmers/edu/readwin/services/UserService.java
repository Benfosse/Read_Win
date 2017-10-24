package bookmanager.chalmers.edu.readwin.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bookmanager.chalmers.edu.readwin.Cryptor;
import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.interfaces.IBookService;
import bookmanager.chalmers.edu.readwin.services.interfaces.IUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
/**
 * Created by benedikt on 13/10/2017.
 */


public class UserService implements IUserService {

    Context context; // TODO: Remove this when API has been implemented

    public UserService(Context context) {
        this.context = context;
    }

    public User getCurrentUser() {
        try {
            SharedPreferences sharedpreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            return gson.fromJson(sharedpreferences.getString("currentUser", ""), User.class);
        } catch (Exception e) {
            // TODO: Error handling
            throw e;
        }
    }

    public void modifyCurrentUser(User user) {
        User currentUser = getUser(user.getId());
        List<User> users = getUserList();

        for(int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if(u.getUserName().equals(currentUser.getUserName()))
                users.remove(i);
        }

        currentUser.setEmail(user.getEmail());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setYearOfBirth(user.getYearOfBirth());
        currentUser.setPassword(Cryptor.encryptIt(user.getPassword()));

        users.add(currentUser);

        SharedPreferences sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String serializedUser = gson.toJson(currentUser);
        String serializedUserList = gson.toJson(users);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(user.getId()), serializedUser);
        editor.remove("currentUser");
        editor.remove("users");
        editor.putString("currentUser", serializedUser);
        editor.putString("users", serializedUserList);
        editor.commit();
    }

    public User createUser(String userName, String email, String firstName, String lastName, int yearOfBirth, String avatar, String password) {
        List<User> users = getUserList();
        int id = users.size();
        User user = new User(id, userName, email, firstName, lastName, yearOfBirth, avatar, 0, Cryptor.encryptIt(password));
        users.add(user);

        SharedPreferences sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String serializedUser = gson.toJson(user);
        String serializedUserList = gson.toJson(users);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(user.getId()), serializedUser);
        editor.remove("currentUser");
        editor.remove("users");
        editor.putString("currentUser", serializedUser);
        editor.putString("users", serializedUserList);
        editor.commit();

        return user;
    }

    // TODO: Make private function when we start using api, being used in ranking service
    public List<User> getUserList() {
        try {
            SharedPreferences sharedpreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
            Gson gson = new Gson();

            String list = sharedpreferences.getString("users", "");
            Type userListType = new TypeToken<List<User>>() {
            }.getType();
            List<User> userList = gson.fromJson(list, userListType);
            if(userList == null)
                return new ArrayList<User>();
            return userList;

        } catch (Exception e) {
            // TODO: Error handling
            throw e;
        }
    }

    // TODO: Make private or remove function when we start using api
    public User getUser(String email) {
        List<User> users = getUserList();

        for(User user: users) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void login(User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String serializedUser = gson.toJson(user);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("currentUser", serializedUser);
        editor.commit();
    }

    private User getUser(int userId) {
        try {
            SharedPreferences sharedpreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            return gson.fromJson(sharedpreferences.getString(String.valueOf(userId), ""), User.class);
        } catch (Exception e) {
            // TODO: Error handling
            throw e;
        }
    }

    private void debug()
    {
        User user = getCurrentUser();
        Log.d("CURRENT USER", "UserId: " + String.valueOf(user.getId()) + "\nFirst Name: " + user.getFirstName() + "\nLast Name: " + user.getLastName()
        + "\nEmail: " + user.getEmail() + "\nPassword: " + user.getPassword());

        List<User> users = getUserList();
        for (User u: users) {
            Log.d("USER", "UserId: " + String.valueOf(u.getId()) + "\nFirst Name: " + u.getFirstName() + "\nLast Name: " + u.getLastName()
                    + "\nEmail: " + u.getEmail() + "\nPassword: " + u.getPassword());
        }
    }
}
