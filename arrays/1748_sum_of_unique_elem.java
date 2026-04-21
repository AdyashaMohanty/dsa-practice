/*
 * Problem: Sum of Unique Elements (LeetCode #1748)
 * Link: https://leetcode.com/problems/sum-of-unique-elements/
 * Difficulty: Easy
 * Pattern: Frequency Array
 *
 * Approach 1 (HashMap - commented): O(n) time, O(n) space
 *   - Count frequency of each number using HashMap
 *   - Sum all keys with frequency == 1
 *
 * Approach 2 (Frequency Array - OPTIMAL): O(n) time, O(1) space
 *   - Since constraints say 1 <= nums[i] <= 100, use fixed size array of 101
 *   - Count frequency using index as the number itself
 *   - Sum all indices with frequency == 1
 *   - Example: [1,2,3,2] → freq[1]=1, freq[2]=2, freq[3]=1 → sum = 1+3 = 4
 *
 * Why Frequency Array beats HashMap: O(1) space, no extra data structure needed
 */

class Solution {
    public int sumOfUnique(int[] nums) {
        /*
        // Approach 1: HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key= entry.getKey();
            int value = entry.getValue();
            if(value==1)
                sum = sum + key;
        }
        return sum;
        */

        // Approach 2: Frequency Array (Optimal)
        int sum=0;
        int[] freq = new int[101];
        for(int num : nums){
            freq[num]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==1)
                sum = sum + i;
        }
        return sum;
    }
}
