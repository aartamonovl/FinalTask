package Model;

public abstract class AnimalABS {
    private String name;
    private String birthday;
    private String skills;

    public AnimalABS(String name, String birthday, String skills) {
        this.name = name;
        this.birthday = birthday;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public abstract void trainNewCommand();
}