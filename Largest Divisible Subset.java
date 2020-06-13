/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            return list; 
        
        Arrays.sort(nums);
        
        int[] divCount = new int[nums.length];
        int[] prev = new int[nums.length];
        
        Arrays.fill(divCount, 1);
        Arrays.fill(prev, -1);
        int max_idx = 0;
        int max = 0;
        
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i]%nums[j] == 0 && divCount[i] < divCount[j] + 1){
                    divCount[i] = divCount[j] + 1;
                    prev[i] = j;
                }
            }
            if (divCount[i] > divCount[max_idx]){
                max_idx = i;
                max = divCount[i];
            }        
        }
        
//         for (int i=0; i<divCount.length; i++) {
//             System.out.print(divCount[i] + " ");
//         }
        
        int k = max_idx;
        while (k >= 0){
            list.add(nums[k]);
            k = prev[k];
        }
        
        return list;
    }
}
