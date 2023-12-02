public class Solution {
    private HashMap<Character, Integer> myFunc(String s) {
        HashMap<Character, Integer> dc = new HashMap<>();
        for (char i : s.toCharArray()) {
            dc.put(i, dc.getOrDefault(i, 0) + 1);
        }
        return dc;
    }

    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for (String word : words) {
            int check = 0;
            HashMap<Character, Integer> cur = myFunc(word);
            for (HashMap.Entry<Character, Integer> entry : cur.entrySet()) {
                if (entry.getValue() <= chars.chars().filter(c -> c == entry.getKey()).count()) {
                    check = 1;
                } else {
                    check = 0;
                    break;
                }
            }
            if (check == 1) {
                result += word.length();
            }
        }
        return result;
    }
}