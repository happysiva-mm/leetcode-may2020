/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N*/




class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] eachPerson = new int[N+1];
        
        for(int i=1;i<=N;i++){
            eachPerson[i] = 0;
        }
        
        int matrixLength = trust.length;
        HashMap<Integer,ArrayList<Integer>> trusterVsTrustees = new HashMap<Integer,ArrayList<Integer>>();
        
        for(int i=0;i<matrixLength;i++){
            
            int trustee = trust[i][1];
            int truster = trust[i][0];
            //System.out.println("Truster :"+truster+":: trustee :"+trustee);
            if(truster!=trustee){
                eachPerson[truster] = 1;
            }
            
            if(trusterVsTrustees.containsKey(truster)){
                trusterVsTrustees.get(truster).add(trustee);
            }
            else{
                
                ArrayList<Integer> trusteeList = new ArrayList<Integer>();
                trusteeList.add(trustee);
                trusterVsTrustees.put(truster,trusteeList);
            }
        }
        
        int candidate = getCandidate(N,eachPerson);
        System.out.println(candidate);
        if(candidate!=-1){
            
            for (Map.Entry mapElement : trusterVsTrustees.entrySet()) { 
            Integer key = (Integer)mapElement.getKey(); 
                ArrayList<Integer> trustees = trusterVsTrustees.get(key);
                if(!trustees.contains(candidate)){
                    candidate = -1;
                   break;
                }
               
            }
            
        }
        
        
        return candidate;
        
    }
    
    static int getCandidate(int N , int[] eachPerson){
        boolean isCandidateFound = false;
        int index = -1;
        for(int i=1;i<=N;i++){
            System.out.println(eachPerson[i]);
            if(eachPerson[i] == 0){
                if(isCandidateFound){
                    return -1;
                }
                
                isCandidateFound = true;
                index = i;
               
            }
        }
        return index;
    }
}