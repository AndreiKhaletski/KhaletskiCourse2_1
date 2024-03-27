package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.UserDTO;

public interface ILoginService {

    /*
     * @param login
     * @param password
     * @return
     * Метод проверяет на существующего
     * пользователя и на неправильный
     * ввод пароля
     */
    UserDTO loginChech(String login, String password);
}
