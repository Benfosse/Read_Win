package bookmanager.chalmers.edu.readwin.helpers;

/**
 * Created by benedikt on 24/10/2017.
 */

public class UserValidator {
    public static boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    public static boolean isYearofBirthValid(int yearofbirth) {
        //TODO: Replace this with your own logic
        int length = String.valueOf(yearofbirth).length();
        return length == 4;
    }
}
