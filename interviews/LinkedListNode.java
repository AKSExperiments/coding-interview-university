package interviews;


public class LinkedListNode<K, V> {
    public final K key;
    public V value;
    LinkedListNode<K, V> next;

    public LinkedListNode(K key, V value, LinkedListNode<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
