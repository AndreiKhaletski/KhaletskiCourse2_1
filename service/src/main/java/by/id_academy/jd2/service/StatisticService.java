package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoActiveUsers;
import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dao.api.IDaoMessages;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.service.api.IStatisticService;

import java.util.Collection;
import java.util.List;

public class StatisticService implements IStatisticService {

    private IDaoMessages daoMessages;
    private IDaoUser daoUser;
    private IDaoActiveUsers daoActiveUsers;

    public StatisticService(IDaoMessages daoMessages, IDaoUser daoUser, IDaoActiveUsers daoActiveUsers) {
        this.daoMessages = daoMessages;
        this.daoUser = daoUser;
        this.daoActiveUsers = daoActiveUsers;
    }

    @Override
    public int getUsers() {
        return daoUser.getQuantityUsers();
    }

    @Override
    public int getMessages(){

        int countMessage = 0;
        Collection<List<MessageDTO>> allLists = daoMessages.getQuantityMessage();
        for (List<MessageDTO> messages : allLists) {
            for (MessageDTO message : messages) {
                countMessage++;
            }
        }
        return countMessage;
    }

    @Override
    public void monitorActive(String id) {
        daoActiveUsers.addActive(id);
    }

    @Override
    public int getActiveUsers() {
        return daoActiveUsers.getActive();
    }

    @Override
    public void notMonitorActive(String id) {
        daoActiveUsers.deleteUserIsSession(id);
    }
}
