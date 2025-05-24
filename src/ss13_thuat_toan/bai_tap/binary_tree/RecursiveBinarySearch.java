package ss13_thuat_toan.bai_tap.binary_tree;

public class RecursiveBinarySearch {
 
    public static int binarySearch(int[] arr,int left, int right, int value){
        if(left>right){
            return -1;
        }else{
            int mid= left+(right-left)/2;
            if(arr[mid]==value){
                return mid;
            }else if(value>arr[mid]){
                return binarySearch(arr,mid+1,right,value);
            }else{
                return binarySearch(arr,left,mid-1,value);
            }
        }
    }
}
