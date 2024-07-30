package jalase6;

public abstract class Electric extends Product{
    private int voltage;

    public Electric(){
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Electric{" +
                "voltage=" + voltage +
                '}';
    }
}
