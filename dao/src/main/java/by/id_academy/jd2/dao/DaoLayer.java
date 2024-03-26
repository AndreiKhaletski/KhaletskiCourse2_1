package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoLayer;
import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.Role;
import by.id_academy.jd2.dto.UserDTO;

import java.util.*;

public class DaoLayer implements IDaoLayer {
    private static final Map<String, UserDTO> accounts = new HashMap<>();
    private static final Map<String, List<MessageDTO>> messages = new HashMap<>();
    private static final List<String> idActiveUsers = new ArrayList<>();

    public DaoLayer() {
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
    public UserDTO getRecipient(MessageDTO message) {
        return accounts.get(message.getRecipient());
    }

    @Override
    public void saveMessage(MessageDTO message) {
        messages.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    @Override
    public int getQuantityUsers() {
        return accounts.size();
    }

    @Override
    public List<MessageDTO> getMessageUsers(UserDTO currentUser) {
        return messages.get(currentUser.getLogin());
    }

    @Override
    public Collection<List<MessageDTO>> getQuantityMessage() {
        return messages.values();
    }

    @Override
    public void addActive(String id) {
        idActiveUsers.add(id);
    }

    @Override
    public int getActive() {
        return idActiveUsers.size();
    }

    @Override
    public void deleteUserIsSession(String id) {
        idActiveUsers.remove(id);

    }
}
