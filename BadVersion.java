/*
Date : May 1 2020 
Question :
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 

*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            
           return search_opt(1,n);
            
        }
        
        int search_opt(int start,int end){
            
            /*
            This is important , if we use (start+end)/2,
            then overflow will occur .
            */
            int mid = start+ (end-start)/2;
           
            //If mid is first element then that is the bad version
            if(mid == 1 && isBadVersion(mid)){
                return mid;
            }
            else{
                
                //if it is in some other place , we will check before version
                //if that is good and this is bad then this is bad 
                //Note after a version all are bad so this bad doesnt mean this is the first
                //bad version , hence check whether before one is true.
                if(isBadVersion(mid) && !isBadVersion(mid-1)){
                    return mid;
                }
                
                else{
                    
                    //If we have encountered the bad version , then first bad version
                    //exist before that
                    if(isBadVersion(mid)){
                        return search_opt(start,mid-1);
                    }
                    //If we havent encountered bad version yet , then it should be
                    //in the upcoming index so search in right side .
                    else{
                        return search_opt(mid+1,end);
                    }
                    
                }
                
                
            }
            
          //  return -1;
            
        }
        
       
        int search(int n){
            
            for(int i=1;i<n;i++){
                
                if(isBadVersion(i)){
                    return i;
                }
            }
            
            return -1;
            
        }
    }
