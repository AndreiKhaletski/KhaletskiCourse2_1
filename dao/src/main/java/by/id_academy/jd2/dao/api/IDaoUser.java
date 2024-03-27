package by.id_academy.jd2.dao.api;

import by.id_academy.jd2.dto.MessageDTO;
import by.id_academy.jd2.dto.UserDTO;

public interface IDaoUser {

    /*
     * Метод добавляет пользоваля,
     * пойденного регистрацию в Map
     * ключ - логин
     * значение - объект пользователя
     *
     * @param userDTO
     */
    void saveUser(UserDTO userDTO);

    /*
     * Метод возвращает ключ (логин)
     * необходимого пользователя
     *
     * @param login
     * @return
     */
    UserDTO getLoginUser(String login);

    /*
     * Метод возращает количество
     * пользователей (ключей) из Map
     *
     * @return
     */
    int getQuantityUsers();

    /*
     * Метод возвращает получателя
     * сообщения из Map для передачи
     * в daoMessage
     * @param message
     * @return
     */
    UserDTO getRecipientIsAccounts(MessageDTO message);
}
