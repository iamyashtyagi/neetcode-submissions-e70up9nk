class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int start = 0;
        int end=0;
        int length = 0;
        Set<Character> set = new HashSet();
        while(end <s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                length = Math.max(length,end - start +1);
            }
            else{
                while(s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            set.add(s.charAt(end));
            end++;
        }
        return length;
    }
}
