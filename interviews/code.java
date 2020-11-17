package interviews;

import java.util.Arrays;

public class code { // longest prefix
    public static void main(String[] args) {
        String[] str = {"racecar","ecare", "car"};
        Arrays.sort(str);
        for(int j = 0; j <str.length; j ++) {
            System.out.println(str[j]);
        }
        
        int i = 0;
        while(i < str[0].length() && i < str[str.length-1].length()) {
            if(str[0].charAt(i) == str[str.length-1].charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        System.out.println(str[0].substring(0, i));

    }
}
