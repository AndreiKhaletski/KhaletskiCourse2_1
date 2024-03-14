package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.List;

public interface IMessageService {

    public void recipient(MessageDTO message, String currentUser);
    public List<String> messageDisplay(UserDTO currentUser);
}
