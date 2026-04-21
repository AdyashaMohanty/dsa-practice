/*
 * Problem: Majority Element (LeetCode #169)
 * Link: https://leetcode.com/problems/majority-element/
 * Difficulty: Easy
 * Pattern: Sorting
 *
 * Approach (Sorting): O(n log n) time, O(1) space
 *   - Sort the array
 *   - Majority element always lands at index n/2
 *   - Because it appears > n/2 times, it must occupy the middle
 *   - Example: [2,2,1,1,2] → sorted: [1,1,2,2,2] → nums[2] = 2 ✓
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
