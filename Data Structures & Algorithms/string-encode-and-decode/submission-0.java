class Solution {

    List<Integer> index;
    String result ="";
    List<String> finalResult;

    public String encode(List<String> strs) {
        index = new ArrayList<>(strs.size());
        for(String s : strs){
            result+=s;
            index.add(s.length());
        }
        return result;
    }

    public List<String> decode(String str) {
        finalResult = new ArrayList<>(index.size());
        int start =0;
        for(Integer i : index){
            finalResult.add(result.substring(start,start+i));
            start += i;
        }
        return finalResult;
    }
}
