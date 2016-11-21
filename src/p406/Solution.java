package p406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        People[] sortedPeople = new People[people.length];
        for (int i = 0; i < n; i++) sortedPeople[i] = new People(people[i][0], people[i][1]);
        Arrays.sort(sortedPeople);
        
        LinkedList<People> ppls = new LinkedList<Solution.People>();
        for (People ppl: sortedPeople) ppls.add(ppl.count, ppl);
        
        int[][] rst = new int[people.length][2];
        n = 0;
        for (People ppl: ppls) {
            rst[n][0] = ppl.height;
            rst[n++][1] = ppl.count;
        }
        return rst;
    }
    
    private static class People implements Comparable<People> {
        int height;
        int count;
        
        public People(int height, int count) {
            this.height = height;
            this.count = count;
        }

        @Override
        public int compareTo(People ppl) {
         // reverse order in height
            int deltaHeight = ppl.height - height;
         // order in count
            return deltaHeight == 0 ? count - ppl.count : deltaHeight;
        }
    }
    
}