public class RMI {

    private DatabaseConnection databaseConnection;

    public RMI(DatabaseConnection databaseConnection) {

        this.databaseConnection = databaseConnection
    }

    public void Login(String name, String password) {
        //Login
        databaseConnection.addUser(name, password);

    }

    public void start_RMI() {
        //RMI erstellen
        //Verbindung prüfen
        //Server starten

    }
}