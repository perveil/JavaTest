package AlgorithmTest;
/*
  设计一种栈，要求添加一个min函数来寻找栈中的最小元素，要求增加、找最小值、删除时间复杂度都是O(1)
  思路: 使用数组来存储，之后用一个MInIndex来记录最小值的索引值，实现O(1)的时间复杂度来访问最小值
  是一种牺牲空间而挽回时间的做法
 * */
class Node{
   public int value;
    Node(int value){
       value=value;
    }
}
class minStack{
     static  Node nodes[]; //把最小值的节点放在 数组的第一位
     static int MinIndex=0;
     static int Currentindex=0;
     public static void push(Node node){
         if (Currentindex!=0) {
             nodes[Currentindex] = node;
             Currentindex++;
             if (node.value < nodes[MinIndex].value) {
                 MinIndex = Currentindex;
             }
         }else{
             nodes[0]=node;
         }
     }
    public static Node poll(){
         Node Temp=nodes[Currentindex];
        nodes[Currentindex]=null;
        return Temp;

    }
    public  static  Node getMin(){
         return nodes[MinIndex];
    }
}

public class NewStackTest {
    public static void main(String[] args) {

    }
}
