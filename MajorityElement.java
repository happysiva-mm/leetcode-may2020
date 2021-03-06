/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2*/

class Solution {
    public int majorityElement(int[] nums) {
        
        int length = nums.length;
        int threshold = (int)Math.ceil(length/2);
       // System.out.println(threshold+"---");
        HashMap<Integer,Integer> valueVsIndex = new  HashMap<Integer,Integer>();
        
        for(int i=0;i<length;i++){
            int value = 1;
            if(valueVsIndex.containsKey(nums[i])){
                 value = valueVsIndex.get(nums[i]);
                value++;
                            
                
            }
            if(value > threshold){
                    return nums[i];
                }  
            valueVsIndex.put(nums[i],value);
        }
        
        return -1;
    }
}