package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.UserDTO;

import java.util.Map;

public interface IDaoUser {
    void saveUser(UserDTO userDTO);
    UserDTO getLoginUser(String login);
    int getQuantityUsers();
    Map<String, UserDTO> accounts();
}
