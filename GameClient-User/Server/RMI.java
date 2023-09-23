package Server;

public class RMI {

    private Database database;

    public RMI(Database database) {

        this.database = database;
    }

    public void Login(String name, String password) {
        //Login
        database.addUser(name, password);

    }

    public void start_RMI() {
        //Server.RMI erstellen
        //Verbindung prüfen
        //Server.Server starten

    }
}