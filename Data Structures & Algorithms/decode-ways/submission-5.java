class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = 1; // first char already checked != '0'

        for (int i = 2; i <= n; i++) {
            // one-digit decode
            char one = s.charAt(i - 1);
            if (one >= '1' && one <= '9') {
                dp[i] += dp[i - 1];
            }

            // two-digit decode
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
