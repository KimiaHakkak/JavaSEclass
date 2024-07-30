package jalase6;

public class Sofa extends NonElectric{
    private int personNum;

    public Sofa() {
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "personNum=" + personNum +
                '}';
    }
}
