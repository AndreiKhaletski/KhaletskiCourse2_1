package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public interface IDaoMessages {

    /*
     * Метод возвращает отправителя
     * сообщения для текущего
     * пользователя
     *
     * @param message
     * @return
     */

    UserDTO getRecipient(MessageDTO message);

    /*
     * Метод добавляет в Map
     * сообщение (значение) для указанного
     * пользователя (ключ)
     * @param message
     */
    void saveMessage(MessageDTO message);

    /*
     * Метод возвращает лист
     * сообщений по ключу (логин)
     * текущего пользователя
     *
     * @param currentUser
     * @return
     */
    public List<MessageDTO> getMessageUsers(UserDTO currentUser);

    /*
     * Метод возвращает количество
     * всех отправленных сообщений
     * для статистики
     * @return
     */
    public Collection<List<MessageDTO>> getQuantityMessage();
}
