package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.DaoUser;
import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.Message;
import by.id_academy.jd2.dto.UserDTO;
import by.id_academy.jd2.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class MessageService implements IMessageService {

    private final IDaoUser userDao;

    public MessageService(IDaoUser userDao) {
        this.userDao = userDao;
    }

    @Override
    public void recipient(Message message, String currentUser) {

        if (userDao.getMapUser().get(message.getRecipient()) != null){
            message.setSender(currentUser);
            message.setSendingDataTime(String.valueOf(LocalDateTime.now()));
            userDao.saveMessage(message);
        }else{
            throw new IllegalArgumentException("Такого пользователя нет!");
        }
    }

    @Override
    public String messageDisplay(UserDTO currentUser) {

        StringBuilder builder = new StringBuilder();

        Map<String, Message> map = userDao.getMapMessage();

        String sender = userDao
                .getMapMessage()
                .get(currentUser.getLogin())
                .getSender();

        String text = userDao
                .getMapMessage()
                .get(currentUser.getLogin())
                .getText();

        for (Map.Entry<String, Message> entry : map.entrySet()) {
            String key = entry.getKey();
            if (Objects.equals(key, currentUser.getLogin())){
                builder.append("Сообщение от: ").append(sender).append(" | Текст: ").append(text);
//                messages.add("Сообщение от: " + sender + " | Текст: " + text);
            }else{
                throw new IllegalArgumentException("Сообщений нет");
            }
        }

//       userDao.getMapMessage().get(currentUser.getLogin());


        return builder.toString();
    }
}
