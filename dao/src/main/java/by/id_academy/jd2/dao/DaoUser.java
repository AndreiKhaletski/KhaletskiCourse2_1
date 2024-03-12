package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserDTO> information = new HashMap<>();
    public DaoUser(){
        information.put("admin",(new UserDTO(
                "admin",
                "admin",
                "Админ Админович",
                "01.01.1985",
                "admin"
        )));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        information.put(userDTO.getLogin(), userDTO);
    }

    @Override
    public Map<String, UserDTO> getMap() {
        return information;
    }
}
