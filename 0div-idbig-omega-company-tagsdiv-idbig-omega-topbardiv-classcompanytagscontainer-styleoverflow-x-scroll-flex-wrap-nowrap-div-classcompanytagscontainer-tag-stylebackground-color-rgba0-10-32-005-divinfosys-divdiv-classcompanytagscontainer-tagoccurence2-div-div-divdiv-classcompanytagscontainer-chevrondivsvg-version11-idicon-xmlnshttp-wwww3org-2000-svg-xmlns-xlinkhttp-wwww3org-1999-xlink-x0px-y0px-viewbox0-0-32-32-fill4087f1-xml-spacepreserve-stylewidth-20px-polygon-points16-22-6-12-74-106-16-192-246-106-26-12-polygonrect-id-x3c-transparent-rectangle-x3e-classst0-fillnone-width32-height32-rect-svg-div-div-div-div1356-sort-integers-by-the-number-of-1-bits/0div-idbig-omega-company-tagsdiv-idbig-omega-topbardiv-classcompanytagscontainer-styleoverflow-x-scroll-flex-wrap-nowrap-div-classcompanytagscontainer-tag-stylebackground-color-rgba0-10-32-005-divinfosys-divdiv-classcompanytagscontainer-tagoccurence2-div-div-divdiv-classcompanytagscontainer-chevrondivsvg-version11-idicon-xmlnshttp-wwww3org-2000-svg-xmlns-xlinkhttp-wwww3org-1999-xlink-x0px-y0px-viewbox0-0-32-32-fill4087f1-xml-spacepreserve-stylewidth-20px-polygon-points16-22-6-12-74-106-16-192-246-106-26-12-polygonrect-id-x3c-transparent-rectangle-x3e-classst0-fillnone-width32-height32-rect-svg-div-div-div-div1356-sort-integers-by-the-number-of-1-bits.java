class Solution {
    public int[] sortByBits(int[] arr) {
        Comparator<Integer> customComparator = (a, b) -> {
            int onesA = countOnes(a);
            int onesB = countOnes(b);
            if (onesA != onesB) {
                return onesA - onesB;
            }
            return a - b;
        };

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        for (int n : arr) {
            priorityQueue.offer(n);
        }

        int[] res = new int[arr.length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i] = priorityQueue.poll();
            i++;
        }

        return res;
    }

    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }        
}