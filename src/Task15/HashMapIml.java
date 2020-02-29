package Task15;

import sun.security.x509.OtherName;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;

public class HashMapIml<K, V> implements Map<K, V> {
    private int size = 0;
    private int capacity = 0;
    private Entry<K, V>[] array = new Entry[capacity];

    public HashMapIml() {
    }

    public HashMapIml(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key != null) {
            int hash = Math.abs(key.hashCode()) % capacity;
            if (array[hash] != null) {
                Entry<K, V> current = array[hash];
                while (current != null) {
                    if (current.key.equals(key)) {
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (array[i] != null) {
                Entry<K, V> current = array[i];
                while (current != null) {
                    if (current.value.equals(value)) {
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    // added NullPointerException
    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException();
        } else {
            int hash = Math.abs(key.hashCode()) % capacity;
            if (array[hash] != null) {
                Entry current = array[hash];
                while (true) {
                    if (current == null) {
                        return null;
                    }
                    if (current.key.equals(key)) {
                        return (V) current.value;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    // added NullPointerException
    @Override
    public V put(K key, V value) {
        if (key == null) {
          throw new NullPointerException();
        } else {
            if (capacity == 0) {
                array = new Entry[10];
                capacity = 10;
            }
            Entry<K, V> entry = new Entry(key, value);
            int hash = Math.abs(entry.key.hashCode()) % capacity;
            if (array[hash] == null) {
                array[hash] = entry;
            } else {
                Entry<K, V> current = array[hash];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = entry;
            }
            size++;
        }
        return value;
    }

    // added NullPointerException
    @Override
    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException();
        } else  {
            int hash = Math.abs(key.hashCode()) % capacity;
            if (array[hash] != null) {
                Entry<K, V> current = array[hash];
                V value = current.value;
                if (current.next == null) {
                    if (current.key.equals(key)) {
                        current = null;
                        size--;
                        return value;
                    }
                } else {
                    while (current.next != null) {
                        if (current.next.key.equals(key)) {
                            current.next = current.next.next;
                            size--;
                            break;
                        }
                        current = current.next;
                    }
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (capacity != 0) {
            Set mapInputSet = m.entrySet();
            for (Object o : mapInputSet) {
                Object key = ((Map.Entry) o).getKey();
                Object value = ((Map.Entry) o).getValue();
                put((K) key, (V) value);
                size++;
            }
        }
    }

    @Override
    public void clear() {
        array = new Entry[0];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet();
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> current = array[i];
            while (current != null) {
                keySet.add(current.key);
                current = current.next;
            }
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList();
        for (int i = 0; i < capacity; i++) {
            if (array[i] != null) {
                Entry<K, V> current = array[i];
                while (current != null) {
                    values.add(current.value);
                    current = current.next;
                }
            }
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (array[i] != null) {
                Entry<K, V> current = array[i];
                while (current != null) {
                    entrySet.add((Map.Entry<K, V>) current);
                    current = current.next;
                }
            }
        }
        return entrySet;
    }

    public void print() {
        if (capacity != 0) {
            for (int i = 0; i < capacity; i++) {
                if (array[i] != null) {
                    Entry current = array[i];
                    while (current != null) {
                        System.out.println(current);
                        current = current.next;
                    }
                }
            }
        }
    }

    public void resize(int newCapacity) {
        if (newCapacity > capacity) {
            Entry[] newArray = new Entry[newCapacity];
            for (int i = 0; i < capacity; i++) {
                if (array[i] != null) {
                    Entry current = array[i];
                    while (current != null) {
                        Object key = current.key;
                        Object value = current.value;
                        Entry entry = new Entry(key, value);
                        int hash = Math.abs(entry.key.hashCode()) % newCapacity;
                        if (newArray[hash] == null) {
                            newArray[hash] = entry;
                        } else {
                            Entry newCurrent = newArray[hash];
                            while (newCurrent.next != null) {
                                newCurrent = newCurrent.next;
                            }
                            newCurrent.next = entry;
                        }
                        current = current.next;
                    }
                }
            }
            capacity = newCapacity;
            array = newArray;
        }
    }

    class Entry<K, V> {
        private K key;
        private V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{[" + Math.abs(key.hashCode()) % size + "]" + " key, " + value + "}";
        }
    }
}
