/*
 * Problem: Unique Number of Occurrences (LeetCode #1207)
 * Link: https://leetcode.com/problems/unique-number-of-occurrences/
 * Difficulty: Easy
 * Pattern: HashMap + HashSet
 *
 * Approach: O(n) time, O(n) space
 *   - Count frequency of each number using HashMap
 *   - Check if all frequencies are unique using HashSet
 *   - If a frequency already exists in set → return false
 *   - Example: [1,2,2,1,1,3] → freq: {1:3, 2:2, 3:1} → all unique → true
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> s = new HashSet<>();
        
        for(int freq : map.values()){
            if(s.contains(freq))
                return false;
            s.add(freq);
        }
        return true;
    }
}
