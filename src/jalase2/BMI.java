package jalase2;

public class BMI {
    public static void main(String[] args) {
        double height = 170;
        float weight = 60F;

        double bmi = weight / (height * height);
        System.out.println("BMI = " + bmi);
    }
}
