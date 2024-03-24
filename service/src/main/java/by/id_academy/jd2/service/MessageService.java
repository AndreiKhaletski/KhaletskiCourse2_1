package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private final IDaoUser userDao;

    public MessageService(IDaoUser userDao) {
        this.userDao = userDao;
    }

    @Override
    public void recipient(MessageDTO message, String currentUser) {

        if (userDao.getMapUser().get(message.getRecipient()) != null) {
            message.setSender(currentUser);
            message.setSendingDataTime(String.valueOf(LocalDateTime.now()));
            userDao.saveMessage(message);
        } else {
            throw new IllegalArgumentException("Такого пользователя нет!");
        }
    }

    @Override
    public List<MessageDTO> messageDisplay(UserDTO currentUser) {
        return userDao.getMapMessage(currentUser);
    }
}
