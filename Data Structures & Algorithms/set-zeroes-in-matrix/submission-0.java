class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> setX = new HashSet();
        Set<Integer> setY = new HashSet();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==0){
                    setX.add(i);
                    setY.add(j);
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(setX.contains(i)&&setY.contains(j)){
                    makeZeroes(matrix,i,j,R,C);
                }
            }
        }
    }

    private void makeZeroes(int[][] matrix, int x, int y, int R, int C){
        // System.out.println("Making zeroes "+x+" "+y);
        for(int i=0;i<R;i++){
            matrix[i][y]=0;
        }
        for(int j=0;j<C;j++){
            matrix[x][j]=0;
        }
    }
}
