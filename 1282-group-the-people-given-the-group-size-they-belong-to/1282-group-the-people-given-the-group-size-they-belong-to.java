class Solution {
    public List<List<Integer>> groupThePeople(int[] grps) {
        HashMap<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < grps.length; i++) {
            List<Integer> temp = m.getOrDefault(grps[i], new ArrayList<Integer>());
            if (temp.size() == grps[i]) {
                res.add(temp);
                temp = new ArrayList<Integer>();
            }
            temp.add(i);
            m.put(grps[i], temp);
        }
        for (int size: m.keySet()) {
            res.add(m.get(size));
        }
        return res;
    }
}