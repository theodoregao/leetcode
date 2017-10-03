package p638;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }
    
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i) {
        if (i == special.size()) return dot(price, needs);
        List<Integer> newNeeds = new ArrayList<>();
        for (int j = 0; j < special.get(i).size() - 1; j++) {
            int need = needs.get(j) - special.get(i).get(j);
            if (need < 0) return shopping(price, special, needs, i + 1);
            newNeeds.add(need);
        }
        return Math.min(shopping(price, special, needs, i + 1),
                special.get(i).get(special.get(i).size() - 1) + shopping(price, special, newNeeds, i));
    }
    
    private int dot(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < price.size(); i++) sum += price.get(i) * needs.get(i);
        return sum;
    }
}