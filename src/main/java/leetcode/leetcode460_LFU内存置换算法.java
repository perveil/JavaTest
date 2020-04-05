package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode460_LFU内存置换算法 {
    public static void main(String[] args) {
        new leetcode460_LFU内存置换算法();
    }
}
/*
* 依据访问频率降序排序的双向链表
* */
class LFUCache {
    Map<Integer,Node> cache;//Integer 指的是数字，Node，指的是key=integer的节点
    MulDirectionLinkedList firstLinkedList; //频率最大的双向链表
    MulDirectionLinkedList lastLinkedList; //删除时要访问的、频率出现最小的双向链表
    int size;
    int capacity;

    public LFUCache(int capacity) {
        cache=new HashMap<>();
        firstLinkedList=new MulDirectionLinkedList(); //头节点
        lastLinkedList=new MulDirectionLinkedList();  //头节点
        firstLinkedList.post=lastLinkedList;
        lastLinkedList.pre=firstLinkedList;
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node=cache.get(key);
        if (node==null){
            return -1;
        }
        freqInc(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (capacity==0){
            return;
        }
        Node node=cache.get(key);
        if (node!=null){
            node.value=value;
            freqInc(node); //存在则需要对此节点更换位置
        }else{
            if (size==capacity){ //缓存满了，则删除最近最小频率访问的元素
                cache.remove(lastLinkedList.pre.tail.pre.key);
                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
                size--;
                if (lastLinkedList.pre.head.post==lastLinkedList.pre.tail){ //删除后为空
                    removeDoublyLinkedList(lastLinkedList);
                }
            }
            //删除后或者内存不满时，添加新节点
            Node newNode=new Node(key,value);
            cache.put(key,newNode);
            if (lastLinkedList.pre.freq!=1){ //新添加节点的频度最低是1，则需要查看最后的频度双向链表
                MulDirectionLinkedList linkedList=new MulDirectionLinkedList();
                addDoublyLinkedList(linkedList,lastLinkedList.pre); //此时新建的双向链表的freq=1，cache 最末的双向链表的freq 大于 1
                linkedList.addNode(node);
            }else { //此时最小频度为1，则新添加元素即可
                lastLinkedList.pre.addNode(newNode);
            }
            size++;

        }

    }
    void freqInc(Node node) {
        MulDirectionLinkedList linkedList=node.mulDirectionLinkedList; //找到此时所在的双向链表
        MulDirectionLinkedList preLinkedList = linkedList.pre;
        linkedList.removeNode(node); //删除此时的节点
        if (linkedList.head.post==linkedList.tail){ //删除后链表为空，则删除此频率的双向链表
            removeDoublyLinkedList(linkedList);
        }
        node.freq++;
        if (preLinkedList.freq!=node.freq){ //以freq降序排序的双向链表,此时没有freq的双向链表
            MulDirectionLinkedList newLinkedList=new MulDirectionLinkedList();
            addDoublyLinkedList(newLinkedList,preLinkedList); //在cache中添加新双向链表
            newLinkedList.addNode(node);
        }else{
            preLinkedList.addNode(node);
        }
    }
    void addDoublyLinkedList(MulDirectionLinkedList newDoublyLinedList, MulDirectionLinkedList preLinkedList) {
        newDoublyLinedList.post=preLinkedList.post;
        newDoublyLinedList.post.pre=newDoublyLinedList;
        newDoublyLinedList.pre=preLinkedList;
        preLinkedList.post=newDoublyLinedList;
    }
    void removeDoublyLinkedList(MulDirectionLinkedList doublyLinkedList) {
        doublyLinkedList.post.pre=doublyLinkedList.pre;
        doublyLinkedList.pre.post=doublyLinkedList.post;
    }
    static class Node{
        int key;
        int value;
        int freq=1;
        Node pre;
        Node post;
        MulDirectionLinkedList mulDirectionLinkedList;
        public Node(){}
        public Node(int key,int value){
            this.key=key;
            this.value=value;

        }
    }
    static  class MulDirectionLinkedList{ //指代的是出现频率为freq的双向链表
        int freq;
        MulDirectionLinkedList pre;
        MulDirectionLinkedList post;
        Node head;
        Node tail;
        public MulDirectionLinkedList() {
            head = new Node();  //相对于链表的空节点
            tail = new Node();
            head.post = tail;
            tail.pre = head;
        }
        public MulDirectionLinkedList(int freq) {
            head = new Node();
            tail = new Node();
            head.post = tail;
            tail.pre = head;
            this.freq=freq;
        }
        void removeNode(Node node) {
            node.pre.post = node.post;
            node.post.pre = node.pre;
        }
        void addNode(Node node) {
            node.post=head.post;
            head.post.pre=node;
            head.post=node;
            node.pre=head;
            node.mulDirectionLinkedList=this;
        }
    }
}
