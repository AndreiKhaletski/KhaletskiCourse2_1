package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MessageService implements IMessageService {

    private final IDaoUser userDao;

    public MessageService(IDaoUser userDao) {
        this.userDao = userDao;
    }

    @Override
    public void recipient(MessageDTO message, String currentUser) {

        if (userDao.getMapUser().get(message.getRecipient()) != null){
            message.setSender(currentUser);
            message.setSendingDataTime(String.valueOf(LocalDateTime.now()));
            userDao.saveMessage(message);
        }else{
            throw new IllegalArgumentException("Такого пользователя нет!");
        }
    }

    @Override
    public List<String> messageDisplay(UserDTO currentUser) {

        List<String> listCommentsAndAddresses = new ArrayList<>();

        String sender;
        String text;

        for (Map.Entry<String, MessageDTO> entry : userDao.getMapMessage().entrySet()) {
            String key = entry.getKey();
            sender = userDao
                    .getMapMessage()
                    .get(currentUser.getLogin())
                    .getSender();
            text = userDao
                    .getMapMessage()
                    .get(currentUser.getLogin())
                    .getText();
            if (Objects.equals(key, currentUser.getLogin())){
                listCommentsAndAddresses.add("Сообщение от: " + sender + " | Текст: " + text);
            }else{
                throw new IllegalArgumentException("Сообщений нет");
            }
        }

//        for (Message message : userDao.getMapMessage().values()) {
//            list.add("От: " + message.getSender() + ", Текст: " + message.getText());
//        }

        return listCommentsAndAddresses;
    }
}
