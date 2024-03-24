package by.id_academy.jd2.controller.listeners;

import by.id_academy.jd2.controller.listeners.api.ISessionChangeListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionChangeListener implements HttpSessionListener, ISessionChangeListener {

    private static int countActiveUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        countActiveUsers++;

//            String sessionId = se.getSession().getId();
//            activeUsers.add(sessionId);
//            System.out.println("Пользователь с сессией " + sessionId + " вошел в систему.");
//            se.getSession().setAttribute("activeUserCount", getActiveUserCount());
    }

    @Override
    public int getCount() {
        return countActiveUsers;
    }
}