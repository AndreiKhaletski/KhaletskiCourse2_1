package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.Message;
import by.id_academy.jd2.dto.UserDTO;

public interface IMessageService {

    public void recipient(Message message, String currentUser);
    public String messageDisplay(UserDTO currentUser);
}
