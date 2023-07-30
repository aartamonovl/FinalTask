package DB;

import java.sql.*;


public class ConnectionDB {
    static Statement statement;
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(ConnectConfig.URL,
                    ConnectConfig.USER_NAME,
                    ConnectConfig.PASSWORD);
            System.out.println("Connection success");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
