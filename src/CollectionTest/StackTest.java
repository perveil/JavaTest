package CollectionTest;

import javassist.bytecode.Descriptor;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * Stack 矢量队列，继承于Vector ，是使用数组实现栈
 * Stack<E> extends Vector<E>
 * */
public class StackTest {
    public static void main(String[] args) {
//       List<Integer> stack=new Stack(); //向上转型
        Stack<Integer> stack = new Stack();
        for (int a = 1; a < 4; a++) {
            stack.push(a);
        }
        // stack.push(1); 将元素推入栈顶
        //  stack.pop()  将一个元素从栈顶删除，实际上是调用Vectro的方法removeElementAt
        //  stack.peek() 返回栈顶元素，不执行删除操作
        //  stack.search() 搜索栈内元素，实际上是调用Vector的indexOf方法，返回数组的索引+1
        //遍历方法：1.for循环 2.iterator遍历
        for (Iterator iterator = stack.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
        stack.pop();
        for (Iterator iterator = stack.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next());
        }
    }
}
