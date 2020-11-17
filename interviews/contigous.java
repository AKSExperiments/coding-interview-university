package interviews;

import java.util.HashMap;

public class contigous {

    public static void main(String[] args) {
        int[] arr ={15, -2, 2, -8, 1, 7, 10, 23};
        int l = 0;
        int r = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length-1; i++) {
            sum += arr[i];
            if(hm.get(sum) != null) {
                int tempL = hm.get(sum);
                if(r -l < i - (tempL+1)){
                    r = i;
                    l = tempL+1;
                }
            } else {
                hm.put(sum, i);
            }
        }
        if( l != r) {
            for(int i = l; i <=r; i++) {
                System.out.print(arr[i]);
            }
        } else {
            System.out.println("Not found!");
        }
    }
}

