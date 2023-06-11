class SnapshotArray {
    List<Map<Integer, Integer>> list;
    
    public SnapshotArray(int length) {
        list = new ArrayList();
        list.add(new HashMap());
    }
    
    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }
    
    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }
    
    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list.get(snap).containsKey(index))
                return list.get(snap).get(index);
        }
        return 0;
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */