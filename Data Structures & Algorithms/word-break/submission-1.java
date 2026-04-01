class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(set.contains(s.substring(i,j+1)) && dp[j]==false){
                    System.out.println(" dp["+j+"] "+dp[j]+ " dp[i-1] "+(i-1>=0?dp[i-1]:true));
                    dp[j] = dp[j]||i-1>=0?dp[i-1]:true;
                    System.out.println(" after dp["+j+"] "+dp[j]+ " dp[i-1] "+(i-1>=0?dp[i-1]:true));
                }
            }
        }
        return dp[n-1];
    }
}
