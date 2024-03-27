package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.UserDTO;

import java.io.IOException;

public interface IUserService {

    /*
     * Метод проверяет на заполнение
     * логина и пароля, а также
     * на существующего пользователя
     *
     * @param userDTO
     * @param login
     * @throws IOException
     */
    void accoutUser (UserDTO userDTO, String login) throws IOException;
}
