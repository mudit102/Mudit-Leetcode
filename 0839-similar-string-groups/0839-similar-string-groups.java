class Solution {
    public int numSimilarGroups(String[] strs) {

        int[] parent = new int[strs.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < strs.length; i++){
            for(int j = i + 1; j < strs.length; j++){
                String p = strs[i];
                String c = strs[j];
                int count = 0;
                for(int k = 0; k < strs[0].length(); k++){
                    if(p.charAt(k) != c.charAt(k)){
                        count++;
                    }
                    if(count > 2){
                        break;
                    }
                }
                if(count <= 2){
                    int parP = find(i, parent);
                    int parC = find(j, parent);
                    parent[parP] = parC;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < parent.length; i++){
            if(i == parent[i] || parent[i] == -1){
                res++;
            }
        }
        return res;
        
    }

    public int find(int v, int[] parent){
        if(parent[v] == -1 || parent[v] == v){
            return v;
        }
        return parent[v] = find(parent[v], parent);
    }

}