class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] charFreq = new int[26];
        int count =0;
        for(char c : s.toCharArray()){
            charFreq[c-'a']++;
            count++;
        }
        for(char c : t.toCharArray()){
            if( charFreq[c-'a']<=0){
                return false;
            }
            charFreq[c-'a']--;
            count--;
        }
        return count==0;
    }
}
