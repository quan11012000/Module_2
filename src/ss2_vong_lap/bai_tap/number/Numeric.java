package ss2_vong_lap.bai_tap.number;
public class Numeric {
    public static boolean isPrimeNumber(int number){
        if(number<2){
            return false;
        }else{
            for (int i=2 ; i<= Math.sqrt(number);i++){
                if(number%i==0) return false;
            }
        }
        return true;
    }
}
