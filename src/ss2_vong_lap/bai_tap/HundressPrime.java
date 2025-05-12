package ss2_vong_lap.bai_tap;

import ss3_mang.common_method.ArrayCommonMethod;

public class HundressPrime {
    public static void main(String[] args) {
        int i=2;
        while (i<100){
            if(ArrayCommonMethod.prime(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

}
