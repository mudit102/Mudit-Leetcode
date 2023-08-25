class Solution {
    public boolean recursion(int indx1,int indx2,int indx3,String s1,String s2,String s3,int[][][] dp){
        if(indx3==s3.length()) 
        {
            if(indx1==s1.length() && indx2==s2.length())
                return true;
            else
                return false;
        }

        if(dp[indx1][indx2][indx3]!=-1) return dp[indx1][indx2][indx3]==1?true:false;
        boolean first=false,second=false;
        if(indx1<s1.length() && s1.charAt(indx1)==s3.charAt(indx3))
            first = recursion(indx1+1,indx2,indx3+1,s1,s2,s3,dp);
        if(indx2<s2.length() && s2.charAt(indx2)==s3.charAt(indx3))
            second = recursion(indx1,indx2+1,indx3+1,s1,s2,s3,dp);
        
        dp[indx1][indx2][indx3] = (first||second)?1:0;
        return first || second;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][]dp =new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recursion(0,0,0,s1,s2,s3,dp);
    }
}