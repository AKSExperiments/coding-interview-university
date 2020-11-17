package interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class byjuR2 {
//    public static void main(String[] args) {
//        String[] arr = {"1","2","3","4","34","12","98","999","9"};
//        // 9999843432121
////        String A = "999";
////        String B = "";
////        System.out.println(A.compareTo(B));
//        Arrays.sort(arr, new Comparator<String>(){
//            @Override
//            public int compare(String a, String b) {
//                String A = a + b;
//                String B = b + a;
//                return A.compareTo(B);
//            }
//        });
//        StringBuilder str = new StringBuilder();
//        for(int i = arr.length-1; i >= 0; i--) {
//            str.append(arr[i]);
//        }
//        System.out.println(str);
//    }

    public static void main(String[] args) {
//        arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >=
        int[] input = {13, 16, 15, 110, 17, 120};
        for(int i = 1; i < input.length; i=i+2) {
            if(input[i-1] < input[i]) {
                // swap
                int temp = input[i];
                input[i] = input[i-1];
                input[i-1] = temp;
            }
            if(i+1 < input.length && input[i] > input[i+1]) {
                // swap
                int temp = input[i];
                input[i] = input[i+1];
                input[i+1] = temp;
            }
        }
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
