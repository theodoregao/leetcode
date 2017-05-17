package p582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> killedPid = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new HashSet<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        kill(killedPid, map, kill);
        return killedPid;
    }
    
    private void kill(List<Integer> killedPid, Map<Integer, Set<Integer>> map, int kill) {
        killedPid.add(kill);
        if (!map.containsKey(kill)) return;
        for (int child: map.get(kill)) kill(killedPid, map, child);
    }
}