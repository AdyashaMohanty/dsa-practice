/*
 * Problem: Make Sum Divisible by P (LeetCode #1590)
 * Link: https://leetcode.com/problems/make-sum-divisible-by-p/
 * Difficulty: Medium
 * Pattern: Prefix Sum + HashMap (Modular Arithmetic)
 *
 * Approach 1 (Brute Force - commented): O(n²) time, O(1) space
 *   - For every subarray, check if (totalSum - subarraySum) % p == 0
 *   - TLE for large inputs
 *
 * Approach 2 (Prefix Sum + HashMap - OPTIMAL): O(n) time, O(n) space
 *   - Find total remainder t = totalSum % p, if t==0 return 0
 *   - We need to remove smallest subarray whose sum % p == t
 *   - At each index, track prefix sum mod p
 *   - Look for a previous prefix where (current - previous) % p == t
 *   - Initialize map with {0:-1} to handle subarrays starting from index 0
 *   - Example: nums=[3,1,4,2], p=6 → t=4
 *              Need subarray with sum%6==4 → [4] at index 2, len=1 ✓
 *
 * Key insight: (ps - t + p) % p gives the remainder we need to have seen
 *              before current index to form a valid removable subarray
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        /*
        // Approach 1: Brute Force
        int n = nums.length;
        int i, j;
        int len = n;
        long tsum = 0, subsum = 0;
        for(int num:nums) tsum += num;
        if(tsum%p==0) return 0;
        for(i=0;i<n;i++){
            subsum = 0;
            for(j=i;j<n;j++){
                subsum += nums[j];
                if((tsum-subsum)%p==0) len = Math.min(len,j-i+1);
            }
        }
        return len==n?-1:len;
        */

        // Approach 2: Prefix Sum + HashMap (Optimal)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int t = 0;
        for(int num:nums) t = (t+num)%p;
        if(t==0) return 0;

        int sum = 0, len = nums.length, rem;
        for(int j=0;j<nums.length;j++){
            sum = (sum+nums[j])%p;
            int ps = (sum+p)%p;
            rem = (ps-t+p)%p;
            if(map.containsKey(rem)) len = Math.min(len,j-map.get(rem));
            map.put(ps,j);
        }
        return len==nums.length?-1:len;
    }
}
