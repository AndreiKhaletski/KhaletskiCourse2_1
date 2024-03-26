package by.id_academy.jd2.dao.factory;

import by.id_academy.jd2.dao.DaoLayer;
import by.id_academy.jd2.dao.api.IDaoLayer;

public class DaoFactory {
    private volatile static IDaoLayer iDaoLayer;

    public static IDaoLayer getUserDao(){
        if(iDaoLayer == null){
            synchronized (DaoFactory.class){
                if(iDaoLayer == null){
                    iDaoLayer = new DaoLayer();
                }
            }
        }
        return iDaoLayer;
    }
}
