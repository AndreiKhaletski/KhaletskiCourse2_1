package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.service.api.IUserService;
import by.id_academy.jd2.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserService implements IUserService {
    private final IDaoUser userDao;

    public UserService(IDaoUser userDao) {
        this.userDao = userDao;
    }

    @Override
    public void accoutUser(UserDTO userDTO, String login) {

        if (Objects.equals(userDTO.getLogin(), "")){
            throw new IllegalArgumentException("Логин не может быть пустым");
        }
        if (Objects.equals(userDTO.getPassword(), "")){
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }

        if (userDao.getMapUser().get(login) == null) {
//            if (Objects.equals(userDTO.getRole(), "user")) {
                userDTO.setDateRegistration(String.valueOf(LocalDateTime.now()));
                this.userDao.saveUser(userDTO);
//            }else {
//                throw new IllegalArgumentException("Необходимо регистрироваться под ролью User");
//            }
        }else{
            throw new IllegalArgumentException("Пользователь с таким логином уже зарегистрирован");
        }
    }
}
