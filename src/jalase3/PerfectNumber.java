package jalase3;

public class PerfectNumber {
    public static void main(String[] args) {
        int a=6, sum=0;
        for(int i=1;i<a ;i++) {
            if(a%i==0) {
                sum=sum+i;
            }
        }
        System.out.println((a==sum)?"Perfect":"Not Perfect");
    }
}
