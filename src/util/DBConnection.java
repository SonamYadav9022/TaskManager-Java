package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // ✅ ADD THIS LINE
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "Sonam@9022"
            );

            System.out.println("Connected to Database ✅");

        } catch (Exception e) {
            System.out.println("Connection Failed ❌");
            e.printStackTrace();
        }

        return conn;
    }
}