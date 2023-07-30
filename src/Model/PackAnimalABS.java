package Model;

import Model.AnimalABS;

public abstract class PackAnimalABS extends AnimalABS {
    public PackAnimalABS(String name, String birthday, String skills) {
        super(name, birthday, skills);
    }

    public abstract void eat();
    public abstract void speak();
}
