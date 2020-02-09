package Task15;

import java.util.*;

public class HashMapIml implements Map {
    private int size = 0;
    private Entry[] array = new Entry[size];

    public HashMapIml() {
    }

    public HashMapIml(int size) {
        this.size = size;
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
        int hash = Math.abs(key.hashCode()) % size;
        return array[hash] != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                Entry current = array[i];
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

    @Override
    public Object get(Object key) {
        int hash = Math.abs(key.hashCode()) % size;
        if (array[hash] != null) {
            Entry current = array[hash];
            while (true) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                if (current == null) {
                    return null;
                }
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (size == 0) {
            array = new Entry[100];
            size = 100;
        }
        Entry entry = new Entry(key, value);
        int hash = Math.abs(entry.key.hashCode()) % size;
        if (array[hash] == null) {
            array[hash] = entry;
        } else {
            Entry current = array[hash];
            while (current.next != null) {
                current = current.next;
            }
            current.next = entry;
        }
        return true;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {
        if (size != 0) {
            Set mapInputSet = m.entrySet();
            for (Object o : mapInputSet) {
                Object key = ((Map.Entry) o).getKey();
                Object value = ((Map.Entry) o).getValue();
                put(key, value);
            }
        }
    }

    @Override
    public void clear() {
        array = new Entry[0];
    }

    @Override
    public Set keySet() {
        Set ketSet = new HashSet();
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                keySet().add(array[i].key);
            }
        }
        return keySet();
    }

    @Override
    public Collection values() {
        Collection values = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                values.add(array[i].value);
            }
        }
        return values;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> entrySet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                entrySet.add(array[i]);
            }
        }
        return entrySet;
    }

    public void print() {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
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

    /*public void resize(int newSize) {
        HashMapIml newMap = new HashMapIml(newSize);
        if (newSize > size) {
            for (int i = 0; i < size; i++) {
                if (array[i] != null) {
                    Object key = array[i].key;
                    Object value = array[i].value;
                    newMap.put(key, value);
                }
            }
            size = newSize;
            array = newMap.array;
        }
    }*/

    private class Entry {
        private Object key;
        private Object value;
        Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{[" + Math.abs(key.hashCode()) % size + "]" + " key, " + value + "}";
        }
    }
}
