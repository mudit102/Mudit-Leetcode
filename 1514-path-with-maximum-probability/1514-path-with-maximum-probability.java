class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(a, x -> new ArrayList<>()).add(new int[]{b, i});
            graph.computeIfAbsent(b, x -> new ArrayList<>()).add(new int[]{a, i});
        }
        
        double[] probabilities = new double[n];
        probabilities[start] = 1.0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int[] neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                int next = neighbor[0];
                int i = neighbor[1];
                double newProb = probabilities[current] * succProb[i];
                
                if (newProb > probabilities[next]) {
                    probabilities[next] = newProb;
                    queue.offer(next);
                }
            }
        }
        
        return probabilities[end];
    }
}