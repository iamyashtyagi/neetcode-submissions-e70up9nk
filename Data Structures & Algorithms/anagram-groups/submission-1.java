class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] keyArr = new char[26];
            Arrays.fill(keyArr, '0');

            for (char ch : strs[i].toCharArray()) {
                keyArr[ch - 'a']++;
            }

            String key = new String(keyArr);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        // 🔹 Using entrySet exactly as you wanted
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
