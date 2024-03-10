package by.id_academy.jd2.two.service.api;

import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface IUserService {

    void AccoutUser (UserAccount userAccount, String login, HttpServletResponse resp) throws IOException;
}
