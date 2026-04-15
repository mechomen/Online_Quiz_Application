import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quiz_app",
                "root",
                "Babu@1234"   // change this
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}