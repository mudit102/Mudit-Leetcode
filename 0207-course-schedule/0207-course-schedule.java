class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(n);
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] in=new int[n];
        for(int i=0;i<pre.length;i++)
        {      in[pre[i][1]]++;
                adj.get(pre[i][0]).add(pre[i][1]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(in[i]==0)
            {
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            count++;
            int temp=q.poll();
            for(int i:adj.get(temp))
            {
                in[i]--;
                if(in[i]==0)
                {
                    q.add(i);
                }
            }
        }
        if(count==n) return true;
        return false;
        
    }
}