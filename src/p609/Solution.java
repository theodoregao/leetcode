package p609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] tokens = path.split(" ");
            String dir = tokens[0] + "/";
            for (int i = 1; i < tokens.length; i++) {
                String file = tokens[i];
                String fileName = file.substring(0, file.indexOf("("));
                String content = file.substring(file.indexOf("(") + 1, file.indexOf(")"));
                if (!map.containsKey(content)) map.put(content, new HashSet<String>());
                map.get(content).add(dir + fileName);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (Set<String> set: map.values()) {
            if (set.size() < 2) continue;
            List<String> thisPaths = new ArrayList<>();
            for (String path: set) thisPaths.add(path);
            list.add(thisPaths);
        }
        return list;
    }
}