/**
 * LeetCode 350 - Intersection of Two Arrays II
 *
 * Given two integer arrays nums1 and nums2, return their intersection.
 * Each element must appear as many times as it shows in both arrays.
 *
 * Approach 1 (commented): Sort + Two Pointers — O(n log n + m log m) time, O(1) space
 *                          Use when arrays are already sorted or memory is tight.
 *
 * Approach 2 (active):    HashMap frequency count — O(n+m) time, O(min(n,m)) space
 *                          Use when arrays are unsorted and fit in memory.
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i,j;
        int n= nums1.length;
        int m = nums2.length;
        
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        i=0;j=0;
        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                arr.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }

        int[] res = new int[arr.size()];
        for(i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }

        return res;*/

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int num: nums2){
            if(map.getOrDefault(num,0)>0){
                arr.add(num);
                map.put(num, map.getOrDefault(num,0)-1);
            }
        }
        int[] res = new int[arr.size()];
        for(i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}
