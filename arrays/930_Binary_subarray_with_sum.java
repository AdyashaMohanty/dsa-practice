/*
 * Problem: Binary Subarrays With Sum (LeetCode #930)
 * Link: https://leetcode.com/problems/binary-subarrays-with-sum/
 * Difficulty: Medium
 * Pattern: Prefix Sum + HashMap
 *
 * Approach (Prefix Sum + HashMap - OPTIMAL): O(n) time, O(n) space
 *   - Same exact pattern as Subarray Sum Equals K (#560)
 *   - prefixSum - goal = previously seen prefixSum → subarray sums to goal
 *   - Initialize map with {0:1} to handle subarrays starting from index 0
 *   - Example: nums=[1,0,1,0,1], goal=2
 *              ps=1 → ps-2=-1 not found
 *              ps=1 → ps-2=-1 not found
 *              ps=2 → ps-2=0 exists → cnt=1
 *              ps=2 → ps-2=0 exists → cnt=2
 *              ps=3 → ps-2=1 exists (freq=2) → cnt=4 ✓
 *
 * Note: Identical logic to #560 — works because binary array prefix sums
 *       behave the same as general integer array prefix sums
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ps = 0;
        int cnt = 0;
        for(int num:nums){
            ps += num;
            if(map.containsKey(ps-goal)) cnt += map.get(ps-goal);
            map.put(ps, map.getOrDefault(ps,0)+1);
        }
        return cnt;
    }
}
