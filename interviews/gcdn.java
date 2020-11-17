package interviews;

public class gcdn {
    public int generalizedGCD(int num, int[] arr)
    {
        int res = arr[0];
        for(int i = 1; i < num; i++) {
            res = gcd(res, arr[i]);
        }
        return res;
    }
    
    public int gcd(int a, int b) {
        if(a==0) {return b;}
        if(b==0) {return a;}
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        gcdn temp = new gcdn();
        System.out.println(temp.generalizedGCD(arr.length, arr));
    }
}

//Collections.sort(people, (a, b) -> a.name.compareToIgnoreCase(b.name));
//System.out.println(people);
//Collections.sort(people, (a, b) -> a.age < b.age ? -1 : a.age == b.age ? 0 : 1);
//System.out.println(people);

