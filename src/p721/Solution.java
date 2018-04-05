package p721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    private class UnionFind {
        private int[] ids;
        private int[] sizes;
        
        public UnionFind(int n) {
            ids = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
                sizes[i] = 1;
            }
        }
        
        public int find(int p) {
            if (ids[p] == p) return p;
            else return ids[p] = find(ids[p]);
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (sizes[i] > sizes[j]) {
                ids[j] = i;
                sizes[i] += sizes[j];
            }
            else {
                ids[i] = j;
                sizes[j] += sizes[i];
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        Map<String, Integer> emailToIds = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
//            System.out.println("account: " + i + ": " + account.get(0));
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
//                System.out.println("email: " + email);
                if (emailToIds.containsKey(email)) {
//                    System.out.println("union: " + i + " - " + emailToIds.get(email));
                    unionFind.union(i, emailToIds.get(email));
                }
                else {
//                    System.out.println(email + " -> " + i);
                    emailToIds.put(email, i);
                }
            }
        }
        
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email: emailToIds.keySet()) {
            int account = unionFind.find(emailToIds.get(email));
            if (!map.containsKey(account)) map.put(account, new ArrayList<String>());
            map.get(account).add(email);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Integer account: map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(account).get(0));
            List<String> emails = map.get(account);
            Collections.sort(emails);
            list.addAll(emails);
            result.add(list);
        }
        return result;
    }
}