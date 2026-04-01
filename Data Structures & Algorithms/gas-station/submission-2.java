class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int sum = 0;
        int max = 0;
        int max_i = -1;
        for(int i=0;i<n;i++){
            diff[i]= gas[i]-cost[i];
            sum+=diff[i];
            if(diff[i]>max){
                max_i = i;
                max = diff[i];
            }
        }
        // if sum >=0 then it is possible to cover
        if(sum<0){
            return -1;
        }
        sum =0;

        for(int i=0;i<n;i++){
            if(sum<=0){
                sum =diff[i];
                max_i = i;
            }
            else{
                sum+=diff[i];
            }
        }
        return max_i;

        // find highest, or longest subrray with psitive sum,  that would always help

    }
}
