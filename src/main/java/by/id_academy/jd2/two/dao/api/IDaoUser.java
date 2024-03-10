package by.id_academy.jd2.two.dao.api;

import by.id_academy.jd2.two.user.UserAccount;

import java.util.Map;
import java.util.Objects;

public interface IDaoUser {
    void saveUser(UserAccount userAccount);
    Map<String, UserAccount> getInformation();

}
