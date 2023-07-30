package DB;

public class QueriesDB {
    protected static String useDatabase() {
        return "USE " + ConnectConfig.DB_NAME;
    }

    protected static String showDatabases() {
        return "SHOW DATABASES;";
    }

    protected static String showTables() {
        return "SHOW TABLES;";
    }

    protected static String dropDatabase() {
        return "DROP DATABASE " + ConnectConfig.DB_NAME + ";";
    }

    protected static String createNewDatabase() {
        return "CREATE DATABASE human_friends;";
    }

    protected static String createTableAnimals() {
        return "CREATE TABLE animals\n" +
                "(\n" +
                "Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "Class_name VARCHAR(30)\n" +
                ");";
    }

    protected static String createTablePet() {
        return "CREATE TABLE pets\n" +
                "    (\n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "        Genus_name VARCHAR (20),\n" +
                "        Class_id INT,\n" +
                "        FOREIGN KEY (Class_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTablePackAnimals() {
        return "CREATE TABLE pack_animals\n" +
                "    (\n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "        Genus_name VARCHAR (20),\n" +
                "        Class_id INT,\n" +
                "        FOREIGN KEY (Class_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableDogs() {
        return "CREATE TABLE dogs \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableCats() {
        return "CREATE TABLE cats \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableHamsters() {
        return "CREATE TABLE hamsters \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableHorses() {
        return "CREATE TABLE horses \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableCamels() {
        return "CREATE TABLE camels \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String createTableDonkeys() {
        return "CREATE TABLE donkeys \n" +
                "    (       \n" +
                "        Id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "        Name VARCHAR(20), \n" +
                "        Birthday DATE,\n" +
                "        Commands VARCHAR(50),\n" +
                "        Genus_id int,\n" +
                "        Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                "    );";
    }

    protected static String insertBaseAnimals() {
        return "INSERT INTO animals (Class_name)\n" +
                "    VALUES ('PackAnimals'),\n" +
                "    ('Pets');";
    }

    protected static String insertBasePets() {
        return "INSERT INTO pets (Genus_name, Class_id)\n" +
                "    VALUES ('Dogs', 2),\n" +
                "    ('Cats', 2),\n" +
                "    ('Hamsters', 2);";
    }

    protected static String insertBasePackAnimals() {
        return "INSERT INTO pack_animals (Genus_name, Class_id)\n" +
                "    VALUES ('Horses', 1),\n" +
                "    ('Camels', 1),\n" +
                "    ('Donkeys', 1);";
    }

    protected static String insertBaseDogs() {
        return "INSERT INTO dogs (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUES ('Барбос', '2020-01-01', 'ко мне, лежать, лапу, голос', 1),\n" +
                "    ('Барон', '2022-06-12', 'сидеть, лежать, лапу', 1),\n" +
                "    ('Шарик', '2019-03-01', 'сидеть, лежать, лапу, след, фас', 1), \n" +
                "    ('Лайка', '2020-05-10', 'сидеть, лежать, фу, место', 1);";
    }

    protected static String insertBaseCats() {
        return "INSERT INTO cats (Name, Birthday, Commands, Genus_id)\n" +
                "   VALUES ('Барсик', '2011-01-01', 'кс-кс-кс', 2),\n" +
                "   ('Муся', '2016-01-01', 'отставить!', 2),\n" +
                "   ('Тишка', '2017-01-01', '', 2);";
    }

    protected static String insertBaseHamsters() {
        return "INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUES ('Дуся', '2020-10-12', '', 3),\n" +
                "    ('Пуся', '2021-03-12', '', 3),\n" +
                "    ('Нуся', '2022-07-11', '', 3), \n" +
                "    ('Люся', '2022-05-10', '', 3);";
    }

    protected static String insertBaseHorses() {
        return "INSERT INTO horses (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUES ('Пикник', '2020-01-12', 'бегом, шагом', 1),\n" +
                "    ('Марс', '2017-03-12', 'бегом, шагом, хоп', 1),\n" +
                "    ('Сникерс', '2016-07-12', 'бегом, шагом', 1),\n" +
                "    ('Натс', '2020-11-10', 'бегом, шагом, хоп', 1);";
    }

    protected static String insertBaseCamels() {
        return "INSERT INTO camels (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUES ('Лохматый', '2022-04-10', 'вернись', 2),\n" +
                "    ('Лысый', '2019-03-12', 'остановись', 2),\n" +
                "    ('Бородатый', '2015-07-12', 'плевок', 2),\n" +
                "    ('Хвостатый', '2022-12-10', 'улыбнись', 2);";
    }

    protected static String insertBaseDonkeys() {
        return "INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUES ('Первый', '2019-04-10', '', 2),\n" +
                "    ('Второй', '2020-03-12', '', 2),\n" +
                "    ('Третий', '2021-07-12', '', 2),\n" +
                "    ('Четвертый', '2022-12-10', '', 2);";
    }

    protected static String insertInto(String table, String name, String birthday, String skills, int gen){
        return "INSERT INTO " + table + " (Name, Birthday, Commands, Genus_id)\n" +
                "    VALUE ('" + name + "', '" + birthday + "', '" + skills + "', " + gen + ");";
    }

    protected static String selectDataForName(String table, String name){
        return "SELECT *\n" +
                "FROM " + table + "\n" +
                "WHERE Name = '" + name + "';";
    }

    protected static String updateAnimalSkills(String table, String name, String skills){
        return "UPDATE " + table + "\n" +
                "SET Commands = '" + skills + "'\n" +
                "WHERE Name = '" + name + "';";
    }
}
