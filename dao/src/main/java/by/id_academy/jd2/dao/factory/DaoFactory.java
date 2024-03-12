package by.id_academy.jd2.dao.factory;

import by.id_academy.jd2.dao.DaoUser;
import by.id_academy.jd2.dao.api.IDaoUser;

public class DaoFactory {
    private volatile static IDaoUser iDaoUser;

    public static IDaoUser getUserDao(){
        if(iDaoUser == null){
            synchronized (DaoFactory.class){
                if(iDaoUser == null){
                    iDaoUser = new DaoUser();
                }
            }
        }
        return iDaoUser;
    }
}
