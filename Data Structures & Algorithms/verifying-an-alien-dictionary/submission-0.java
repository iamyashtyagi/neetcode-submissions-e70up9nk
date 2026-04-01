class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hm.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());
            boolean decided = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 == c2) continue;

                int rank1 = hm.getOrDefault(c1, -1);
                int rank2 = hm.getOrDefault(c2, -1);

                if (rank1 > rank2) return false; // w1 should come after w2 -> not sorted
                decided = true; // order determined for this pair
                break;
            }

            // if all characters equal up to minLen, then shorter word must come first
            if (!decided && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
}
