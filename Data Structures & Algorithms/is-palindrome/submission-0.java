class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = makeAlphanumeric(s);
        System.out.println("Result is "+s);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                System.out.println("Failed for "+s.charAt(i)+" "+i+" "+s.charAt(s.length()-i-1));
                return false;
            }
        }
        return true;
    }

    public String makeAlphanumeric(String s){
        String result = new String() ;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'0'<=9 && s.charAt(i)-'0' >=0) ||(s.charAt(i)-'a'<=25 && s.charAt(i)-'a' >=0)){
                result+=s.charAt(i);
            }
        }
        return result;
    }
}
