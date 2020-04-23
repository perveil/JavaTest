package leetcode.bfs;/*
  @Date:2020/4/23 10:39
  @Author:Administrator
*/

import java.util.*;
/*
 * SPFA:shortest Path Faster Algorithm
*http://keyblog.cn/article-21.html
*  1、 求从start 到end 的最短路径，正负值均可
*  2、判断有无负环 如果某个点进入队列的次数超过N次则存在负环
* */
public class spfa_mindistance {
    /*
    * params:
    *    matrix: 有向图的邻接矩阵
    *    start: 路径起始点
    *    end: 路径末尾
    *
    * */
     public static int spfa(int [][] matrix,int start,int end){
         Queue<Integer> q=new LinkedList<>();
         int [] distance=new int[matrix.length]; //start 到其他点的最小距离
         int [] visited=new int[matrix.length]; //此时是否在队列中
         Arrays.fill(distance,Integer.MAX_VALUE); // 初始化start点到各个点的距离为无穷大
         distance[start]=0;
         q.add(start);
         visited[start]=1;
         while (!q.isEmpty()){
             int x=q.poll(); //队首节点出队
             visited[x]=0; //出队则visited[x] 置零
             for (int i = 0; i <matrix[0].length ; i++) { //遍历与x联通的点 matrix[x][i] 为x到i的直达距离
                 if (distance[i]>distance[x]+matrix[x][i]){ //start到i节点的距离 大于 （start经过x到i的距离）
                     distance[i]=distance[x]+matrix[x][i];
                     if (visited[i]==0){ //i节点不在队列中
                         q.add(i);//入队
                         visited[i]=1; //队列状态置一
                     }
                 }

             }

         }
         return distance[end];
     }
}
