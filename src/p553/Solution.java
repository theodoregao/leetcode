package p553;
public class Solution {
    
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return Integer.toString(nums[0]);
        else if (nums.length == 2) return nums[0] + "/" + nums[1];
        else {
            StringBuffer sb = new StringBuffer();
            sb.append(nums[0]).append("/").append("(");
            for (int i = 1; i < nums.length - 1; i++) sb.append(nums[i]).append("/");
            sb.append(nums[nums.length - 1]);
            sb.append(")");
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().optimalDivision(new int[] {1000, 10, 100, 200}));
    }
}