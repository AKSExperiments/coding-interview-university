package interviews;

public class balancedParentheses {

    static int count = 0;

    public static void printBP(char arr[], int n, int open, int close, int index) {
        // if close == n
        // printing char[]
        // open > close
        // )
        // open <= n
        // (

        if (close == n) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println(count++);
            return;
        } else {
            if(open > close) {
                arr[index] = ')';
                printBP(arr, n, open, close+1, index+1);
            }
            if(open < n) {
                arr[index] = '(';
                printBP(arr, n, open+1, close, index+1);
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[] charArr = new char[2*n];
        printBP(charArr, n, 0, 0, 0);
    }
}
