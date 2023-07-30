package View;

import Model.Controller;
import Model.Counter;

import java.sql.SQLException;

public class Menu {

    public void run() throws SQLException {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Завести новое животное.");
            System.out.println("2. Посмотреть список команд для конкретного животного.");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("0. Выход");
            int choice = Input.ConsoleInput.inputInt();
            switch (choice) {
                case 0 -> System.exit(0);
                case 1 -> addAnimal();
                case 2 -> searchCommand();
                case 3 -> trainAnimal();
                default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
            }
        }
    }

    private void addAnimal() {
        outer:
        while (true) {
            System.out.println("Выберите подкласс животного: ");
            System.out.println("1. Домашние животные.");
            System.out.println("2. Вьючные животные.");
            System.out.println("0. Выход.");
            int choice = Input.ConsoleInput.inputInt();
            switch (choice) {
                case 0 -> {
                    break outer;
                }
                case 1 -> addPet();
                case 2 -> addPackAnimal();
                default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
            }
        }
    }

    private void addPet() {
        try (Counter count = new Counter()){
            outer:
            while (true) {
                System.out.println("Выберите вид: ");
                System.out.println("1. Собака.");
                System.out.println("2. Кошка.");
                System.out.println("3. Хомяк.");
                System.out.println("0. Выход.");

                int choice = Input.ConsoleInput.inputInt();
                switch (choice) {
                    case 0 -> {
                        break outer;
                    }
                    case 1 -> {
                        Controller.addDog();
                        count.add();
                    }
                    case 2 -> {
                        Controller.addCat();
                        count.add();
                    }
                    case 3 -> {
                        Controller.addHamster();
                        count.add();
                    }
                    default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
                }
            }
        }
    }

    private void addPackAnimal() {
        outer:
        while (true) {
            System.out.println("Выберите вид: ");
            System.out.println("1. Лошадь.");
            System.out.println("2. Верблюд.");
            System.out.println("3. Осел.");
            System.out.println("0. Выход.");
            int choice = Input.ConsoleInput.inputInt();
            switch (choice) {
                case 0 -> {
                    break outer;
                }
                case 1 -> Controller.addHorse();
                case 2 -> Controller.addCamel();
                case 3 -> Controller.addDonkey();
                default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
            }
        }
    }


    private void searchCommand() throws SQLException {
        outer:
        while (true) {
            System.out.println("Какое животное Вас интересует?");
            System.out.println("1. Собака.");
            System.out.println("2. Кошка.");
            System.out.println("3. Хомяк.");
            System.out.println("4. Лошадь.");
            System.out.println("5. Верблюд.");
            System.out.println("6. Осел.");
            System.out.println("0. Выход.");
            int choice = Input.ConsoleInput.inputInt();
            switch (choice) {
                case 0 -> {
                    break outer;
                }
                case 1 -> Controller.searchAnimal("dogs");
                case 2 -> Controller.searchAnimal("cats");
                case 3 -> Controller.searchAnimal("hamsters");
                case 4 -> Controller.searchAnimal("horses");
                case 5 -> Controller.searchAnimal("camels");
                case 6 -> Controller.searchAnimal("donkeys");
                default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
            }
        }
    }

    private void trainAnimal() throws SQLException {
        outer:
        while (true) {
            System.out.println("Какое животное Вас интересует?");
            System.out.println("1. Собака.");
            System.out.println("2. Кошка.");
            System.out.println("3. Хомяк.");
            System.out.println("4. Лошадь.");
            System.out.println("5. Верблюд.");
            System.out.println("6. Осел.");
            System.out.println("0. Выход.");
            int choice = Input.ConsoleInput.inputInt();
            switch (choice) {
                case 0 -> {
                    break outer;
                }
                case 1 -> Controller.trainAnimal("dogs");
                case 2 -> Controller.trainAnimal("cats");
                case 3 -> Controller.trainAnimal("hamsters");
                case 4 -> Controller.trainAnimal("horses");
                case 5 -> Controller.trainAnimal("camels");
                case 6 -> Controller.trainAnimal("donkeys");
                default -> System.out.println("Такого пункта в меню нет. Выберите доступное действие.");
            }
        }
    }
}
