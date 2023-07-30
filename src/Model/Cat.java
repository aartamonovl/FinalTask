package Model;

import DB.ControllerDB;

import java.sql.SQLException;
import java.util.Locale;

public class Cat extends PetABS {

    public Cat(String name, String birthday, String skills) {
        super(name, birthday, skills);
        try {
            ControllerDB.insertData(getClass().getSimpleName().toLowerCase() + "s", getName(), getBirthday(), getSkills(), 2);
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void trainNewCommand() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void speak() {

    }
}
