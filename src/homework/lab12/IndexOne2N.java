package homework.lab12;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

class IndexOne2N implements Serializable, IndexBase {
    private static final long serialVersionUID = 1L;
    private TreeMap<String, long[]> map;

    IndexOne2N() {
        map = new TreeMap<>();
    }

    @Override
    public String[] getKeys(Comparator<String> comparator) {
        String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
        Arrays.sort(keys, comparator);
        return keys;
    }

    @Override
    public void put(String key, long value) {
        long[] array = map.get(key);
        array = array != null ?
                Index.InsertValue(array, value) :
                new long[] { value };
        map.put(key, array);
    }

    @Override
    public boolean contains(String key) {
        return map.containsKey(key);
    }

    @Override
    public long[] get(String key) {
        return map.get(key);
    }
}
