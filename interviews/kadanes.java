package interviews;

public class kadanes {

    public static int greedy (int[] arr) {
        int max_so_far = Integer.MIN_VALUE, current_max = 0;
        for (int i = 0; i < arr.length; i++) {
            current_max = Math.max(arr[i], current_max + arr[i]);
            if (current_max > max_so_far) {
                max_so_far = current_max;
            }
        }
        return max_so_far;
    }

//    public static int dp (int[] arr) {
//
//    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("greedy ==>" + greedy(arr));
//        System.out.println("DP ==>" + dp(arr));
    }
}
