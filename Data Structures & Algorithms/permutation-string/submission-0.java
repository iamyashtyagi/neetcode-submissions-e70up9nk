class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2) return false;

        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < l2; i++) {
            count[s2.charAt(i) - 'a']--;

            if (i >= l1) {
                count[s2.charAt(i - l1) - 'a']++;
            }

            if (allZero(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean allZero(int[] arr) {
        for (int n : arr) {
            if (n != 0) return false;
        }
        return true;
    }
}