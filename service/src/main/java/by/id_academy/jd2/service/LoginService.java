package by.id_academy.jd2.service;

import by.id_academy.jd2.dao.api.IDaoUser;
import by.id_academy.jd2.service.api.ILoginService;
import by.id_academy.jd2.dto.UserDTO;

public class LoginService implements ILoginService {
    private final IDaoUser loginDao;

    public LoginService(IDaoUser loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public UserDTO loginChech(String login) {

        if (loginDao.getMapUser().get(login) == null){
            throw new IllegalArgumentException("Такого пользователя нет.");
        }else{
            return loginDao.getMapUser().get(login);
        }
    }
}
