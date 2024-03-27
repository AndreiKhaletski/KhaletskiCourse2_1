package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.Role;
import by.id_academy.jd2.dto.UserDTO;

import java.util.*;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserDTO> accounts = new HashMap<>();

    public DaoUser() {
        accounts.put("admin", (new UserDTO(
                "admin",
                "admin",
                "Админ Админович",
                "01.01.1985",
                Role.ADMIN
        )));
        accounts.put("andy", (new UserDTO(
                "adny",
                "andy",
                "Халецкий Андрей Михайлович",
                "21.08.1995",
                Role.USER
        )));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        accounts.put(userDTO.getLogin(), userDTO);
    }

    @Override
    public UserDTO getLoginUser(String login) {
        return accounts.get(login);
    }

    @Override
    public int getQuantityUsers() {
        return accounts.size();
    }

    @Override
    public UserDTO getRecipientIsAccounts(MessageDTO message){
        return accounts.get(message.getRecipient());
    }
}
