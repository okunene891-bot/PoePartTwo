/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poeparttwo;

/**
 *
 * @author Student
 */
public class Login extends Registration {
    // Verifies that the entered username and password match what was registered
    public boolean loginUser(String username, String password) {

        return username.equals(userName) && password.equals(passWord);
    }

    // Returns the appropriate login status message
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {

            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";

        }
    }
}


