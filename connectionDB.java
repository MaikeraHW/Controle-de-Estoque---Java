import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
    private static final String URL_JDBC_Pattern = "jdbc:sqlite:my_data_base.db";

    //connection method
    public static Connection connectTo() {
        try {
            return DriverManager.getConnection(URL_JDBC_Pattern);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //generic connection method - URL, user and password

    public static Connection genericConnectTo(String url, String user, String password) {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
}