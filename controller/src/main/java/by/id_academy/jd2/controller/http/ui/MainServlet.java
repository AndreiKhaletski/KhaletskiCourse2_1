package by.id_academy.jd2.controller.http.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ui")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);

        req.getRequestDispatcher("/template/index.jsp").forward(req, resp);
    }
}
