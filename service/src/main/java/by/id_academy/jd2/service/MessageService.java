package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoMessages;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService implements IMessageService {
    private final IDaoMessages daoMessages;

    public MessageService(IDaoMessages daoMessages) {
        this.daoMessages = daoMessages;
    }

    @Override
    public void recipient(MessageDTO message, String currentUser) {

        if (daoMessages.getRecipient(message) != null) {
            message.setSender(currentUser);
            message.setSendingDataTime(String.valueOf(LocalDateTime.now()));
            daoMessages.saveMessage(message);
        } else {
            throw new IllegalArgumentException("Такого пользователя нет!");
        }
    }

    @Override
    public List<MessageDTO> messageDisplay(UserDTO currentUser) {
        return daoMessages.getMessageUsers(currentUser);
    }
}
