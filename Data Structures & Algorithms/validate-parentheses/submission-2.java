class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(Character c : ch){
            if(c =='{' || c=='[' || c=='('){
                sb.append(c);
            }
            else{
                if(c==')'){
                    if(!sb.isEmpty()){
char t = sb.charAt(sb.length()-1);
                        sb.deleteCharAt(sb.length()-1);                        if(t!='('){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                if(c=='}'){
                    if(!sb.isEmpty()){
                        char t = sb.charAt(sb.length()-1);
                        sb.deleteCharAt(sb.length()-1);
                        if(t!='{'){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                if(c==']'){
                    if(!sb.isEmpty()){
char t = sb.charAt(sb.length()-1);
                        sb.deleteCharAt(sb.length()-1);                        if(t!='['){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return sb.length()==0 &&true;
    }
}
