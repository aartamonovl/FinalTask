package Model;

import Model.AnimalABS;

public abstract class PetABS extends AnimalABS {
    public PetABS(String name, String birthday, String skills) {
        super(name, birthday, skills);
    }

    public abstract void eat();
    public abstract void speak();
}
