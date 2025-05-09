package ss2_vong_lap.bai_tap;
public class HundressPrime {
    public static void main(String[] args) {
        int i=2;
        while (i<100){
            if(prime(i)){
                System.out.println(i);
                i++;
                continue;
            }else i++;
        }
    }
    public static boolean prime(int number){
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
