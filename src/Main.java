import DB.ControllerDB;
import View.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ControllerDB.controllerConnectDB();
        Menu menu = new Menu();
        menu.run();
    }
}