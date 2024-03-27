package by.id_academy.jd2.service.api;

public interface IStatisticService {

    /*
     * Метод возвращает
     * количество пользователей
     * зарегистрированных в
     * системе
     *
     * @return
     */
    public int getUsers();

    /*
     * Метод позвращает
     * общее количество
     * отправленнных сообщений
     *
     * @return
     */
    int getMessages();

    /*
     * Метод передает id активного
     * пользователя в dao
     *
     * @param id
     */
    public void monitorActive(String id);

    /*
     * Метод возвращает
     * общее количество
     * активных пользователй
     *
     * @return
     */
    public int getActiveUsers ();

    /*
     * Метод передает id
     * пользователя покинувший
     * сессию
     *
     * @param id
     */
    public void notMonitorActive(String id);
}
