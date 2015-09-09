
package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implement a hash map using only arrays. The hash map will map strings to strings.
 * @author kipsu
 */
public class HashMap {
    
    private String[][] values;
    
    public HashMap() {
        values = new String[500000][];
    }
    
    public void put(String key, String value) {
        int bucket = key.hashCode() % 500000;
        if (values[bucket] == null) {
            values[bucket] = new String[100];
        }
        int i = 0;
        while (values[bucket][i] != null) {
            if (i % 2 == 0 && values[bucket][i].equals(key)) {
                break;
            }
            i++;
            if (i == values[bucket].length) {
                values[bucket] = Arrays.copyOf(values[bucket], values[bucket].length * 10);
            }
        }
        values[bucket][i] = key;
        values[bucket][i + 1] = value;
    }
    
    public boolean containsKey(String key) {
        return values[key.hashCode() % 500000] != null;
    }
    
    public boolean containsValue(String value) {
        for (int i = 0; i < 500000; i++) {
            if (values[i] != null) {
                for (String storedValue : values[i]) {
                    if (storedValue == null) {
                        break;
                    }
                    if (storedValue.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public String get(String key) {
        String[] mappings = values[key.hashCode() % 500000];
        for (int i = 0; i < mappings.length; i+=2) {
            if (mappings[i].equals(key)) {
                return mappings[i + 1];
            }
        }
        return null;
    }
    
    public List<String> keySet() {
        List<String> keySet = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            if (values[i] != null) {
                for (int j = 0; j < values[i].length; j+=2) {
                    if (values[i][j] == null) {
                        break;
                    }
                    keySet.add(values[i][j]);
                }
            }
        }
        return keySet;
    }
    
    public List<String> values() {
        List<String> valueSet = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            if (values[i] != null) {
                for (int j = 1; j < values[i].length; j+=2) {
                    if (values[i][j] == null) {
                        break;
                    }
                    valueSet.add(values[i][j]);
                }
            }
        }
        return valueSet;
    }
    
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("foo", "bar");
        map.put("bar", "baz");
        map.put("bar", "jakkara");
        
        System.out.println(map.get("foo"));
        System.out.println(map.get("bar"));
        System.out.println();
        
        System.out.println(map.containsKey("foo"));
        System.out.println(map.containsKey("baz"));
        System.out.println(map.containsValue("bar"));
        System.out.println(map.containsValue("baz"));
        System.out.println();
        
        List<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print(key + ", ");
        }
        System.out.println();
        
        List<String> values = map.values();
        for (String value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
