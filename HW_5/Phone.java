/* Task1.java */

package HW_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {
    private Map<String, List<String>> map;
    
    public Phone() {
        map = new HashMap<>();
    }

    public List<String> getName(String name) {
        if (map.containsKey(name)) return map.get(name);
        return null;
    }

    public Map<String, List<String>> getAll() {
        return map;
    }

    public boolean add(String name, String tel) {
        if (name.isEmpty() || tel.isEmpty()) return false;
        if (map.containsKey(name)) {
            List<String> list = map.get(name);
            if (list.contains(tel)) return false;
            list.add(tel);
        }
        else {
            List<String> list = new ArrayList<>();
            list.add(tel);
            map.put(name, list);
        }
        return true;
    }

    public boolean del(String name, String tel) {
        if (name.isEmpty() || tel.isEmpty()) return false;
        if (map.containsKey(name)) {
            List<String> list = map.get(name);
            if (list.contains(tel)) {
                list.remove(tel);
                if (list.isEmpty()) map.remove(name);
                return true;
            }
        }
        return false;
    }
}
