/*
 * Problem: Intersection of Two Arrays (LeetCode #349)
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/
 * Difficulty: Easy
 * Pattern: HashSet
 *
 * Approach (Two HashSets): O(n+m) time, O(n+m) space
 *   - Add all nums1 elements into set
 *   - Iterate nums2 — if element exists in set, add to result set
 *   - Result set automatically handles duplicates
 *   - Convert result set to array
 *
 * Why two sets instead of one?
 *   - First set: O(1) lookup for nums1 elements
 *   - Second set: ensures result has no duplicates
 *   - Example: nums1=[1,2,2,1], nums2=[2,2] → result=[2] not [2,2]
 *
 * Alternative: sort both arrays + two pointers → O(n log n) time, O(1) space
 *   - Better space but worse time
 *   - HashSet approach preferred when space is not a constraint
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int i : nums2){
            if(set.contains(i)) s2.add(i);
        }
        int[] res = new int[s2.size()];
        int i=0;
        for(int num : s2){
            res[i]=num;
            i++;
        }
        return res;
    }
}
