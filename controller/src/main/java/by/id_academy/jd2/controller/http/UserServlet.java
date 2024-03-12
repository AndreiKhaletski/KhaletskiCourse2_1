package by.id_academy.jd2.controller.http;

import by.id_academy.jd2.service.api.IUserService;
import by.id_academy.jd2.service.factory.ServiceFactory;
import by.id_academy.jd2.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "User", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private final static String LOGIN_USER_PARAMETR = "login";
    private final static String PASSWORD_USER_PARAMETR = "password";
    private final static String FULL_NAME_USER_PARAMETR = "fullName";
    private final static String DATA_NAME_USER_PARAMETR = "date";
    private final static String ROLE_NAME_USER_PARAMETR = "role";

    private final IUserService iUserService = ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String login = req.getParameter(LOGIN_USER_PARAMETR);
        String password = req.getParameter(PASSWORD_USER_PARAMETR);
        String fullName = Arrays.toString(req.getParameterValues(FULL_NAME_USER_PARAMETR));
        String date = Arrays.toString(req.getParameterValues(DATA_NAME_USER_PARAMETR));
        String role = req.getParameter(ROLE_NAME_USER_PARAMETR);

            iUserService.accoutUser(new UserDTO(login, password, fullName, date, role), login);
            writer.write("Вы успешно зарегистрировались!");
    }
}
