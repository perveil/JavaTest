package leetcode.traceBack;

/*
*  回溯超时，但是可以解
* */
public class leetcode79_单词搜索 {
    char[][] board;
    char[] charOfWord;
    int rows;
    int cols;
    boolean res=false;
    boolean [][] mark;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.charOfWord=word.toCharArray();
        this.rows=board.length;
        this.cols=board[0].length;
        mark=new boolean[rows][cols];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j]==charOfWord[0]){
                    helper(i,j,0);  //递归入口
                    if (res){  //如果存在则返回
                        return res;
                    }
                }
            }
        }
        return res;

    }
    /*
    * 递归方向
    * */
    public void helper(int i,int j,int cur) {
        if (!inArea(i,j)||board[i][j]!=charOfWord[cur]||mark[i][j]){ //以访问过则直接跳过
            return;
        }
        if (cur==charOfWord.length-1){
            res=true;
            return; //递归结束
        }
        mark[i][j]=true;
        helper(i+1,j,cur+1);
        helper(i-1,j,cur+1);
        helper(i,j+1,cur+1);
        helper(i,j-1,cur+1);
        mark[i][j]=false; //回溯

    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        System.out.println(
            new leetcode79_单词搜索().exist(new char[][]{
                    {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
            },"SEE")
        );
    }

}
