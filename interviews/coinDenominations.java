import java.util.Scanner;

public class CoinDenominations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int[] denominations = {2000, 500, 100, 20, 10, 5, 2, 1};
        int[] countOfNotes = new int[8];

        for(int i=0; i<denominations.length; i++){
            if(value >= denominations[i]){
                countOfNotes[i] = value/denominations[i];
                value = value % denominations[i];
            }
        }
        System.out.println("Output is : ");
        for(int i=0; i<denominations.length; i++){
            if(countOfNotes[i] > 0){
                System.out.println(countOfNotes[i] +" of "+ denominations[i]);
            }
        }
    }
}
