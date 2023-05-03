class Solution {
    static List<Integer> f(int [] c ,int [] d){
           List<Integer> r = new ArrayList<Integer>();
        for(int i=0;i<c.length;i++){
            boolean f=false;
            for(int j=0;j<d.length;j++){
             if(c[i]==d[j]){
                 f=true;
                 break;
             }
            }
         if(!f&&!r.contains(c[i])){
         r.add(c[i]);
         }
        }
        return r;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
      List<List<Integer>> a = new ArrayList<List<Integer>>();
      
          boolean f=true;
          a.add(f(nums1,nums2));
          a.add(f(nums2,nums1));
          return a;
       
    }
}