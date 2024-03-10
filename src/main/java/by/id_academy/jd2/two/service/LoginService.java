package by.id_academy.jd2.two.service;

import by.id_academy.jd2.two.dao.DaoUser;
import by.id_academy.jd2.two.dao.api.IDaoUser;
import by.id_academy.jd2.two.service.api.ILoginService;
import by.id_academy.jd2.two.user.UserAccount;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

public class LoginService implements ILoginService {
    private final IDaoUser iDaoUser = new DaoUser();
    @Override
    public String loginChech(String login, String password, HttpServletResponse resp, HttpServletRequest req) {

        StringBuilder builder = new StringBuilder();

        UserAccount user = iDaoUser.getInformation().get(login);

        if (user != null) {
            if (Objects.equals(user.getPassword(), password)) {

                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);

                builder.append("<p>Вы вошли под своим логином и паролем</p>");
                builder.append("<p>Ваш логин: ").append(user.getLogin()).append("</p>");
                builder.append("<p>Ваш пароль: ").append(user.getPassword()).append("</p>");
                builder.append("<p>Ваше полное ФИО: ").append(user.getFullname()).append("</p>");
                builder.append("<p>Дата вашего рождения: ").append(user.getDate()).append("</p>");
                builder.append("<p>Дата регистрации: ").append(user.getDateRegistration()).append("</p>");
                builder.append("<p>Ваша роль в системе: ").append(user.getRole()).append("</p>");
            } else {
                builder.append("<p>Вы ввели неверный пароль...");
            }
        } else {
            try {
                resp.sendRedirect("registrationError.html");
            } catch (IOException e) {
                return "Ошибка перенаправления пользователя на страницу.";
            }
        }
        return builder.toString();
    }
}

//======================================================================
//    @Override
//    public UserAccount loginChech(String login, String password) {
//
//        UserAccount userCheck = iDaoUser.getInformation().get(login);
//
//        if (userCheck != null && userCheck.getPassword().equals(password)) {
//            return userCheck;
//        }
//        return userCheck;
//    }
//}

//======================================================================
//    @Override
//    public String loginChech(String login, String password, HttpServletResponse resp) {
//
////        Map<String, UserAccount> mapInformation = iDaoUser.getInformation();
//
//        StringBuilder builder = new StringBuilder();
//
//        UserAccount userCheck = iDaoUser.getInformation().get(login);
//
//        if (userCheck != null) {
//            if (Objects.equals(userCheck.getPassword(), password)) {
//                builder.append("<p>Вы вошли под своим логином и паролем</p>");
//                builder.append("<p>Ваш логин: ").append(userCheck.getLogin()).append("</p>");
//                builder.append("<p>Ваш пароль: ").append(userCheck.getPassword()).append("</p>");
//                builder.append("<p>Ваше полное ФИО: ").append(userCheck.getFullname()).append("</p>");
//                builder.append("<p>Дата вашего рождения: ").append(userCheck.getDate()).append("</p>");
//                builder.append("<p>Дата регистрации: ").append(userCheck.getDateRegistration()).append("</p>");
//                builder.append("<p>Ваша роль в системе: ").append(userCheck.getRole()).append("</p>");
//            } else {
//                builder.append("<p>Вы ввели неверный пароль...");
//            }
//        }else{
//            try {
//                resp.sendRedirect("registrationError.html");
//            } catch (IOException e) {
//                return "Ошибка перенаправления пользователя на страницу.";
//            }
//        }
//        return builder.toString();
//    }
//}

//-----------------------------------------------------------------------------
//        Map<String, UserAccount> mapInformation = iDaoUser.getInformation();
//
//        StringBuilder builder = new StringBuilder();
//
//        UserAccount userCheck = iDaoUser.getInformation().get(login);
//
//        for (int i = 0; i < mapInformation.size(); i++) {
//            mapInformation.get(i);
//
//            if (userCheck.getLogin() == login && userCheck.getPassword() == password) {
//                builder.append(userCheck.getLogin());
//                builder.append(userCheck.getPassword());
//                builder.append(userCheck.getFullname());
//            }
//        }
//        return builder.toString();
//    }
//--------------------------------------------------------


//        StringBuilder builder = new StringBuilder();
//
//        Map<String, UserAccount> mapUser = iDaoUser.getInformation();
//
////        UserAccount userCheck = iDaoUser.getInformation().get("admin");
//
//        for (int i = 0; i < mapUser.size(); i++) {
//            if (mapUser.get(i).getLogin() == login) {
//
//                builder.append(mapUser.get(i).getLogin());
//                builder.append(mapUser.get(i).getPassword());
//                builder.append(mapUser.get(i).getFullname());
//
//            }
//        }
//----------------------------------------------------
//    @Override
//    public String ViewLogin() {
//
//        StringBuilder builder = loginChech()
//
//        return builder.toString();
//    }

//---------------------------------------------------
//        UserAccount userCheck;
//
//        StringBuilder builder = new StringBuilder();
//
//        Map<Object, UserAccount> mapUser = iDaoUser.getInformation();
//
//        for (int i = 0; i < mapUser.size(); i++) {
//            userCheck = iDaoUser.getInformation().get(i);
//            if (mapUser.get(i).getLogin() == login && mapUser.get(i).getPassword() == password){
//                builder.append(userCheck.getLogin());
//                builder.append(userCheck.getPassword());
//                builder.append(userCheck.getFullname());
////                builder.append(userCheck.getDate());
//                builder.append(userCheck.getRole());
////                builder.append(userCheck.getDateRegistration());
//            }
//        }
