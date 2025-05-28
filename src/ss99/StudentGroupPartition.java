package ss99;

import common.ArrayCommonMethod;

import java.util.*;


public class StudentGroupPartition {
    static int minDifference = Integer.MAX_VALUE;

    // Hai mảng lưu nhóm chia tốt nhất
    static int[] bestGroupA;
    static int[] bestGroupB;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        // Nhập số lượng học sinh
        do{
            System.out.print("Nhập số lượng học sinh: ");
             n = scanner.nextInt();
            if(n<1 || n>16){
                System.out.println("nhap lai so luong học sinh");
            }
        }while (n<1 || n>16);


        // Nhập giá trị từng học sinh (ví dụ điểm số hoặc năng lực)
        int[] students = ArrayCommonMethod.inputArr(n);
        // Tổng số cách chia là 2^n (mỗi học sinh có 2 lựa chọn: nhóm A hoặc nhóm B)
        int totalWays = 1 << n;

        // Duyệt tất cả các cách chia nhóm
        for (int mask = 0; mask < totalWays; mask++) {
            int[] groupA = new int[n]; // Nhóm A tạm thời
            int[] groupB = new int[n]; // Nhóm B tạm thời
            int indexA = 0, indexB = 0;
            int sumA = 0, sumB = 0;

            // Với mỗi học sinh, quyết định cho vào nhóm A hay B dựa theo bit trong mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    groupA[indexA++] = students[i];
                    sumA += students[i];
                } else {
                    groupB[indexB++] = students[i];
                    sumB += students[i];
                }
            }

            // Tính độ chênh lệch giữa 2 nhóm
            int difference = Math.abs(sumA - sumB);

            // Nếu tìm được cách chia tốt hơn thì lưu lại
            if (difference < minDifference) {
                minDifference = difference;
                bestGroupA = new int[indexA];
                bestGroupB = new int[indexB];
                System.arraycopy(groupA, 0, bestGroupA, 0, indexA);
                System.arraycopy(groupB, 0, bestGroupB, 0, indexB);
            }
        }

        // In kết quả tốt nhất
        System.out.println("\n== Cách chia nhóm tối ưu nhất ==");
        System.out.print("Nhóm A: ");
        printArray(bestGroupA);
        System.out.print("Nhóm B: ");
        printArray(bestGroupB);
        System.out.println("Độ chênh lệch nhỏ nhất: " + minDifference);
    }

    // Hàm in các phần tử trong mảng
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
