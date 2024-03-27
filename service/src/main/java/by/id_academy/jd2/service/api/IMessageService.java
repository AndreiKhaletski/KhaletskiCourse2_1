package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.List;

public interface IMessageService {

    /*
     * Метод проверяет проверяет
     * зарегистрирован ли принимающий
     * сообщение пользователь
     *
     * @param message
     * @param currentUser
     */
    public void recipient(MessageDTO message, String currentUser);

    /*
     * Метод возвращает лист сообщений
     * для текущего пользователя
     *
     * @param currentUser
     * @return
     */
    public List<MessageDTO> messageDisplay(UserDTO currentUser);
}
