class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return ans;
    }
    
    public void helper(int start, int n, int k, List<Integer>sub){
        if(k==0) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i = start;i<=n-k+1;i++){
            sub.add(i);
            helper(i+1,n,k-1, sub);
            sub.remove(sub.size()-1);
        }
    }
}