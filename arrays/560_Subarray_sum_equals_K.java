/*
 * Problem: Subarray Sum Equals K (LeetCode #560)
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * Difficulty: Medium
 * Pattern: Prefix Sum + HashMap
 *
 * Approach (Prefix Sum + HashMap - OPTIMAL): O(n) time, O(n) space
 *   - At each index, prefixSum - k = a previously seen prefixSum
 *     → means subarray between that index and current sums to k
 *   - HashMap stores frequency of each prefixSum seen so far
 *   - Initialize map with {0:1} to handle subarrays starting from index 0
 *   - Example: nums=[1,2,3], k=3
 *              ps=1 → map={0:1,1:1}
 *              ps=3 → ps-k=0 exists → cnt=1, map={0:1,1:1,3:1}
 *              ps=6 → ps-k=3 exists → cnt=2 ✓
 *
 * Key insight: map.put(0,1) handles the case where prefix sum itself equals k
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ps = 0, cnt = 0;
        for(int num: nums){
            ps += num;
            if(map.containsKey(ps-k)) cnt += map.get(ps-k);
            map.put(ps, map.getOrDefault(ps,0)+1);
        }
        return cnt;
    }
}
