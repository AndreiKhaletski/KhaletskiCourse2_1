package by.id_academy.jd2.dao;

import by.id_academy.jd2.dao.api.IDaoActiveUsers;

import java.util.ArrayList;
import java.util.List;

public class DaoActiveUsers implements IDaoActiveUsers {

    private static final List<String> idActiveUsers = new ArrayList<>();

    @Override
    public void addActive(String id) {
        idActiveUsers.add(id);
    }

    @Override
    public int getActive() {
        return idActiveUsers.size();
    }

    @Override
    public void deleteUserIsSession(String id) {
        idActiveUsers.remove(id);
    }
}
