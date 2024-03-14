package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface IDaoUser {
    void saveUser(UserDTO userDTO);
    Map<String, UserDTO> getMapUser();

    void saveMessage(MessageDTO message);
    Map<String, List<MessageDTO>> getMapMessage();
}
