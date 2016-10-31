package homework.lab9;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by artem on 01.11.2016.
 */
public class IndexOne2N implements Serializable, IndexBase {
    private static final long serialVersionUID = 1L;
    private TreeMap<String, long[]> map;

    public IndexOne2N() {
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

    public void put(String keys, String keyDelimiter, long value) {
        for (String key : keys.split(keyDelimiter)) {
            put(key.trim(), value);
        }
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
