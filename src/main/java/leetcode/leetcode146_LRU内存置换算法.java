package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/*
* HashMap 、linkedList 综合应用
* */
class LRUCache {
    HashMap<Integer,Integer> hashMap; //key-value 的映射
    LinkedList<Integer> list;  //key 的队列
    int capacity;
    int initcapacity=0;
    public LRUCache(int capacity) {
        hashMap=new HashMap<>(capacity);
        list=new LinkedList<>();
        this.capacity=capacity;
    }
     /*
     * list.remove（key） 是删除了index=key上的元素
     * */
    public int get(int key) {           //刚访问之后需要改变次序,将刚访问过的放到队列的最前边
        if (hashMap.containsKey(key)){
            int index=list.indexOf(key);
            list.addFirst(list.remove(index));
            return hashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)) { //如果不存在
            if (initcapacity == capacity){ //存储空间已满
                 int temp = list.removeLast(); //删除队尾元素
                 hashMap.remove(temp);
                 initcapacity--;               //删除队尾时，容量--
             }
            hashMap.put(key,value);
            list.addFirst(key);
            initcapacity++;
        }else{
            hashMap.put(key,value);
            int index=list.indexOf(key);
            list.addFirst(list.remove(index)); //如果存在则放置在队列首部,map长度不变
        }
    }
}
public class leetcode146_LRU内存置换算法 {
    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2); //新建缓存
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
