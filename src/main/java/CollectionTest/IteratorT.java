package CollectionTest;


import java.util.Iterator;
import java.util.Random;

public class IteratorT {

//    @Override
//    public Iterator iterator() {
//        return new Iterator() {
//            int cursor=1;
//            @Override
//            public boolean hasNext() {
//
//                return cursor++ <= size;
//            }
//
//            @Override
//            public Object next() {
//                return elementData[cursor];
//            }
//        };
//    }

    public static void main(String[] args) {
         Random a=new Random();
         int n=0;
         for (int i=0;i<100000;i++){
             if (a.nextInt(100)<=50){
               n++;
             }
         }
        System.out.println(1.0-9*.1);
    }
}
