package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 有向无环图的拓扑排序
* 拓扑排序的步骤：
* 1.计算各个节点的入度，形成入度表
* 2.借助一个队列queue，将所有入度为0的节点入队
* 3.当queue非空时，依次将队首节点出队，在图中删除此节点：
*    1.把该点所有的邻接点的入度减一
*    2.减一后邻接节点的入度=0时，入队
* 4.每一次出队时，执行numCourse--；
* */
public class leetcode207 {
    /*
    * 想要学习0，必须先学习1 [0,1]  1->0
    * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegrees=new int[numCourses]; //入度表
        List<List<Integer>> adj=new ArrayList<>();//邻接表
        Queue<Integer> queue = new LinkedList<>(); //存储入度为0的节点
        for (int i = 0; i <numCourses ; i++) {
            adj.add(new ArrayList<>());
        }
        //构造邻接表
        for (int [] a:
             prerequisites) {
            indegrees[a[0]]++;
            adj.get(a[1]).add(a[0]);
        }
        for (int i = 0; i <numCourses ; i++) {
            if (indegrees[i]==0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre=queue.poll();  //入度为0之后出队
            numCourses--;
            for (int cur:adj.get(pre)){
                if (--indegrees[cur]==0) queue.add(cur);
            }
        }
        return numCourses==0;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res=new ArrayList<>();
        int []indegrees=new int[numCourses]; //入度表
        List<List<Integer>> adj=new ArrayList<>();//邻接表
        Queue<Integer> queue = new LinkedList<>(); //存储入度为0的节点
        for (int i = 0; i <numCourses ; i++) {
            adj.add(new ArrayList<>());
        }
        //构造邻接表
        for (int [] a:
                prerequisites) {
            indegrees[a[0]]++;
            adj.get(a[1]).add(a[0]);
        }
        for (int i = 0; i <numCourses ; i++) {
            if (indegrees[i]==0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre=queue.poll();  //入度为0之后出队
            res.add(pre);
            numCourses--;
            for (int cur:adj.get(pre)){
                if (--indegrees[cur]==0) queue.add(cur);
            }
        }
        int resLen = res.size();
        if (resLen == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }

}
