package interviews;

public class MaxHeap {
    // heap array
    // current size
    // max possible size
    int[] Heap;
    int size;
    int max_size;

    // set max size
    // initialize with 0th index as integer maximum
    public MaxHeap(int size) {
        Heap = new int[size+1];
        this.max_size = size;
        this.size = 0;
        Heap[0] = Integer.MAX_VALUE;
    }

    // utility functions
    // getParent
    // getLeftChild
    // getRightChild
    public int getParent(int currIndex) {
        return currIndex/2;
    }

    public int getLeftChild(int currIndex) {
        return 2*currIndex;
    }

    public int getRightChild(int currIndex) {
        return 2*currIndex + 1;
    }

    public void swap(int pos1, int pos2) {
        int temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }

    // insert
    // always insert at the end of the array or leaf node
    // max heap logic - check if parents are less than the node, yes, ok, else, swap, continue recursively
    public void insert(int val) {
        if(size + 1 < max_size) {
            Heap[++size] = val;
            maxHeapify(size);
        }
    }

    public void maxHeapify(int pos) {
        if(pos == 1) {
            return;
        }
        if(Heap[getParent(pos)] < Heap[pos]) {
            swap(pos, getParent(pos));
            maxHeapify(getParent(pos));
        }
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // delete
    // max heap delete is from the top, place on back
    // and then verify which of the child nodes are greater in value
    // place that on root, and then repeat the above process for the subtree that just lost it's root
    public void heapify(int pos) {
        if(Heap[pos] >= Heap[getLeftChild(pos)] && Heap[pos] >= Heap[getRightChild(pos)]) {
            return;
        }
        if(Heap[getLeftChild(pos)] > Heap[getRightChild(pos)]) {
            swap(pos, getLeftChild(pos));
            heapify(getLeftChild(pos));
        } else {
            swap(pos, getRightChild(pos));
            heapify(getRightChild(pos));
        }
    }
    public void delete() {
        swap(1, size);
        size--;
        heapify(1);
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(128);
        mh.insert(10);
        mh.insert(30);
        mh.insert(20);
        mh.insert(40);
        mh.insert(70);
        mh.insert(50);
        mh.insert(60);
        for(int i = 1; i <= mh.size; i++) {
            System.out.println( i + "=>" + mh.Heap[i]);
        }
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        for(int i = 1; i <= mh.size; i++) {
            System.out.println( i + "=>" + mh.Heap[i]);
        }
    }
}