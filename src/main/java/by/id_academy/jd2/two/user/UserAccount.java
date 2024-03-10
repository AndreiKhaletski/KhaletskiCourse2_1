package by.id_academy.jd2.two.user;

public class UserAccount {
    private String login;
    private String password;
    private String fullname;
    private String date;
    private String dateRegistration;
    private String role;

    public UserAccount(String login, String password, String fullname, String date, String role) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.date = date;
//        this.dateRegistration = dateRegistration;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
