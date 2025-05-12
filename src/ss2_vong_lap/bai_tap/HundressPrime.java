package ss2_vong_lap.bai_tap;
import ss2_vong_lap.bai_tap.number.Numeric;
public class HundressPrime {
    public static void main(String[] args) {
        int i=2;
        while (i<100){
            if(Numeric.isPrimeNumber(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

}
