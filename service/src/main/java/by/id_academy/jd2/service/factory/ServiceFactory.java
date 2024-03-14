package by.id_academy.jd2.service.factory;

import by.id_academy.jd2.dao.factory.DaoFactory;
import by.id_academy.jd2.service.LoginService;
import by.id_academy.jd2.service.MessageService;
import by.id_academy.jd2.service.UserService;
import by.id_academy.jd2.service.api.ILoginService;
import by.id_academy.jd2.service.api.IMessageService;
import by.id_academy.jd2.service.api.IUserService;

public class ServiceFactory {
    private volatile static ILoginService iLoginService;
    private volatile static IUserService iUserService;
    private volatile static IMessageService iMessageService;

    public static IMessageService getMessageService(){
        if(iMessageService == null){
            synchronized (ServiceFactory.class){
                if(iMessageService == null){
                    iMessageService = new MessageService(DaoFactory.getUserDao());
                }
            }
        }
        return iMessageService;
    }

    public static ILoginService getLoginService(){
        if(iLoginService == null){
            synchronized (ServiceFactory.class){
                if(iLoginService == null){
                    iLoginService = new LoginService(DaoFactory.getUserDao());
                }
            }
        }
        return iLoginService;
    }

    public static IUserService getUserService(){
        if(iUserService == null){
            synchronized (ServiceFactory.class){
                if(iUserService == null){
                    iUserService = new UserService(DaoFactory.getUserDao());
                }
            }
        }
        return iUserService;
    }
}
