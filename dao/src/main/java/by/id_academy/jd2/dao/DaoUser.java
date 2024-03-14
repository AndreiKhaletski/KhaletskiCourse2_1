package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserDTO> mapAccounts = new HashMap<>();
    private static final Map<String, List<MessageDTO>> mapMessages = new HashMap<>();
//    private static final Map<String, MessageDTO> mapMessages = new HashMap<>();

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
        mapMessages.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    @Override
    public Map<String, List<MessageDTO>> getMapMessage() {
        return mapMessages;
    }
}
