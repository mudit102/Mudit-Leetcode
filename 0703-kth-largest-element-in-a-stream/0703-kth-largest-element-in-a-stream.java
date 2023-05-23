class KthLargest {
    PriorityQueue<Integer> pq;
    int l;
    public KthLargest(int k, int[] nums) {
      this.l = k;
            pq = new PriorityQueue<>(k);
            for (int num :nums)
                add(num);
    }
    
    public int add(int val) {
      if (pq.size() <l)
                pq.offer(val);
            else if (pq.peek() <val) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */