/*You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int len = coordinates.length ;
        
        if(len == 2){
            return true;
        }
        

        int xDiff = (coordinates[0][0]-coordinates[1][0]);
        int yDiff = ((coordinates[0][1]-coordinates[1][1]));
        
   
        int prevSlope = yDiff!=0 ? xDiff / yDiff: Integer.MAX_VALUE;
        
        for(int i=1;i<len-1;i++){
            
            
            int xDiff1 = coordinates[i][0]-coordinates[i+1][0];
            int yDiff1 = coordinates[i][1]-coordinates[i+1][1];
            
            
           int  currentSlope = yDiff1!=0 ? xDiff1/yDiff1 : Integer.MAX_VALUE;
                    
            if(currentSlope != prevSlope){
                return false;
            }
            
            prevSlope = currentSlope;
            
        }
        return true;
    }
}