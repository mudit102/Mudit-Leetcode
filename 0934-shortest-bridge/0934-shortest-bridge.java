class Solution {
    
    public void bfs(int[][] grid, int[][] vis, int i, int j, int time ,Set<Pair<Integer,Integer>> first, Set<Pair<Integer,Integer>> second){
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        q.offer(new Pair(i,j));
        vis[i][j] = 1;
        int n = grid.length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while( !q.isEmpty() ){
            int r = q.peek().getKey(), c = q.peek().getValue();
            q.poll();
            
            for(int ii = 0 ; ii <4; ii++){
                int nr = r+dr[ii], nc = c+dc[ii];
//                 nr, nc are valid in grid, i.e they are in the range of dimension
                if(nr >= 0 && nr < n && nc>=0 && nc < n){
//         it neighbour of r,c is 0 then it means r,c if part of the boundary so store this
                    if(grid[nr][nc] == 0){
                        if(time == 1)   
                            first.add(new Pair(r,c));
                        else
                            second.add(new Pair(r,c));
                    }
                    else if(vis[nr][nc] == 0){
                        vis[nr][nc] = 1;
                        q.add(new Pair(nr, nc));
                    }
                }   
            }
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = grid.length;
//      vis[i][j] == 1 if i, j has already visited, else its 0
        int[][] vis = new int[n][n];
//         as there are 2 islands we have to capture the boundary of both in separate data structure
        int time = 0;
        Set<Pair<Integer,Integer>> first = new HashSet<>();
        Set<Pair<Integer,Integer>> second = new HashSet<>();

//      doing standard bfs for both islands and capturing their boundary
        for(i =0 ;i <n ;i++)
            for(j = 0;j < n;j++)
                if(grid[i][j] == 1 && vis[i][j] == 0)
                    bfs(grid, vis, i,j, time++, first, second);
        
//         finding the min length of the bridge 
        for(Pair<Integer,Integer> p : first){
            for(Pair<Integer,Integer> q : second){
                ans = Math.min(ans, Math.abs(p.getKey()-q.getKey()) + Math.abs(p.getValue()-q.getValue()) );
            }
        }
        
        return ans-1;
    }
}