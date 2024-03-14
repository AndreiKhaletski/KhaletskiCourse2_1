package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserDTO> mapAccounts = new HashMap<>();
    private static final Map<String, MessageDTO> mapMessages = new HashMap<>();
//    private static final Map<String, List<Message>> mapMessagesTest = new HashMap<>();

    public DaoUser() {
        mapAccounts.put("admin", (new UserDTO(
                "admin",
                "admin",
                "Админ Админович",
                "01.01.1985",
                "admin"
        )));
        mapAccounts.put("andy", (new UserDTO(
                "adny",
                "andy",
                "Халецкий Андрей Михайлович",
                "21.08.1995",
                "user"
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
    public void saveMessage(MessageDTO message) {
        mapMessages.put(message.getRecipient(), message);
    }

    @Override
    public Map<String, MessageDTO> getMapMessage() {
        return mapMessages;
    }

}
