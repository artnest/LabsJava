package homework.lab12;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class IndexOne2One implements Serializable, IndexBase {
    private static final long serialVersionUID = 1L;
    private TreeMap<String, Long> map;

    public IndexOne2One() {
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
        map.put(key, value);
    }

    @Override
    public boolean contains(String key) {
        return map.containsKey(key);
    }

    @Override
    public long[] get(String key) {
        long pos = map.get(key);
        return new long[] { pos };
    }
}
