/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false*/

class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num == 1) return true;
        
        int half = num/2;
        for(int i=1;i<=half;i++){
            
            if(i * i == num){
                return true;
            }
        }
        return false;
    }
}