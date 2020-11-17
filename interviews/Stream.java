import java.util.Map;
import java.util.TreeMap;

public class Stream {
    public static TreeMap<Integer, Integer> hist = new TreeMap<>();
    public static int count = 0;
    public static double mean = 0;

    public static void addToHist(int num) {
        if(hist.containsKey(num)) {
            hist.put(num, hist.get(num) + 1);
        } else {
            hist.put(num, 1);
        }
        mean = ((mean*count) + num)/(count+1);
        count++;
    }

    public static double getMean() {
        return mean;
    }

    public static int getMedian() {
        int med_count = ((count-1)/2)+1;
        int median = Integer.MIN_VALUE;
        for (Map.Entry mapElement : hist.entrySet()) {
            int key = (int) mapElement.getKey();
            int value = (int) mapElement.getValue();
            med_count = med_count - value;
            if (med_count <= 0) {
                if(median != Integer.MIN_VALUE) {
                    median = (median + key)/2;
                } else {
                    median = key;
                }
                break;
            } else if (med_count == 0.5) {
                median = key;
            }
        }
        return median;
    }

    public static void main(String[] args) {
        addToHist(1);
        addToHist(1);
        addToHist(1);
        addToHist(2);
        addToHist(3);
        addToHist(3);
        addToHist(3);
        System.out.println(getMean());
        System.out.println(getMedian());
        addToHist(4);
        addToHist(5);
        addToHist(6);
        System.out.println(getMean());
        System.out.println(getMedian());
    }
}
