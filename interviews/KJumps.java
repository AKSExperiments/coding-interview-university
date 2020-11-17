package interviews;

public class KJumps {
    public static boolean flag = false;
    public static boolean jumps(int[] arr, int k, int i) {
        if (flag || (k == 0 && i == arr.length-1)) {
            return true;
        }
        if(k == 0 ) {
            return false;
        }
        if( i - arr[i] >= 0 ) {
            flag = flag || jumps(arr, k-1, i - arr[i]);
        }
        if( i + arr[i] < arr.length) {
            flag = flag || jumps(arr, k-1, i + arr[i]);
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 2, 1, 2};
        // recursive
        // while
        int k = 100;
        System.out.println(jumps(arr, k, 0));
    }
}
