package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public interface IDaoLayer {
    void saveUser(UserDTO userDTO);
    UserDTO getLoginUser(String login);
    UserDTO getRecipient(MessageDTO message);

    void saveMessage(MessageDTO message);

    int getQuantityUsers();
    public List<MessageDTO> getMessageUsers(UserDTO currentUser);
    public Collection<List<MessageDTO>> getQuantityMessage();

    public void addActive(String id);

    public int getActive();

    public void deleteUserIsSession(String id);
}
