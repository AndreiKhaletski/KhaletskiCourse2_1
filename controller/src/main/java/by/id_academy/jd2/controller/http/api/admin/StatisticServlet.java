package by.id_academy.jd2.controller.http.api.admin;

import by.id_academy.jd2.controller.listeners.SessionChangeListener;
import by.id_academy.jd2.controller.listeners.api.ISessionChangeListener;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.service.StatisticService;
import by.id_academy.jd2.service.api.IStatisticService;
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
    ISessionChangeListener sessionChangeListener = new SessionChangeListener();
    IStatisticService statisticService = new StatisticService();
    private int countMessage = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        PrintWriter writer = resp.getWriter();

        String activeUsers = String.valueOf(sessionChangeListener.getCount());
        String quantityUsers = String.valueOf(statisticService.getUsers());

        Collection<List<MessageDTO>> allLists = statisticService.getMessages();
        for (List<MessageDTO> messages : allLists) {
            for (MessageDTO message : messages) {
                countMessage++;
            }
        }

        String quantityMessages = String.valueOf(countMessage);
//        writer.write("<p>" + "Количество активных пользователей: " + activeUsers + "</p>");
//        writer.write("<p>" + "Количество пользователей в приложении: " + quantityUsers + "</p>");
//        writer.write("Количество сообщений отправленных в приложении: " + quantityMessages);

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
