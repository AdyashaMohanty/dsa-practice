/*
 * Problem: Missing Number (LeetCode #268)
 * Link: https://leetcode.com/problems/missing-number/
 * Difficulty: Easy
 * Pattern: Math / Bit Manipulation (XOR)
 *
 * Approach 1 (Gauss Formula - commented): O(n) time, O(1) space
 *   - Expected sum of 0..n = n*(n+1)/2
 *   - Actual sum = sum of array
 *   - Missing = expected - actual
 *   - Simple and clean, but XOR is even more robust
 *
 * Approach 2 (XOR - OPTIMAL): O(n) time, O(1) space
 *   - XOR all indices 0..n → xor1
 *   - XOR all array values → xor2
 *   - xor1 ^ xor2 cancels all present numbers
 *   - Only the missing number remains
 *   - Example: [3,0,1] → xor1=0^1^2^3, xor2=3^0^1 → result=2
 *
 * Why XOR beats Gauss: Gauss can overflow for very large n
 * XOR has no overflow risk — always safer in production
 */

class Solution {
    public int missingNumber(int[] nums) {
        /*int s = 0;
        int n = nums.length;

        int sum = (n*(n+1))/2;
        for(int i = 0; i<nums.length;i++){
            s = s + nums[i];
        }
        int missing = sum - s;
        return missing;*/

        int xor1=0;
        for(int i = 0;i<=nums.length;i++){
            xor1 = xor1^i;
        }

        int xor2=0;
        for(int i=0;i<nums.length;i++){
            xor2 = xor2^nums[i];
        }
        int missing = xor1 ^xor2;
        return missing;
    }
}
