package Model;

import DB.ControllerDB;
import View.Output;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    public static String addName() {
        System.out.println("Введите кличку:");
        return Input.ConsoleInput.inputStr();
    }

    private static String addBirthday() {
        System.out.println("Введите дату рождения в формате YYYY-mm-dd:");
        return Input.ConsoleInput.inputStr();
    }

    private static String addSkills() {
        System.out.println("Введите умения через запятую:");
        return Input.ConsoleInput.inputStr();
    }

    public static void addDog() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Dog(name, birthday, skills);
    }

    public static void addCat() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Cat(name, birthday, skills);
    }

    public static void addHamster() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Hamster(name, birthday, skills);
    }

    public static void addHorse() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Horse(name, birthday, skills);
    }

    public static void addCamel() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Camel(name, birthday, skills);
    }

    public static void addDonkey() {
        String name = addName();
        String birthday = addBirthday();
        String skills = addSkills();
        new Donkey(name, birthday, skills);
    }

    public static void searchAnimal(String animal) throws SQLException {
        String name = addName();
        Output.viewResultForSelect(ControllerDB.selectDataForName(animal, name));
    }

    public static void trainAnimal(String animal) throws SQLException {
        String name = addName();
        ResultSet resultSet = ControllerDB.selectDataForName(animal, name);
        Output.viewResultForSelect(resultSet);
        String oldSkills = "";
        while (resultSet.next()){
            oldSkills = resultSet.getString(4);
        }
        String skills = addSkills();
        if (oldSkills.equals("")){
            ControllerDB.updateAnimalSkills(animal, name, skills);
        } else {
            ControllerDB.updateAnimalSkills(animal, name, oldSkills + ", " + skills);
        }
        System.out.println("Success");
    }
}
