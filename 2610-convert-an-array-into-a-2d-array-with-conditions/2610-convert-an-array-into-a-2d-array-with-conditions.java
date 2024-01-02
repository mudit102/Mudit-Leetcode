public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        while (!numList.isEmpty()) {
            List<Integer> uniqueRow = new ArrayList<>();

            for (int i = 0; i < numList.size(); i++) {
                if (!s.contains(numList.get(i))) {
                    s.add(numList.get(i));
                    uniqueRow.add(numList.get(i));
                    numList.remove(i);
                    i--;  // Adjust the index after removing an element
                }
            }

            ans.add(uniqueRow);
            s.clear();  // Clear the set for the next row
        }

        return ans;
    }
}