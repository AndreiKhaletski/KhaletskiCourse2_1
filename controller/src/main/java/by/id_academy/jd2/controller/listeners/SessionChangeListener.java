package by.id_academy.jd2.controller.listeners;

import by.id_academy.jd2.service.api.IStatisticService;
import by.id_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionChangeListener implements HttpSessionListener {
    private IStatisticService statisticService = ServiceFactory.getStatisticService();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        statisticService.monitorActive(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        statisticService.notMonitorActive(se.getSession().getId());
    }
}