/*
 * Problem: Single Number (LeetCode #136)
 * Link: https://leetcode.com/problems/single-number/
 * Difficulty: Easy
 * Pattern: Bit Manipulation (XOR)
 *
 * Approach 1 (HashMap - commented): O(n) time, O(n) space
 *   - Count frequency of each number
 *   - Return the one with frequency 1
 *
 * Approach 2 (XOR - OPTIMAL): O(n) time, O(1) space
 *   - XOR properties:
 *     a ^ a = 0  (same number cancels out)
 *     a ^ 0 = a  (zero doesn't change number)
 *     XOR is commutative and associative
 *   - So XOR-ing all numbers → pairs cancel → only single remains
 *   - Example: [4,1,2,1,2] → 4^1^2^1^2 = 4^(1^1)^(2^2) = 4^0^0 = 4
 *
 * Why XOR beats HashMap: O(1) space, no extra data structure needed
 */

class Solution {
    public int singleNumber(int[] nums) {
        int i;
        /*Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(int n : nums){
            if(map.get(n)==1)
                return n;
        }
        return -1;

        */
        int xor = 0;
        for(i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;

    }
}
