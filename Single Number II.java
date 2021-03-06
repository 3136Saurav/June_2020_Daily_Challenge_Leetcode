/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/


class Solution {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
            
//             System.out.println("Key = " + entry.getKey() + 
//                              ", Value = " + entry.getValue()); 
        }
            
        return 1;
    }
}
