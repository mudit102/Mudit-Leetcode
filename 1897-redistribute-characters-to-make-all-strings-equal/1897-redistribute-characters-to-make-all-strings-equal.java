class Solution {
    public boolean makeEqual(String[] words) {
        
        int counts[] = new int[26];

        for(String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }

        int n = words.length;
        for(int value : counts) {

            if(value % n != 0) {
                return false;
            }
        }
        return true;
    }
}