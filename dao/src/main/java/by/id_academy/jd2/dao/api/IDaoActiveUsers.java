package by.id_academy.jd2.dao.api;

public interface IDaoActiveUsers {
    public void addActive(String id);
    public int getActive();
    public void deleteUserIsSession(String id);
}
