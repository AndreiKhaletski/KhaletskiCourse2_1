package by.id_academy.jd2.two.controller.api;

import by.id_academy.jd2.two.service.LoginService;
import by.id_academy.jd2.two.service.api.ILoginService;
import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final static String LOGIN_PARAMETR = "login";
    private final static String PASSWORD_PARAMETR = "password";
    private final ILoginService iLoginService = new LoginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String login = req.getParameter(LOGIN_PARAMETR);
        String password = req.getParameter(PASSWORD_PARAMETR);

        writer.write(iLoginService.loginChech(login, password, resp, req));


        // Проверка учетных данных пользователя
        // (в базе данных создать метод проверки? Тогда вызываем не метод iLoginService)
//        UserAccount userAccount = iLoginService.loginChech(login, password);

//        if (iLoginService.loginChech(login, password, resp) != null) {
//            // Если учетные данные верны, сохраняем информацию о пользователе в сессию
//            HttpSession session = req.getSession(true);
//            session.setAttribute("user", iLoginService.loginChech(login, password, resp));
////            // Отправляем ответ, что вход выполнен успешно
////            writer.write("Вход выполнен успешно.");
////        }else {
////            // Если учетные данные неверны, отправляем ошибку
////             writer.write("Неверный логин или пароль.");
//        }
    }
}