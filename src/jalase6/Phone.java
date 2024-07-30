package jalase6;

public class Phone extends Electric{
    private int screenSize;

    public Phone(){
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenSize=" + screenSize +
                '}';
    }
}
