package p605;
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        boolean[] canPlant = new boolean[length];
        for (int i = 0; i < length; i++) {
            canPlant[i] = flowerbed[i] == 0;
            if (i - 1 >= 0) canPlant[i] &= flowerbed[i - 1] == 0;
            if (i + 1 < length) canPlant[i] &= flowerbed[i + 1] == 0;
        }
        
        int lastNoPlant = 0;
        int lastPlant = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlant[i]) {
//                System.out.println(i + ", can plant");
                int thisPlant = Math.max(lastNoPlant + 1, lastPlant);
                lastNoPlant = Math.max(lastNoPlant, lastPlant);
                lastPlant = thisPlant;
//                System.out.println("after plant " + lastNoPlant + ", " + lastPlant);
            }
            else lastNoPlant = lastPlant = Math.max(lastPlant, lastNoPlant);
        }
        return Math.max(lastPlant, lastNoPlant) >= n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2));
    }
}