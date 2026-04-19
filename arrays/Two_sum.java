/*
 * Problem: Two Sum (LeetCode #1)
 * Link: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * Pattern: HashMap
 *
 * Approach 1 (Brute Force - commented): O(n²) time, O(1) space
 *   - Check every pair (i, j) — too slow for large inputs
 *
 * Approach 2 (Two-pass HashMap - commented): O(n) time, O(n) space
 *   - First pass: store all values in map
 *   - Second pass: look up complement for each number
 *
 * Approach 3 (One-pass HashMap - OPTIMAL): O(n) time, O(n) space
 *   - As we iterate, check if complement already seen
 *   - If yes, found our answer. If no, add current to map
 *   - Better than approach 2 — single loop, finds answer immediately
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        int i, j;
        int n = nums.length;

        for(i=0;i<n-1;i++){
            for(j=i+1;j<n;j++){
                if(nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1, -1};

        int i,j;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(i=0;i<n;i++){
            map.put(nums[i],i);
        }

        for(i=0;i<n;i++){
            int req = target - nums[i];
            if(map.containsKey(req) && map.get(req)!=i)
                return new int[]{i,map.get(req)};
        }

        return new int[]{-1,-1};*/

       Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];
            if (map.containsKey(req)) {
                return new int[]{map.get(req), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
     
    }
}
