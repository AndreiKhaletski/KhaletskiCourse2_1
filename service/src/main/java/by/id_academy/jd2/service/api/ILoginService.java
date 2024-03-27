package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.UserDTO;

public interface ILoginService {

    /*
     * Метод проверяет на существующего
     * пользователя и на неправильный
     * ввод пароля
     *
     * @param login
     * @param password
     * @return
     */
    UserDTO loginChech(String login, String password);
}
