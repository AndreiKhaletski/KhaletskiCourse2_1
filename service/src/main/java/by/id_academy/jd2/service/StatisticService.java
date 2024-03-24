package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.DaoUser;
import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.service.api.IStatisticService;

import java.util.Collection;
import java.util.List;

public class StatisticService implements IStatisticService {

    IDaoUser userDao = new DaoUser();

    @Override
    public int getUsers() {
        return userDao.getQuantityUsers();
    }

    @Override
    public Collection<List<MessageDTO>> getMessages(){
        return userDao.getQuantityMessage();
    }
}
