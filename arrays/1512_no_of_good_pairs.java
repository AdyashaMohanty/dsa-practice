/*
 * Problem: Number of Good Pairs (LeetCode #1512)
 * Link: https://leetcode.com/problems/number-of-good-pairs/
 * Difficulty: Easy
 * Pattern: HashMap + Combinatorics
 *
 * Approach: O(n) time, O(n) space
 *   - Count frequency of each number using HashMap
 *   - For each frequency, count pairs using combination formula: nC2 = n*(n-1)/2
 *   - If freq > 1, those elements can form freq*(freq-1)/2 good pairs
 *   - Example: [1,2,3,1,1,3] → freq: {1:3, 2:1, 3:2} → 3C2 + 2C2 = 3+1 = 4
 */


class Solution {
    public int comb(int n, int r){
        return (n*(n-1))/2;
    }
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int res = 0;
        for(int freq : map.values()){
            if(freq > 1){
                res = res + comb(freq,2);
            }
        }
        return res;
    }
}
