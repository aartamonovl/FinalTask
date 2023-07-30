package View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Output {
    public static void viewResultForSelect(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println("Умения животного:");
            System.out.println(resultSet.getString(4));
            System.out.println();
        }
    }
}
