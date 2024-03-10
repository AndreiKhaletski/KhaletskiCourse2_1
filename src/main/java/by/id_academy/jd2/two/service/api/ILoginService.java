package by.id_academy.jd2.two.service.api;

import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ILoginService {
    String loginChech(String login, String password, HttpServletResponse resp, HttpServletRequest req);
}
