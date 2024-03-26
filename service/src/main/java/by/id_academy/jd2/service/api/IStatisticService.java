package by.id_academy.jd2.service.api;

public interface IStatisticService {
    public int getUsers();

    int getMessages();

    public void monitorActive(String id);
    public int getActiveUsers ();

    public void notMonitorActive(String id);
}
