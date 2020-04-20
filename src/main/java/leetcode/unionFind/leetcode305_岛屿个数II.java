package leetcode.unionFind;
/*
  @Date:2020/4/20 9:29
  @Author:Administrator
*/
/*
*  1 0 1
*  0 0 0  ->使得（0，1） 变为1 count=3 -> 与(0,0) 合并一次 -> 与(0,2) 合并一次
*  0 0 0
*/
import java.util.*;

public class leetcode305_岛屿个数II {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    List<Integer> numsofisland(int m,int n,int [][] position){
        List<Integer> res=new ArrayList<>();
        int count=0;//当前岛屿的个数
        int [] roots=new int[m*n]; //每一个陆地的根
        Arrays.fill(roots,-1); //初始化根数组，全为-1，表示都是water，此时没有island
        for (int [] pos: position) {
            int id=n*pos[0]+pos[1];
            if (roots[id]!=-1){ //
                res.add(count);
                continue;
            }
            roots[id]=id; //此时设置此处的根为根本身
            ++count; //岛屿数++，先增加一次,如果此点造成岛屿合并，则--
            for (int[] d: directions) {
                int x=pos[0]+d[0];
                int y=pos[1]+d[1];
                int cur_id=n*x+y;
                if (!inArea(x,y,m,n)||roots[cur_id]==-1) continue;
                //周围超出边界或者周围的水域，则跳过，不会造成岛屿合并
                int p=findRoot(roots,cur_id);int q=findRoot(roots,id);
                if (p!=q){ //相邻节点的根节点如果不是属于一个岛屿的时候，则需要合并两个岛屿
                    roots[p]=q;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    //查找当前节点点根节点，当id==roots[id]时遇见根节点
    int findRoot(int []roots,int id){
        return (id==roots[id])?id:findRoot(roots,roots[id]);
    }
    private boolean inArea(int x, int y,int m,int n) {
        // 等于号不要忘了
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
