package p599;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++)
            for (int j = 0; j < list2.length; j++)
                if (list1[i].equals(list2[j])) {
                    if (minSum > i + j) {
                        list.clear();
                        minSum = i + j;
                        list.add(list1[i]);
                    }
                    else if (minSum == i + j) list.add(list1[i]);
                }
        String[] restaurants = new String[list.size()];
        for (int i = 0; i < list.size(); i++) restaurants[i] = list.get(i);
        return restaurants;
    }
}