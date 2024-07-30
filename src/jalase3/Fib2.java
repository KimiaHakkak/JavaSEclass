package jalase3;
//دنباله فیبوناچی 50 جمله اول تقسیم بر جمله قبلیش
public class Fib2 {
    public static void main(String[] args) {
        Integer a=0, b=1, c;
        for(int i=3; i<=50; i++){
            c=a+b;
            System.out.println(c/b.doubleValue());
            a=b;
            b=c;
        }
    }
}
