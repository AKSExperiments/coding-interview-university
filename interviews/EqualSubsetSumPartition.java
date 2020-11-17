package interviews;

public class EqualSubsetSumPartition {

    public static boolean rec(int[] arr, Boolean[][] dp, int sum, int index) {
        if(sum == 0){
            return true;
        }
        boolean flag = false;
        if(index == arr.length) {
            flag = false;
        } else {
            if(dp[sum][index] != null) {
                return dp[sum][index];
            }
            if(sum >= arr[index]) {
                flag = flag || rec(arr, dp,sum - arr[index], index+1);
            }
            flag = flag || rec(arr, dp, sum, index+1);
            dp[sum][index] = flag;
        }
        return flag;
    }

    public static boolean handlerRec(int[] arr, int sum) {
        if(sum%2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[sum/2+1][arr.length];
        return rec(arr, dp, sum/2, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1, 1, 3, 4, 7};
        int[] arr2 = {2, 3, 4, 6};
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(handlerRec(arr, sum));
        sum = 0;
        for(int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        System.out.println(handlerRec(arr1, sum));
        sum = 0;
        for(int i = 0; i < arr2.length; i++) {
            sum += arr2[i];
        }
        System.out.println(handlerRec(arr2, sum));
    }
}
