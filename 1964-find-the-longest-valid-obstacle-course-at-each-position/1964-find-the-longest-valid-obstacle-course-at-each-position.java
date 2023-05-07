class Solution {
  int LCS[];
  int last_id = 0;

  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    int ans[] = new int[obstacles.length];
    LCS = new int[obstacles.length + 1];
    
    for(int i = 0; i != obstacles.length; ++i)
      ans[i] = embedIntoLCS(obstacles[i]);

    return ans;
  }

  private int embedIntoLCS(int n){
    if(LCS[last_id] <= n){
      LCS[++last_id] = n;
      return last_id;
    }
    
    int l = 0, r = last_id;

    while(l <= r){
      int m = (l+r)>>1;
      if(LCS[m] <= n) l = m + 1;
      else            r = m - 1;
    }

    LCS[l] = n; 
    if(l > last_id) last_id = l;
    return l;
  }
}
