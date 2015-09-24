package leetcode.google.p251;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Theodore
 *
 *  简单题，注意下下标就好
 */
public class Vector2D {
    
    private List<List<Integer>> vec2d;
    int size, curIndex;
    int row, col;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        curIndex = 0;
        for (int i = 0; i < vec2d.size(); i++) {
            size += vec2d.get(i).size();
            if (curIndex <= 0 && size > 0) {
                curIndex = 1;
                row = i;
                col = 0;
            }
        }
    }

    public int next() {
        int value = vec2d.get(row).get(col);
        increaseIndex();
        return value;
    }

    public boolean hasNext() {
        return curIndex > 0 && curIndex <= size;
    }
    
    private void increaseIndex() {
        curIndex++;
        col++;
        while (row < vec2d.size() && col >= vec2d.get(row).size()) {
            col -= vec2d.get(row).size();
            row++;
        }
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
        vec2d.add(new ArrayList<Integer>());
        vec2d.add(new ArrayList<Integer>(Arrays.asList(1)));
        vec2d.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        vec2d.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        vec2d.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        vec2d.add(new ArrayList<Integer>());
        vec2d.add(new ArrayList<Integer>(Arrays.asList(1)));
        
        Vector2D vector2d = new Vector2D(vec2d);
        while (vector2d.hasNext()) System.out.println(vector2d.next());
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */