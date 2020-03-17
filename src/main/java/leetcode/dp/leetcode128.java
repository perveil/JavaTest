package leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode128 {
    public int dp_longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int[] dp=new int[nums.length]; //dp[i]以nums[i]为末尾的连续数组的长度
        dp[0]=1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i-1]==nums[i]-1){
                dp[i]=dp[i-1]+1;
            }else if (nums[i]==nums[i-1]){
                dp[i]=dp[i-1];
            }
            res= Math.max(res,dp[i]);
        }
        return res;
    }
    public int col_longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) { // O(1)存取，不往前看，往后看
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        new leetcode128().col_longestConsecutive(
                new int[]{
                        0,1,2,1
                }
        );
    }
}
