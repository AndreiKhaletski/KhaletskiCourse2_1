package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.Message;
import by.id_academy.jd2.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserDTO> mapAccounts = new HashMap<>();
    private static final Map<String, Message> mapMessages = new HashMap<>();

    public DaoUser(){
        mapAccounts.put("admin",(new UserDTO(
                "admin",
                "admin",
                "Админ Админович",
                "01.01.1985",
                "admin"
        )));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        mapAccounts.put(userDTO.getLogin(), userDTO);
    }

    @Override
    public Map<String, UserDTO> getMapUser() {
        return mapAccounts;
    }


    @Override
    public void saveMessage(Message message) {
        mapMessages.put(message.getRecipient(), message);
    }

    @Override
    public Map<String, Message> getMapMessage() {
        return mapMessages;
    }

}
