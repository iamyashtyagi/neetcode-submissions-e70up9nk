class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int maxWater = 0;
        int n = height.length;
        for(int i=0;i<n;i++){
            int curr = height[i];
            if(st.isEmpty() || height[st.peek()] >= curr){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && height[st.peek()] < curr){
                    int prev = st.pop();
                    if(!st.isEmpty()){
                        int prev_prev = st.peek();
                        maxWater+= (Math.min(height[prev_prev],curr)-height[prev])*(i-prev_prev-1);
                    }
                }
                st.push(i);
            }
        }
        
        return maxWater;
    }
}
