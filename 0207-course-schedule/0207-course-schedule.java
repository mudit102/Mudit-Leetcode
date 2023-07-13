class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!mp.containsKey(pre[0])) {
                mp.put(pre[0], new ArrayList<>());
            }
            mp.get(pre[0]).add(pre[1]);
        }
        
        int[] bl = new int[numCourses];
        for (int[] pre : prerequisites) {
            int a = pre[0];
            if (bl[a] == 0) {
                if (test(a, mp, bl)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean test(int ind, Map<Integer, List<Integer>> mp, int[] bl) {
        if (bl[ind] == 1) {
            return true;
        }
        if (bl[ind] == 2) {
            return false;
        }
        bl[ind] = 1;
        
        if (mp.containsKey(ind)) {
            for (int i : mp.get(ind)) {
                if (test(i, mp, bl)) {
                    return true;
                }
            }
        }
        
        bl[ind] = 2;
        return false;
    }
}
