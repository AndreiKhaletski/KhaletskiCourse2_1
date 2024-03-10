package by.id_academy.jd2.two.dao;

import by.id_academy.jd2.two.dao.api.IDaoUser;
import by.id_academy.jd2.two.user.UserAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DaoUser implements IDaoUser {
    private static final Map<String, UserAccount> information = new HashMap<>();

    public DaoUser(){
        information.put("admin",(new UserAccount(
                "admin",
                "admin",
                "Админ Админович",
                "01.01.1985",
                "admin"
        )));
    }

    @Override
    public void saveUser(UserAccount userAccount) {
//        this.information.compute(userAccount, (k, v) -> v != null ? v + 1 : 1);
        information.put(userAccount.getLogin(), userAccount);
    }

    @Override
    public Map<String, UserAccount> getInformation() {
        return information;
    }
    //    private final ArrayList<String> listAccount = new ArrayList<>();
//    @Override
//    public void AccoutUser(UserAccount userAccount) {
//        listAccount.add(userAccount.getLogin());
//        listAccount.add(userAccount.getPassword());
//    }
//
//    @Override
//public ArrayList<String> list(){
//
//    return listAccount;
//}
}