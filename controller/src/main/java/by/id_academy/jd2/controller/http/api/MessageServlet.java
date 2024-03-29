package by.id_academy.jd2.controller.http.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;
import by.id_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Message", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final static String SENDER_DOPOST_PARAMETR = "recipienthtml";
    private final static String TEXT_DOPOST_PARAMETR = "texthtml";
    private final IMessageService iMessageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");

        List<MessageDTO> messages = iMessageService.messageDisplay(currentUser);

        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);

        req.setAttribute("message", messages);

        req.getRequestDispatcher("/template/user/chats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String recipient = req.getParameter(SENDER_DOPOST_PARAMETR);
        String text = req.getParameter(TEXT_DOPOST_PARAMETR);

        HttpSession session = req.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");

        if (!Objects.equals(recipient, "")) {
            if (!Objects.equals(text, "")) {
                iMessageService.recipient(new MessageDTO(recipient, text), currentUser.getLogin());
                writer.write("Ваше сообщение отправлено пользователю: " + recipient);
            } else {
                writer.write("Пустое сообщение не может быть отправлено");
            }
        } else {
            writer.write("Поле <Кому> должно быть заполнено!");
        }
    }
}
