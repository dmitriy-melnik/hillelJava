package Task7.Abstracts;

import Task7.Abstracts.Animal;

public abstract class Pet extends Animal {

    private String name;
    private boolean isVaccinated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String voice() {
        return "Hello, my name is " + name;
    }

}
