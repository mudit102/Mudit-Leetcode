class Solution {
    static final int STATE_UNDEFINED   =  0;
    static final int STATE_IN_DFS_PATH =  1;
    static final int STATE_UNSAFE      = -1;
    static final int STATE_SAFE        = -2;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] states = new int[n];
        for (int i = n - 1; i >= 0; i--) 
            if (states[i] == STATE_UNDEFINED) 
                dfs(states, graph, i);
        
        List<Integer> result = new ArrayList();
        for (int i = 0; i < n; i++) 
            if (states[i] == STATE_SAFE)
                result.add(i);
        return result;
    }
    
    private int dfs(int[] states, int[][] graph, int node) {
        states[node] = STATE_IN_DFS_PATH;
        int state = STATE_SAFE;
        for (int child : graph[node]) {
            if (states[child] != STATE_SAFE) {
                if (states[child] != STATE_UNDEFINED) {
                    state = STATE_UNSAFE;
                    break;
                }
                if ((state |= dfs(states, graph, child)) == STATE_UNSAFE)
                    break;
            }
        }
        states[node] = state;
        return state;
    }
}