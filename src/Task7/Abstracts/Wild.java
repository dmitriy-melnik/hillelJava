package Task7.Abstracts;
import Task7.Abstracts.Animal;

public abstract class Wild extends Animal {

    private boolean isPredator;

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public String voice() {
        if(isPredator) {
            return "Hello, i am a wild animal and i am angry";
        }
        else {
            return "Hello, i am a wild animal";
        }
    }
}
