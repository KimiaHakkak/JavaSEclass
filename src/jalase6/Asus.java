package jalase6;

public class Asus extends Laptop{
    private String battery;

    public Asus() {
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Asus{" +
                "battery='" + battery + '\'' +
                '}';
    }
}
