package interviews;

import java.util.HashMap;
import java.util.Map;

public class xavier {
    public static int[] fun(int input, int[][] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int globalMax = 0;
        for(int i = 0; i < input; i++) {
            int temp1 = 0;
            int temp2 = 0;
            for(int j = 0; j < input; j++) {
                if (arr[i][j] == 1) {
                    temp1++;
                } else if (arr[i][j] == 2) {
                    temp2++;
                }
            }
            globalMax = Math.max(temp1, globalMax);
            hm.put(i, temp1+temp2);
        }
        int[] result = new int[input];
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            if(entry.getValue() >= globalMax) {
                result[entry.getKey()] = 1;
            } else {
                result[entry.getKey()] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 4;
        int[][] arr = {{0,2,2,2},{2,0,0,1},{2,1,0,0},{2,0,1,0}};
        int[] res = fun(input, arr);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
