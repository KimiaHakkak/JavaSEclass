package jalase6;

public class Dell extends Laptop{
    private boolean touch;

    public Dell() {
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    @Override
    public String toString() {
        return "Dell{" +
                "touch=" + touch +
                '}';
    }
}
