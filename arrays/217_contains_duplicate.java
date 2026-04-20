/*
 * Problem: Contains Duplicate (LeetCode #217)
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Difficulty: Easy
 * Pattern: HashSet
 *
 * Approach (One-pass HashSet): O(n) time, O(n) space
 *   - For each number, check if already in set
 *   - If yes → duplicate found, return true
 *   - If no → add to set and continue
 *
 * Brute force would be: O(n²) — check every pair
 * Sorting approach: O(n log n) — sort then check adjacent
 * This HashSet approach is optimal — single pass, O(1) lookup
 */

 class Solution {
    public boolean containsDuplicate(int[] nums) {
         /*Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
      */
        Set<Integer> s = new HashSet<>();

        for(Integer n : nums){
            if(s.contains(n))
                return true;
            s.add(n);
        }
        return false;
    }
}
