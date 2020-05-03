
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] counter = new int[26];
        
        int magLen = magazine.length();
        for(int i=0;i<magLen;i++){           
            counter[magazine.charAt(i)-'a']++;            
        }
        
        int ransomLen = ransomNote.length();
        for(int i=0;i<ransomLen;i++){
            
            char c = ransomNote.charAt(i);
            
            if(counter[c-'a']>0){
                counter[c-'a']--;
            }
            else{
                return false;
            }
            
        }
        
        return true;
        
    }
}