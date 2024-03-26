package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoLayer;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService implements IMessageService {

    private final IDaoLayer daoLayer;

    public MessageService(IDaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    @Override
    public void recipient(MessageDTO message, String currentUser) {

        if (daoLayer.getRecipient(message) != null) {
            message.setSender(currentUser);
            message.setSendingDataTime(String.valueOf(LocalDateTime.now()));
            daoLayer.saveMessage(message);
        } else {
            throw new IllegalArgumentException("Такого пользователя нет!");
        }
    }

    @Override
    public List<MessageDTO> messageDisplay(UserDTO currentUser) {
        return daoLayer.getMessageUsers(currentUser);
    }
}
