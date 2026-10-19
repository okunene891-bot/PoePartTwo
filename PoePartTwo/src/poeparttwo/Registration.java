/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poeparttwo;

/**
 *
 * @author Student
 */
public class Registration {
    String userName;
    String passWord;
    String cellPhoneNumber;
    String firstName;
    String lastName;

    // Ensures the username contains an underscore and is no more than 5 characters long
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Ensures the password is at least 8 characters, has a capital letter,
    // a number, and a special character
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8
                && password.matches(".*[A-Z].*") // capital letter
                && password.matches(".*\\d.*") // number
                && password.matches(".*[^a-zA-Z0-9].*"); // special character
    }

    // Regex-based SA cell number check.
    // Reference: adapted from regex pattern guidance on
    // https://www.baeldung.com/java-regex-validate-phone-numbers (Baeldung, n.d.)
    public boolean checkCellPhoneNumber(String cellphone) {
        return cellphone.matches("^\\+27[0-9]{9}$");
    }

    // Registers the user and returns messaging for every failed check found
    public String registerUser(String firstName, String lastName, String username,
            String password, String cellphone) {
        boolean usernameOk = checkUserName(username);
        boolean passwordOk = checkPasswordComplexity(password);
        boolean cellphoneOk = checkCellPhoneNumber(cellphone);

        if (!usernameOk || !passwordOk || !cellphoneOk) {
            StringBuilder message = new StringBuilder();

            if (!usernameOk) {
                message.append("Username is not correctly formatted; please ensure that your ")
                        .append("username contains an underscore and is no more than five ")
                        .append("characters in length.\n");
            }
            if (!passwordOk) {
                message.append("Password is not correctly formatted; please ensure that the ")
                        .append("password contains at least eight characters, a capital letter, ")
                        .append("a number, and a special character.\n");
            }
            if (!cellphoneOk) {
                message.append("Cell phone number incorrectly formatted or does not contain ")
                        .append("international code; please enter it in the format +27XXXXXXXXX.\n");
            }
            return message.toString().trim();
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = username;
        this.passWord = password;
        this.cellPhoneNumber = cellphone;

        return "Username successfully captured.\nPassword successfully captured."
                + "\nCell phone number successfully added.";
    }

    // Returns true only if all three fields pass validation
    public boolean registerStatus(String username, String password, String cellphone) {
        return checkUserName(username)
                && checkPasswordComplexity(password)
                && checkCellPhoneNumber(cellphone);
    }
} // end of class

