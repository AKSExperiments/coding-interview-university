package interviews;

public class printPrimes {
    public static void main(String[] args) {
        // (1, n)
//        20 - 20, 10
        // 16 - 2,4,8
        int last = 100;
        int count = 0;
        for(int i = 2; i <= last; i++) {
            double sqrt = Math.sqrt(i);
            boolean flag = true;
            int j = (int) sqrt;
            while (j < 1) {
                if(i%j == 0) {
                    flag = false;
                    break;
                }
                j--;
            }
            if(flag) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("count =>" + count);
    }
}

