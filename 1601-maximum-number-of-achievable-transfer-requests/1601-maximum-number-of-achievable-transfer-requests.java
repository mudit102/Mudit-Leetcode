public class Solution {
    int ans = 0;
    int [][] requests;
    
    public int maximumRequests(int n, int[][] requests) {
        this.requests = requests;
        int [] transfers = new int[n];
        backTrack(0, 0,transfers);
        return ans;
    }
    
    public void backTrack(int index, int count, int [] transfers){
        if(index == requests.length){
            for(int i : transfers){
                if(i!=0) return;
            }
            ans = Math.max(ans,count);
            return;
        }
        
        
        transfers[requests[index][0]]--;
        transfers[requests[index][1]]++;
        backTrack(index+1, count+1,transfers);
            
        transfers[requests[index][0]]++;
        transfers[requests[index][1]]--;
        backTrack(index+1, count,transfers);
        
        
    }
}