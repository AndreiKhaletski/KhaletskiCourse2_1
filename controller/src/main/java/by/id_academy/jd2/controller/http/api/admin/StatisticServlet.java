package by.id_academy.jd2.controller.http.api.admin;

import by.id_academy.jd2.controller.listeners.SessionChangeListener;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.service.StatisticService;
import by.id_academy.jd2.service.api.IStatisticService;
import by.id_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "statistics", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {
    private IStatisticService statisticService = ServiceFactory.getStatisticService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int activeUsers = statisticService.getActiveUsers();
        int quantityUsers = statisticService.getUsers();
        int quantityMessages = statisticService.getMessages();

        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);
        req.setAttribute("activeUsers", activeUsers);
        req.setAttribute("quantityUsers", quantityUsers);
        req.setAttribute("quantityMessages", quantityMessages);

        req.getRequestDispatcher("/template/admin/statistics.jsp").forward(req, resp);
    }
}
