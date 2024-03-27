package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dao.api.IDaoMessages;
import by.id_academy.jd2.dao.factory.DaoFactory;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.*;

public class DaoMessages implements IDaoMessages {
    IDaoUser userDao = DaoFactory.getUserDao();
    private static final Map<String, List<MessageDTO>> messages = new HashMap<>();

    @Override
    public UserDTO getRecipient(MessageDTO message) {
        return userDao.accounts().get(message.getRecipient());
    }

    @Override
    public void saveMessage(MessageDTO message) {
        messages.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    @Override
    public List<MessageDTO> getMessageUsers(UserDTO currentUser) {
        return messages.get(currentUser.getLogin());
    }

    @Override
    public Collection<List<MessageDTO>> getQuantityMessage() {
        return messages.values();
    }
}
