package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.ConnectionDB.statement;
import static DB.ConnectionDB.connection;


public class ControllerDB {

    public static void controllerConnectDB() throws ClassNotFoundException, SQLException {
        boolean checkDB = checkDB();
        if (checkDB) {
            System.out.println("База данных с названием " + ConnectConfig.DB_NAME + " уже существует.\nПродолжить работу с ней?\nN - нет");
            System.out.println("Внимание! В случае N, существующая база данных будет удалена.");
            String answer = Input.ConsoleInput.inputStr();
            if ("N".equals(answer)) {
                connection.setAutoCommit(false);
                try {
                    dropDB();
                    createNewDB();
                    useExistingDB();
                    createTablesDB();
                    connection.commit();
                    System.out.println("База данных " + ConnectConfig.DB_NAME + " перезаписана. Хотите заполнить ее базовыми данными? Y - да");
                } catch (SQLException ex) {
                    connection.rollback();
                    System.out.println("База данных " + ConnectConfig.DB_NAME + " не была перезаписана.");
                    System.out.println(ex.getMessage());
                }
                connection.setAutoCommit(true);
                String ans = Input.ConsoleInput.inputStr();
                if ("Y".equals(ans)) {
                    insertBaseAnimalsDB();
                }
                System.out.println("Success");
            } else {
                useExistingDB();
                System.out.println("База данных " + ConnectConfig.DB_NAME + " подключена.");
            }
        }
    }

    private static void useExistingDB() throws SQLException {
        statement.executeUpdate(QueriesDB.useDatabase());
    }

    private static void createNewDB() throws SQLException {
        statement.executeUpdate(QueriesDB.createNewDatabase());
    }

    private static void createTablesDB() throws SQLException {
        statement.executeUpdate(QueriesDB.createTableAnimals());
        statement.executeUpdate(QueriesDB.createTablePet());
        statement.executeUpdate(QueriesDB.createTablePackAnimals());
        statement.executeUpdate(QueriesDB.createTableDogs());
        statement.executeUpdate(QueriesDB.createTableCats());
        statement.executeUpdate(QueriesDB.createTableHamsters());
        statement.executeUpdate(QueriesDB.createTableHorses());
        statement.executeUpdate(QueriesDB.createTableCamels());
        statement.executeUpdate(QueriesDB.createTableDonkeys());
    }

    private static void insertBaseAnimalsDB() throws SQLException {
        statement.executeUpdate(QueriesDB.insertBaseAnimals());
        statement.executeUpdate(QueriesDB.insertBasePets());
        statement.executeUpdate(QueriesDB.insertBasePackAnimals());
        statement.executeUpdate(QueriesDB.insertBaseDogs());
        statement.executeUpdate(QueriesDB.insertBaseCats());
        statement.executeUpdate(QueriesDB.insertBaseHamsters());
        statement.executeUpdate(QueriesDB.insertBaseHorses());
        statement.executeUpdate(QueriesDB.insertBaseCamels());
        statement.executeUpdate(QueriesDB.insertBaseDonkeys());
    }

    private static void dropDB() throws SQLException {
        statement.executeUpdate(QueriesDB.dropDatabase());
    }

    private static boolean checkDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery(QueriesDB.showDatabases());
        while (resultSet.next()) {
            if (ConnectConfig.DB_NAME.equals(resultSet.getString(1))) {
                return true;
            }
        }
        return false;
    }

    public static void insertData(String table, String name, String birthday, String skills, int gen) throws SQLException {
        statement.executeUpdate(QueriesDB.insertInto(table, name, birthday, skills, gen));
    }

    public static ResultSet selectDataForName(String table, String name) throws SQLException {
        return statement.executeQuery(QueriesDB.selectDataForName(table, name));
    }

    public static void updateAnimalSkills(String table, String name, String skills) throws SQLException {
        statement.executeUpdate(QueriesDB.updateAnimalSkills(table, name, skills));
    }
}
