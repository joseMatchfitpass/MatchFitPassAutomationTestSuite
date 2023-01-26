package Data;

import Pages.Enums.Genders;

import static Pages.Enums.Genders.MR;

public class LogIn {

    String userName;
    String password;

    public LogIn(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LogIn() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
