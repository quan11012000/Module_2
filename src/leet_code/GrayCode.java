package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



    public class GrayCode {
        public static List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            int total = 1 << n;
            for (int i = 0; i < total; i++) {
                int gray = i ^ (i >> 1);
                res.add(gray);
            }
            return res;
        }

        public static void main(String[] args) {
            int n = 3;
            List<Integer> graySequence = grayCode(n);
            System.out.println(graySequence);  // Output: [0, 1, 3, 2]
        }
    }

