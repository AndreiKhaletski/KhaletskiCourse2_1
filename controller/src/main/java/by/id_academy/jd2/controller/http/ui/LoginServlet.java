package by.id_academy.jd2.controller.http.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ui/signLogin")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);
        req.getRequestDispatcher("/template/signLogin.jsp").forward(req, resp);
    }
}
