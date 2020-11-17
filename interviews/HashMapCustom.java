package interviews;

class HashMapCustom<K, V> {
    private LinkedListNode<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    public HashMapCustom() {
        this(INITIAL_CAPACITY);
    }
    public HashMapCustom(int capacity) {
        buckets = new LinkedListNode[capacity];
    }
    public int getHash(K key) {
        return key.hashCode();
    }
    public int getBucketSize() {
        return this.buckets.length;
    }
    public void put(K key, V value) {
        LinkedListNode<K, V> entry = new LinkedListNode<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        LinkedListNode<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        LinkedListNode<K, V> bucket = buckets[getHash(key) % getBucketSize()];
        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hm = new HashMapCustom<Integer, Integer>(32);
        hm.put(1,2);
        hm.put(3,4);
        hm.put(5,6);
        System.out.println(hm.get(3));
    }
}