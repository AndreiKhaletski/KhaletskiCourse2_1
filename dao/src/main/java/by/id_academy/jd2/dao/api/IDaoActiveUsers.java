package by.id_academy.jd2.dao.api;

public interface IDaoActiveUsers {

    /*
     * Метод добавляет активного
     * пользователя в лист
     *
     * @param id
     */
    public void addActive(String id);

    /*
     * Метод возращает количество
     * активных пользователей
     *
     * @return
     */
    public int getActive();

    /*
     * Метод передает id пользователя
     * вышедшего из сессии и удалет
     * из ArrayList
     *
     * @param id
     */
    public void deleteUserIsSession(String id);
}
