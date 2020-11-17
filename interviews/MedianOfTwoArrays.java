package interviews;

//public class MedianOfTwoArrays {
//    public static void main(String[] args) {
//        int[] arr1 = {1,3,5};
//        int[] arr2 = {2,4,6,8,10,14,15,16}; {3,12,13,17}
//                    {2, 3, 4, 6, 8, 10, 12, 13, 14, 15, 16, 17}
//        if(arr1.length > arr2.length) {
//            // swap to make sure arr2 is always bigger of the two
//            int[] temp = arr1;
//            arr1 = arr2;
//            arr2 = temp;
//        }
//        int tot = arr1.length + arr2.length;
//        int medianArrLen = (arr1.length + arr2.length + 1)/2; // 8 + 4 + 1, 6
//        boolean midMedian = false;
//        if (tot%2 == 0) {
//            midMedian = true;
//        }
//        int l1 = 0;
//        int r1 = arr1.length;
//        int mid1 = (l1 + r1)/2; // 2.1
//        int mid2 = medianArrLen - mid1; // 6 - 2, 4,3
//
//        // find the biggest array, if no one is bigger than other doesn't matter
//        // total length to fill i.e. end of the median array is half of the total length of the two arrays
//        // now, if there's x elements needed
//        // and the shorter array is less than the x elements
//        // in our case, the maximum the shorter array can contribute 3 and min 0
//        // that means there's going to be at least 1 element from the bigger array, in the median array of 4 elements
//        // so, the element that is going to be would be the least element in the sorted bigger array
//        // the max elements it can have are all the 4 elements from the longer array
//        // so, minMax indices of bigger array is 1,3 and for shorter it is 0,3
//        int l1 = 0, l2 = 0, r1 = (tot/2 - 1), r2 = (tot/2 - 1);
//        if(tot/2 > arr1.length) {
//            l2 = (tot/2 - arr1.length);
//        }
//
//    }
//}

public class MedianOfTwoArrays
{
    public static double FindMedianSortedArrays(int[] A, int[] B)
    {
        // Make sure we always search the shorter array.
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int aLen = A.length;
        int bLen = B.length;

        int leftHalfLen = (aLen + bLen + 1) / 2;

        // Since A is guaranteed to be the shorter array,
        // we know it can contribute 0 or all of its values.
        int aMinCount = 0;
        int aMaxCount = aLen;

        while (aMinCount <= aMaxCount)
        {
            int aCount = aMinCount + ((aMaxCount - aMinCount) / 2);
            int bCount = leftHalfLen - aCount;

            //
            // Make sure aCount is greater than 0 (because A can contribute 0 values;
            // remember that A is either shorter or of the same length as B). This also
            // implies bCount will be less than B. Length since it won't be possible
            // for B to contribute all of its values if A has contributed at least 1
            // value.
            //
            if (aCount > 0 && A[aCount - 1] > B[bCount])
            {
                // Decrease A's contribution size; x lies in the right half.
                aMaxCount = aCount - 1;
            }

            //
            // Make sure aCount is less than A.Length since A can actually contribute
            // all of its values (remember that A is either shorter or of the same
            // length as B). This also implies bCount > 0 because B has to contribute
            // at least 1 value if aCount < A.Length.
            //
            else if (aCount < aLen && B[bCount - 1] > A[aCount])
            {
                // Decrease B's contribution size, i.e. increase A's contribution size;
                // y lies in the right half.
                aMinCount = aCount + 1;
            }
            else
            {
                //
                // Neither x nor y lie beyond the left half. We found the right aCount.
                // We don't know how x and y compare to each other yet though.
                //

                //
                // If aLen + bLen is odd, the median is the greater of x and y.
                //
                int leftHalfEnd =
                        (aCount == 0)             // A not contributing?
                                ? B[bCount - 1]       // aCount = 0 implies bCount > 0
                                : (bCount == 0)       // B is not contributing?
                                ? A[aCount - 1]   // bCount = 0 implies aCount > 0
                                : Math.max(A[aCount - 1], B[bCount - 1]);

                if (IsOdd(aLen + bLen))
                {
                    return leftHalfEnd;
                }

                //
                // aLen + bLen is even. To compute the median, we need to find
                // the first element in the right half, which will be the smaller
                // of A[aCount] and B[bCount]. Remember that aCount could be equal
                // to A.Length, bCount could be equal to B.Length (if all the values
                // of A or B are in the left half).
                //
                int rightHalfStart =
                        (aCount == aLen)          // A is all in the left half?
                                ? B[bCount]           // aCount = aLen implies bCount < B.Length
                                : (bCount == bLen)    // B is all in the left half?
                                ? A[aCount]       // bCount = B.Length implies aCount < A.Length
                                : Math.min(A[aCount], B[bCount]);
                return (leftHalfEnd + rightHalfStart) / 2.0;
            }
        }
        return 0.0;
    }


    // The least significant bit of any odd number is 1.
    private static boolean IsOdd(int x) {
        return (x & 1) == 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,7,8};
        int[] arr2 = {6,10,14,15,16,17};
        System.out.println(FindMedianSortedArrays(arr1, arr2));
    }
}