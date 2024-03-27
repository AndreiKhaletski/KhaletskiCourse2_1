package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

public interface IDaoUser {
    void saveUser(UserDTO userDTO);
    UserDTO getLoginUser(String login);
    int getQuantityUsers();
    UserDTO getRecipientIsAccounts(MessageDTO message);
}
