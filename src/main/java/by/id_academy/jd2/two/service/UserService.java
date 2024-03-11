package by.id_academy.jd2.two.service;

import by.id_academy.jd2.two.dao.DaoUser;
import by.id_academy.jd2.two.dao.api.IDaoUser;
import by.id_academy.jd2.two.service.api.IUserService;
import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Objects;

public class UserService implements IUserService {
    private final IDaoUser iDaoUser = new DaoUser();
    private final Date date = new Date();

    @Override
    public void AccoutUser(UserAccount userAccount, String login, HttpServletResponse resp) throws IOException {

    //Проверяем, зарегистрирован ли пользователь с таким же логином. Если имеется, то перенаправление на другую страницу.
        if(iDaoUser.getInformation().get(login) == null){
            
    //Проверяем на роль пользователя
            if (Objects.equals(userAccount.getRole(), "user")){
     //Устанавливаем дату регистрации в поле DateRegistration объекта и сохраняем объект с ключом (логин)
                userAccount.setDateRegistration(date.toString());
                this.iDaoUser.saveUser(userAccount);
            }
        }else{
            resp.sendRedirect("userVerification.html");
        }
    }
}
