package collectionsframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("2","l");
        map.put("16","miss");
        map.put("0","you");
        map.put("100","kobe");
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
    }
}
