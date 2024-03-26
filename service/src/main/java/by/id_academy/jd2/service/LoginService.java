package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoLayer;
import by.id_academy.jd2.service.api.ILoginService;
import by.id_academy.jd2.dto.UserDTO;

import java.util.Objects;

public class LoginService implements ILoginService {
    private final IDaoLayer daoLayer;

    public LoginService(IDaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    @Override
    public UserDTO loginChech(String login, String password) {

        UserDTO user = daoLayer.getLoginUser(login);
        if (user == null) {
            throw new IllegalArgumentException("Такого пользователя нет.");
        } else if (!Objects.equals(user.getPassword(), password)) {
            throw new IllegalArgumentException("Неверный пароль.");
        }
        return user;
    }
}
