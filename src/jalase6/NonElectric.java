package jalase6;

public abstract class NonElectric extends Product{
    private int weight;

    public NonElectric() {}

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NonElectric{" +
                "weight=" + weight +
                '}';
    }
}
