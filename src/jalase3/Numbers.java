package jalase3;
//چاپ اعداد بین b تاa صعودی یا نزولی
public class Numbers {
    public static void main(String[] args) {
        int a=117, b=5;
        if(a<b) {
            for (int i = a; i <= b; i++) {System.out.println(i);}
        }else {
            for (int i = a; i >= b; i--) {System.out.println(i);}
        }
    }
}
