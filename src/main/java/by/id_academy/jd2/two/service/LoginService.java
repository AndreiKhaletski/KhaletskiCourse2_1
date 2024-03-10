package by.id_academy.jd2.two.service;

import by.id_academy.jd2.two.dao.DaoUser;
import by.id_academy.jd2.two.dao.api.IDaoUser;
import by.id_academy.jd2.two.service.api.ILoginService;
import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

public class LoginService implements ILoginService {
    private final IDaoUser iDaoUser = new DaoUser();
    @Override
    public String loginChech(String login, String password, HttpServletResponse resp, HttpServletRequest req) {

        StringBuilder builder = new StringBuilder();

        UserAccount user = iDaoUser.getInformation().get(login);

        if (user != null) {
            if (Objects.equals(user.getPassword(), password)) {

                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);

                builder.append("<p>Вы вошли под своим логином и паролем</p>");
                builder.append("<p>Ваш логин: ").append(user.getLogin()).append("</p>");
                builder.append("<p>Ваш пароль: ").append(user.getPassword()).append("</p>");
                builder.append("<p>Ваше полное ФИО: ").append(user.getFullname()).append("</p>");
                builder.append("<p>Дата вашего рождения: ").append(user.getDate()).append("</p>");
                builder.append("<p>Дата регистрации: ").append(user.getDateRegistration()).append("</p>");
                builder.append("<p>Ваша роль в системе: ").append(user.getRole()).append("</p>");
            } else {
                builder.append("<p>Вы ввели неверный пароль...");
            }
        } else {
            try {
                resp.sendRedirect("registrationError.html");
            } catch (IOException e) {
                return "Ошибка перенаправления пользователя на страницу.";
            }
        }
        return builder.toString();
    }
}