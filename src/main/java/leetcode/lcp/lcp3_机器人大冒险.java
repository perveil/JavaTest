package leetcode.lcp;

public class lcp3_机器人大冒险 {
    /*
    * 暴力解法
    * */
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char[] directions=command.toCharArray();  //方向
        int x1=0;int y1=0;
        for (int i = 0; i <directions.length ; i=++i%directions.length) {
            switch (directions[i]){
                case 'U':
                    y1++;
                    if (!isCan(x1,y1,obstacles)){
                        return false;
                    }
                    if (x1==x&&y1==y) return true;
                    break;
                case 'R':
                    x1++;
                    if (!isCan(x1,y1,obstacles)){
                        return false;
                    }
                    if (x1==x&&y1==y) return true;
                    break;
            }
        }
        return false;
    }
    public boolean isCan(int x1,int y1,int[][]obstacles){
        for (int i = 0; i <obstacles.length ; i++) {
            if (    x1==obstacles[i][0]&&
                    y1==obstacles[i][1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new lcp3_机器人大冒险().robot(
                "URR",new int[][]{},3,2
        );
    }
}
