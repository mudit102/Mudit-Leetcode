class Solution {
    static int size;
    public static int calc(int idx,int cost[],int time[],int walls,int dp[][]){
        if(walls<=0) return 0;
      if(idx==size){
          if(walls<=0) return 0;
          else return 1000000000;
      }
      // if a paid_painter is occupying a particular wall i , then free painter will occupy some other j walls , where j equals time[i]
      // if hes not occupying the wall then that particular wall will be painted by free painter iff paid_painter occupies another wall
      if(dp[idx][walls]!=-1) return dp[idx][walls];
      int c1=0,c2=0;
      if(walls>0){
          c1=cost[idx]+calc(idx+1,cost,time,walls-time[idx]-1,dp);
      }
      c2=calc(idx+1,cost,time,walls,dp);
      return dp[idx][walls]=Math.min(c1,c2);
    }
    public int paintWalls(int[] cost, int[] time) {
        size=cost.length;
        int dp[][] = new int[size+1][size+1];
        for(int rows[] : dp) {
            Arrays.fill(rows,-1);
        }
        return calc(0,cost,time,size,dp);
    }
}
