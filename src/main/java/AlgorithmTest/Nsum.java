package AlgorithmTest;

import java.util.*;

/*
*Nsum 问题
*
* 2sum问题
*  思路：头尾双向遍历
* 3sum问题
*
* 4sum问题
*
*
* */
interface Nsuminter{
    void TSum(int [] Arr,int target);
    void ThSum(int [] Arr,int target);
    void FSum(int [] Arr,int target);
}
public class Nsum {


    public static void main(String[] args) {
        int Arr[]={1,0,5,3,3,2,2,2,4,9};
        //1.2,2,3,3,4,5
//        TSum(Arr,5,0,Arr.length-1);
      ThSum(Arr,5);
    }
    //2 Sum

    public static  List<List<Integer>>  TSum(int [] Arr,int target,int start,int end) {
        Arrays.sort(Arr); //排序
       int head=start;
       int tail=end;
       List<List<Integer>> result=new ArrayList<>();
       while(head<tail){
           if (Arr[head]+Arr[tail]>target){
               tail--;
           }else if (Arr[head]+Arr[tail]<target){
               head++;
           }else{
               if (head>1&&Arr[head-1]==Arr[head]&&Arr[tail+1]==Arr[tail]){
                   head+=2;
                   tail+=2;
                   continue;
               }
               List<Integer>  tempList= new ArrayList<>();
                   tempList.add(Arr[head]);
                   tempList.add(Arr[tail]);
                   result.add(tempList);
                   head++;
                   tail--;
           }
       }
     //  System.out.println(result);
       return result;
    }


    public static List<List<Integer>> ThSum(int [] Arr,int target) {
        Arrays.sort(Arr);
        List<List<Integer>> result=new ArrayList<>();
         for (int i=0;i<Arr.length;i++){
              List<List<Integer>> TList=TSum(Arr,target-Arr[i],i+1,Arr.length-1);
              int size=TList.size();
              if (size>0){
                  for (int j=0;j<size;j++){
                      List<Integer>  tempList= new ArrayList<>();
                      tempList.addAll(TList.get(j));
                      tempList.add(Arr[i]);
                      result.add(tempList);
                  }
              }
         }
         System.out.println(result);
         return result;
    }


    public static void FSum(int [] Arr,int target) {

    }
}
