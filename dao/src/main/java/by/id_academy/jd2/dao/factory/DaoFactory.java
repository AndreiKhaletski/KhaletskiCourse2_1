package by.id_academy.jd2.dao.factory;

import by.id_academy.jd2.dao.DaoActiveUsers;
import by.id_academy.jd2.dao.DaoUser;
import by.id_academy.jd2.dao.DaoMessages;
import by.id_academy.jd2.dao.api.IDaoActiveUsers;
import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dao.api.IDaoMessages;

public class DaoFactory {
    private volatile static IDaoUser daoLayer;
    private volatile static IDaoMessages daoMessages;
    private volatile static IDaoActiveUsers daoActiveUsers;

    public static IDaoUser getUserDao(){
        if(daoLayer == null){
            synchronized (DaoFactory.class){
                if(daoLayer == null){
                    daoLayer = new DaoUser();
                }
            }
        }
        return daoLayer;
    }

    public static IDaoMessages getMessageDao(){
        if(daoMessages == null){
            synchronized (DaoFactory.class){
                if(daoMessages == null){
                    daoMessages = new DaoMessages();
                }
            }
        }
        return daoMessages;
    }

    public static IDaoActiveUsers getActiveUsers(){
        if(daoActiveUsers == null){
            synchronized (DaoFactory.class){
                if(daoActiveUsers == null){
                    daoActiveUsers = new DaoActiveUsers();
                }
            }
        }
        return daoActiveUsers;
    }
}
