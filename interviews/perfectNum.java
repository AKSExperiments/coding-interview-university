package interviews;

public class perfectNum {
    // 20, 208
    // 1, 19
    // 2, 28
    // 3, 37
    // 9, 91
    // 10, 109
    // 19,28,37,46,55,64,73,82,91,109
    public static void main(String[] args) {
        int n = 90;
        int counter = 0;
        int i;
        for(i = 19;;i=i+9) {
            int temp = 0;
            for (int j = i; j > 0; j = j/10) {
              temp = temp + (j%10);
            }
            if(temp == 10) {
            counter++;
            }
            if(counter == n) {
              break;
            }
        }
        System.out.println(i);
    }
}
