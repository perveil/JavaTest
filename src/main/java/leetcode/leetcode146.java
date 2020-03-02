package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    HashMap<Integer,Integer> hashMap;
    LinkedList<Integer> list;
    int capacity;
    int initcapacity=0;
    public LRUCache(int capacity) {
        hashMap=new HashMap<>(capacity);
        list=new LinkedList<>();
        this.capacity=capacity;
    }

    public int get(int key) {    //刚访问之后需要改变次序
        if (hashMap.containsKey(key)){
            list.addFirst(list.remove(key));
            return hashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)) { //如果不存在
            if (initcapacity == capacity){ //存储空间已满
                 int temp = list.removeLast();
                 hashMap.remove(temp); //删除队尾
                 initcapacity--; //删除队尾时，容量--
             }
            hashMap.put(key,key);
            list.addFirst(key);
            initcapacity++;
        }else{
            list.addFirst(list.remove(key)); //如果存在则放置在队列首部,map不变
        }
    }
}
public class leetcode146 {
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
