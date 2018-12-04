package DataType;

import java.util.Random;

public class RandomT {
    public static void main(String[] args) {
        Random a=new Random();
        int n=0;
        for (int i=0;i<100000;i++){
            if (a.nextInt(100)<=50){
                n++;
            }
        }
        System.out.println(n);
    }
}
