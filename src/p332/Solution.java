package p332;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    
    private Map<String, PriorityQueue<String>> flights;
    private LinkedList<String> path;
    
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<String, PriorityQueue<String>>();
        path = new LinkedList<String>();
        
        for (String[] ticket: tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("JFK");
        return path;
    }
    
    private void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
                dfs(arrivals.poll());
        path.addFirst(departure);
    }
}