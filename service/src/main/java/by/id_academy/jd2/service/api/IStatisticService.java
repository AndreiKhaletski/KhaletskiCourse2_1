package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.MessageDTO;

import java.util.Collection;
import java.util.List;

public interface IStatisticService {
    public int getUsers();

    Collection<List<MessageDTO>> getMessages();
}
