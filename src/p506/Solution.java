package p506;

import java.util.Arrays;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Athlete[] athletes = new Athlete[nums.length];
        for (int i = 0; i < nums.length; i++) athletes[i] = new Athlete(i, nums[i]);
        Arrays.sort(athletes);
        String[] medals = new String[nums.length];
        if (medals.length > 0) medals[athletes[0].index] = "Gold Medal";
        if (medals.length > 1) medals[athletes[1].index] = "Silver Medal";
        if (medals.length > 2) medals[athletes[2].index] = "Bronze Medal";
        for (int i = 3; i < athletes.length; i++) {
            medals[athletes[i].index] = (i + 1) + "";
        }
        return medals;
    }
    
    static class Athlete implements Comparable<Athlete> {
        int index;
        int score;
        
        public Athlete(int index, int score) {
            this.index = index;
            this.score = score;
        }
        
        @Override
        public int compareTo(Athlete other) {
            return other.score - score;
        }
    }
}