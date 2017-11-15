import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.Iterator;
import java.util.NoSuchElementException;

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K> { //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    private int sz;

    @Override
    public V get(K key) { //FIX ME
    //FILL ME IN
        return front.get(key).val; //FIX ME
    }

    @Override
    public void put(K key, V val) { //FIX ME
        if (front == null) {
            front = new Entry(key, val, null);
            sz++;
            return;
        }
        Entry ptr = front;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Entry(key, val, null);
        sz++;
    }

    public String toString() {
        Iterator<K> iter = new ULLMapIter();
        String str = "";
        while (iter.hasNext()) {
            str += (Object) iter.next();
        }
        return str;
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
    //FILL ME IN
        if (front == null) return false;
        return (front.get(key) != null); //FIX ME
    }

    @Override
    public int size() {
        return sz; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
    //FILL ME IN
        front = null;
        sz = 0;
    }

    public static <K, V> ULLMap inverse(ULLMap<K, V> og) {
        ULLMap<V, K> newMap = new ULLMap<V, K>();
        Iterator<K> iter = og.iterator();
        while (iter.hasNext()) {
            K temp = iter.next();
            if (!(newMap.containsKey(og.get(temp)))) {
                newMap.put(og.get(temp), temp);
            }
        }
        return newMap;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) { //FIX ME
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
            Entry ptr = front;
            while (ptr != null) {
                if (k.equals(ptr.key)) {
                    return ptr;
                }
                ptr = ptr.next;
            }

            return null; //FIX ME
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry next;
    
    }

    public class ULLMapIter implements Iterator<K> {
        public ULLMapIter() {
            iter = front;
            index = 0;
        }

        public boolean hasNext() {
            return index < sz;
        }

        public K next() {
            K temp;
            if (!hasNext()) throw new NoSuchElementException();
            temp = iter.key;
            index++;
            if (iter.next != null) {
                iter = iter.next;
            }
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /** Position of Iterator variable. **/
        private Entry iter;
        private int index;
    }

    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }


}