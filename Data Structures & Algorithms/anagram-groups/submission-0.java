class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // fresh key per word
            char[] keyArr = new char[26];
            Arrays.fill(keyArr, '0');

            for (char ch : word.toCharArray()) {
                keyArr[ch - 'a']++;
            }

            String key = new String(keyArr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        result.addAll(map.values());
        return result;
    }
}
