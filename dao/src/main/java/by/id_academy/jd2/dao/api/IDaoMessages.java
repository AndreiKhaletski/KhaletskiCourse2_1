package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public interface IDaoMessages {

    UserDTO getRecipient(MessageDTO message);
    void saveMessage(MessageDTO message);
    public List<MessageDTO> getMessageUsers(UserDTO currentUser);
    public Collection<List<MessageDTO>> getQuantityMessage();
}
