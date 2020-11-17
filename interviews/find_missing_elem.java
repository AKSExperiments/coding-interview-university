package interviews;

public class find_missing_elem {

    public static int OnSorted(int[] arr) {
        int miss = -1;
        for(int i = 0; i < arr.length; i++) {
            if(i+1 != arr[i]) {
                miss = i+1;
                break;
            }
        }
        return miss;
    }

    static int search(int ar[],
                      int size)
    {
        int a = 0, b = size - 1;
        int mid = 0;
        while ((b - a) > 1)
        {
            mid = (a + b) / 2;
            if ((ar[a] - a) != (ar[mid] - mid))
                b = mid;
            else if ((ar[b] - b) != (ar[mid] - mid))
                a = mid;
        }
        return (ar[mid] + 1);
    }

    public static int OlognSorted(int[] arr) {
        // 1, 2, 3, 5
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while( r - l > 1) {
            mid = (l + r)/2; // 1, 2, 2
            if(arr[l] - l != arr[mid] - mid) {
                r = mid;
            } else if (arr[r] - r != arr[mid] - mid) {
                l = mid; // 1, 2
            }
        }
        return arr[mid] + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
//        System.out.println(OnSorted(arr));
        System.out.println(OlognSorted(arr));
//        System.out.println(search(arr, arr.length));
    }
}
