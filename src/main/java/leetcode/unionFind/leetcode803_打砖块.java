package leetcode.unionFind;
/*
  @Date:2020/4/21 9:28
  @Author:Administrator
*/

import java.util.*;
/*
* 打砖块：逆向思维
*当打了一块砖的时候，需要切割数组，去掉需要去除的砖块：区间区分
* 逆向思维：当砌了一块砖后，所有新的直接、间接连到边框的砖块是正向思维的结果
* */
public class leetcode803_打砖块 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int res[]=new int[hits.length]; //结果数组
        rows = grid.length;
        if (rows == 0) {
            return new int[0];
        }
        cols = grid[0].length;
        int n=cols*rows;
        int roots[]=new int[n]; //根节点数组
        int size[]=new int[n]; //每一个union中砖块的数量
        boolean [] st=new boolean[n];
        int last=0;
        int curindex=0;
        Arrays.fill(size,1);
        //初始化根节点数组
        Arrays.fill(roots,-1);
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (grid[i][j]=='1'){
                    roots[i*cols+j]=i*cols+j;
                }
            }
        }
        //初始化并查集
        for (int[] v: hits) grid[v[0]][v[1]] = 0;  // 要打的砖块置0
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (grid[i][j]==1){
                    for (int [] d: directions) {
                        int x=i+d[0];
                        int y=j+d[1];
                        if (inArea(x,y)&&grid[x][y]==1){
                            un(roots,i*cols+rows,x*cols+y,size); //合并
                        }
                    }
                }
            }
        }
        //遍历砌砖块之前的和顶部间接、直接相连的砖块
        for (int i = 0; i <cols ; i++) {
            if (grid[0][i]==1){
                int root=findRoot(roots,i);
                if (st[root]) continue;
                st[root]=true;
                last+=size[root]; //砌砖块之前的砖块数
            }
        }
        //砌砖块
        for (int[] h: hits) {
            grid[h[0]][h[1]]=1;
            //砌砖块之后合并
            for (int [] d: directions) {
                int x=h[0]+d[0];
                int y=h[1]+d[1];
                if (inArea(x,y)&&grid[x][y]==1){
                    un(roots,h[0]*cols+h[1],x*cols+y,size); //合并
                }
            }
            int cur=0; //砌完砖之后的和顶部直接或者间接连在一起的砖块数
            for (int i = 0; i <cols ; i++) {
                if (grid[0][i]==1){
                    int root=findRoot(roots,i);
                    if (st[root]) continue;
                    st[root]=true;
                    cur+=size[root]; //砌砖块之前的砖块数
                }
            }
            res[curindex++]=(cur-last-1==-1)?0:cur-last-1;
        }
        return  res;
    }
    int findRoot(int []roots,int id){
        return (id==roots[id])?id:findRoot(roots,roots[id]);
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
    //合并 x,y
    void un(int [] roots,int x, int y,int [] size) {
        int p = findRoot(roots,x), q = findRoot(roots,y);
        if (p != q) {
            roots[p] = q;
        }
        size[q]+=size[p]; //p 向 q合并
    }
}
