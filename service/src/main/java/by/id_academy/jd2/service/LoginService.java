package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.service.api.ILoginService;
import by.id_academy.jd2.dto.UserDTO;

import java.util.Objects;

public class LoginService implements ILoginService {
    private final IDaoUser loginDao;

    public LoginService(IDaoUser loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public UserDTO loginChech(String login, String password) {

        UserDTO user = loginDao.getMapUser().get(login);
        if (user == null) {
            throw new IllegalArgumentException("Такого пользователя нет.");
        } else if (!Objects.equals(user.getPassword(), password)) {
            throw new IllegalArgumentException("Неверный пароль.");
        }
        return user;
    }
}
