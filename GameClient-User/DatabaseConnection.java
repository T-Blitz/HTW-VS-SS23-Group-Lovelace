import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "lovelace";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc:mysql//localhost/" +databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

    public void addUser(String username, String password) {
        //User hinzufuegen
    }


}