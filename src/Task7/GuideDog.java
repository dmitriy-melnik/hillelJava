package Task7;

public class GuideDog extends Dog {

    private boolean isTrained;

    public GuideDog() {
        setTrained(true);
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public String goHome() {
        return "We are going to the home";
    }

    @Override
    public String voice() {
        if (isTrained) {
            return "I can take you home";
        } else {
            return "Woof";
        }
    }

}
