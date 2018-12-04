package AlgorithmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* java 实现 全排列组合
*
* */
public class Arrange {

    public static void main(String[] args) {
           char [] aim={
                   'a','b','c'
           };
           Arrange(aim,0,aim.length-1);
    }
    public static void Arrange(char[] aim,int k,int m) {
       if (k==m){
           for (int i=0;i<=m;i++){
               System.out.print(aim[i]);
           }
           System.out.println();
       }else{
           for (int i=k;i<=m;i++){
              swap(aim,k,i);
              Arrange(aim, k+1, m);
              swap(aim,k,i);
           }
       }
    }
    public static void swap(char [] aim,int k,int m){
          char temp=aim[m];
          aim[m]=aim[k];
          aim[k]=temp;
    }
}
