package by.id_academy.jd2.service.factory;

import by.id_academy.jd2.dao.factory.DaoFactory;
import by.id_academy.jd2.service.LoginService;
import by.id_academy.jd2.service.MessageService;
import by.id_academy.jd2.service.StatisticService;
import by.id_academy.jd2.service.UserService;
import by.id_academy.jd2.service.api.*;

public class ServiceFactory {
    private volatile static ILoginService loginService;
    private volatile static IUserService userService;
    private volatile static IMessageService messageService;
    private volatile static IStatisticService statisticService;

    public static IMessageService getMessageService(){
        if(messageService == null){
            synchronized (ServiceFactory.class){
                if(messageService == null){
                    messageService = new MessageService(DaoFactory.getUserDao());
                }
            }
        }
        return messageService;
    }

    public static ILoginService getLoginService(){
        if(loginService == null){
            synchronized (ServiceFactory.class){
                if(loginService == null){
                    loginService = new LoginService(DaoFactory.getUserDao());
                }
            }
        }
        return loginService;
    }

    public static IUserService getUserService(){
        if(userService == null){
            synchronized (ServiceFactory.class){
                if(userService == null){
                    userService = new UserService(DaoFactory.getUserDao());
                }
            }
        }
        return userService;
    }
    public static IStatisticService getStatisticService(){
        if(statisticService == null){
            synchronized (ServiceFactory.class){
                if(statisticService == null){
                    statisticService = new StatisticService(DaoFactory.getUserDao());
                }
            }
        }
        return statisticService;
    }
}
