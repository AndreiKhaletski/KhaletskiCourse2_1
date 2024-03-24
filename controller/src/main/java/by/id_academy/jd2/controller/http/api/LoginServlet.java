package by.id_academy.jd2.controller.http.api;

import by.id_academy.jd2.service.api.ILoginService;
import by.id_academy.jd2.service.factory.ServiceFactory;
import by.id_academy.jd2.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "login", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private final static String LOGIN_PARAMETR = "login";
    private final static String PASSWORD_PARAMETR = "password";
    private final ILoginService iLoginService = ServiceFactory.getLoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String login = req.getParameter(LOGIN_PARAMETR);
        String password = req.getParameter(PASSWORD_PARAMETR);

        HttpSession session = req.getSession(true);
        session.setAttribute("user", iLoginService.loginChech(login, password));

        //Исправить!
//        resp.sendRedirect("userAccount.html");

        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);

        req.getRequestDispatcher("/template/user/message.jsp").forward(req, resp);
    }
}

