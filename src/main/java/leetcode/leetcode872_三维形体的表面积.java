package leetcode;

public class leetcode872_三维形体的表面积 {
    /*
    *  对于三维形体的每一个柱子的表面积由上下底面+四个侧面（边界上的柱子有三个侧面、两个侧面）
    *  底面表面积一定是2
    *  侧面表面积是Max(0,相应侧柱的高度-当前的柱子)
    *
    * */
    private int rows;
    private int cols;
    public int surfaceArea(int[][] grid) {
        //四侧方向
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        rows =cols= grid.length; //N*N的表格
        int ans = 0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <rows ; j++) {
                if (grid[i][j]>0){
                    ans+=2;
                    for (int k = 0; k <4; k++) {
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        int nv=0;
                        if (inArea(nr,nc)){
                            nv=grid[nr][nc];
                        }
                        ans+=Math.max(0,grid[i][j]-nv);
                    }
                }
            }
        }
        return ans;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
