import java.util.*;

class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.size[i] = 1;
            }
            this.maxSize = 1;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);
                return true;
            }
            return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> sortedEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            sortedEdges.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }
        Collections.sort(sortedEdges, Comparator.comparingInt(a -> a[2]));

        UnionFind unionFindStandard = new UnionFind(n);
        int minimumSpanningTreeWeight = 0;
        for (int[] edge : sortedEdges) {
            if (unionFindStandard.union(edge[0], edge[1])) {
                minimumSpanningTreeWeight += edge[2];
            }
        }

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        for (int[] edge : sortedEdges) {
            UnionFind unionFindTemp = new UnionFind(n);
            int tempWeight = 0;
            for (int[] tempEdge : sortedEdges) {
                if (edge[3] != tempEdge[3] && unionFindTemp.union(tempEdge[0], tempEdge[1])) {
                    tempWeight += tempEdge[2];
                }
            }

            if (unionFindTemp.maxSize < n || tempWeight > minimumSpanningTreeWeight) {
                criticalEdges.add(edge[3]);
                continue;
            }

            UnionFind unionFindForce = new UnionFind(n);
            int forceWeight = edge[2];
            unionFindForce.union(edge[0], edge[1]);
            for (int[] forceEdge : sortedEdges) {
                if (edge[3] != forceEdge[3] && unionFindForce.union(forceEdge[0], forceEdge[1])) {
                    forceWeight += forceEdge[2];
                }
            }

            if (forceWeight == minimumSpanningTreeWeight) {
                pseudoCriticalEdges.add(edge[3]);
            }
        }

        result.add(criticalEdges);
        result.add(pseudoCriticalEdges);
        return result;
    }
}