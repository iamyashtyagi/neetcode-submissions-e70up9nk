class Solution {
    public String minWindow(String s, String t) {
        int[] freqS = new int[128];
        int[] freqT = new int[128];

        int lenS = s.length(), lenT = t.length();
        if (lenT > lenS) return "";

        for (int i = 0; i < lenT; i++) {
            freqT[t.charAt(i)]++;
        }

        int start = 0, end = 0, count = 0;
        int minWindow = Integer.MAX_VALUE;
        String result = "";

        while (end < lenS) {
            char c = s.charAt(end);
            freqS[c]++;

            if (freqT[c] > 0 && freqS[c] <= freqT[c]) {
                count++;
            }

            while (count == lenT &&
                   freqS[s.charAt(start)] > freqT[s.charAt(start)]) {
                freqS[s.charAt(start)]--;
                start++;
            }

            if (count == lenT && end - start + 1 < minWindow) {
                minWindow = end - start + 1;
                result = s.substring(start, end + 1);
            }

            end++;
        }
        return result;
    }
}
