class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Arrays.sort(points,(a,b)-> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        for(int i=0;i<k;i++){
            result[i][0]=points[i][0];
            result[i][1]=points[i][1];
        }
        return result;
    }
}
