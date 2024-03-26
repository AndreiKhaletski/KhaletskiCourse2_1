package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoLayer;
import by.id_academy.jd2.service.api.IUserService;
import by.id_academy.jd2.dto.UserDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserService implements IUserService {
    private final IDaoLayer daoLayer;

    public UserService(IDaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    @Override
    public void accoutUser(UserDTO userDTO, String login) {

        if (Objects.equals(userDTO.getLogin(), "")){
            throw new IllegalArgumentException("Логин не может быть пустым");
        }
        if (Objects.equals(userDTO.getPassword(), "")){
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }
        if (daoLayer.getLoginUser(login) != null) {
            throw new IllegalArgumentException("Пользователь с таким логином уже зарегистрирован");
        }

        this.daoLayer.saveUser(userDTO);
    }
}
