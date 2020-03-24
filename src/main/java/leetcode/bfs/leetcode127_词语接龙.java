package leetcode.bfs;

import java.util.*;

public class leetcode127_词语接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord)==-1) return 0;
        /*
         * 构造邻接表
         * */
        Map<String,List<String>> neborMap=new HashMap<>(); //此无向无权图的邻接表
        List<String> similarWordList=similarWordList(beginWord,wordList); //获得beginWord 所有nextword
        neborMap.put(beginWord,similarWordList);
        for (String s:wordList) {
            neborMap.put(s,similarWordList(s,wordList));
        }
        HashMap<String, Integer> dist = new HashMap<String, Integer>(); //访问字典，对应startword 到 endword的距离
        dist.put(beginWord,0);
        return bfs(beginWord,endWord,neborMap,dist)+1;

    }
    /*
     *  param:
     *   beginWord: 开始字符串
     *   wordList:  需要比较的字符串
     * return:
     *  similarList:与beiginWord 只有一个字符之差的List
     * */
    public List<String> similarWordList(String beginWord, List<String> wordList) {
        List<String> similarList=new ArrayList<>();
        for (String s:
                wordList) {
            if (isSimilar(beginWord,s)) similarList.add(s);
        }
        return similarList;
    }
    public boolean isSimilar(String beginWord, String endWord) {
        int nums=0; //beginWord、endWord 不相同的位置
        for (int i = 0; i <beginWord.length(); i++) {
            if (beginWord.charAt(i)!=endWord.charAt(i))
                nums++;
        }
        return nums==1;
    }
    /*
    * 广度优先遍历获得最近距离
    * */
    public int bfs(String beginWord, String endWord, Map<String,List<String>> neborMap,HashMap<String, Integer> dist) {
        Queue<String> queue = new LinkedList<String>(); //队列
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String top=queue.poll(); //取出队首元素
            int d = dist.get(top) + 1;  //得出其周边还未被访问的节点的距离
            for (String c : neborMap.get(top)) {
                if (!dist.containsKey(c)){   //此元素未访问
                    if (c==endWord) return d; //找到endWord
                    dist.put(c, d);
                    queue.add(c);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(
                new leetcode127_词语接龙().ladderLength("hit","cog",list)
        );
    }
}
