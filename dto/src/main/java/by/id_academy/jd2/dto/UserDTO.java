package by.id_academy.jd2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String login;
    private String password;
    private String fullname;
    private String date;
    private String dateRegistration;
    private String role;

    public UserDTO(String login, String password, String fullname, String date, String role) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.date = date;
        this.role = role;
    }
}
