package p423;
public class Solution {
    public String originalDigits(String s) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) counts[c - 'a']++;
        int[] nums = new int[10];
        nums[0] = counts['z' - 'a'];
        nums[2] = counts['w' - 'a'];
        nums[4] = counts['u' - 'a'];
        nums[6] = counts['x' - 'a'];
        nums[8] = counts['g' - 'a'];
        nums[3] = counts['h' - 'a'] - nums[8];
        nums[1] = counts['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[7] = counts['s' - 'a'] - nums[6];
        nums[5] = counts['v' - 'a'] - nums[7];
        nums[9] = (counts['n' - 'a'] - nums[1] - nums[7]) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
        	for (int j = 0; j < nums[i]; j++)
        		sb.append(i);
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().originalDigits("onetwotwothreethreethreefourfourfourfourfivefivefivefivefivesixsixsixsixsixsixsevensevensevensevensevensevenseveneighteighteighteighteighteighteighteightninenineninenineninenineninenineninezerozerozerozerozerozerozerozerozerozero"));
	}
}