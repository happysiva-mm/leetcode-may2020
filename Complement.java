/*

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Note:

The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
*/

class Solution {
    public int findComplement(int num) {
        
        //Find the highest set bit position eg : for 3 it be 2 , for 2 it will be 2 
        //for 4 it will be 3 - 100
        
        int numberOfBits = (int)Math.floor(Math.log(num)/Math.log(2)) + 1;

        /*
(1 << numberOfBits) - This will set 1 before the highest set bit.
eg if higest set bit is at position 3 , then 1 will be moved to position 4.
Now -1 will flip all the bits that are after the rightmost set bit
so position 4 is flipped as 0 and the one after it is flipped so position 3to 1 will be
111 so now xor both , it will give the compliment .
[Brian Kernighan’s Algorithm]
        */
       
        
       return(((1 << numberOfBits) - 1) ^ num); 
        
       // return num ^ numberToXOR;
        
        
    }
}