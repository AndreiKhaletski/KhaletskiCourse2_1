package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoLayer;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.service.api.IStatisticService;

import java.util.Collection;
import java.util.List;

public class StatisticService implements IStatisticService {

    private final IDaoLayer daoLayer;

    public StatisticService(IDaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    @Override
    public int getUsers() {
        return daoLayer.getQuantityUsers();
    }

    @Override
    public int getMessages(){

        int countMessage = 0;
        Collection<List<MessageDTO>> allLists = daoLayer.getQuantityMessage();
        for (List<MessageDTO> messages : allLists) {
            for (MessageDTO message : messages) {
                countMessage++;
            }
        }
        return countMessage;
    }

    @Override
    public void monitorActive(String id) {
        daoLayer.addActive(id);
    }

    @Override
    public int getActiveUsers() {
        return daoLayer.getActive();
    }

    @Override
    public void notMonitorActive(String id) {
        daoLayer.deleteUserIsSession(id);
    }
}
