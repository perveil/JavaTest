package leetcode;
/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* 思路一：lettcode 42  效率上不去，超出时间限制 是因为++ 的计算方法多次遍历整个数组，就会使得n*n 得时间复杂度
* 思路二： 找到最高的，然后向两边遍历，遍历左右两边，就计算能呈多少水，然后继续改变最高点
* */
public class leetcode42 {
    public static void main(String[] args) {
      int [] height={0,1,0,2,1,0,1,3,2,1,2,1};
      mostWater(height);
    }
    public static void mostWater(int[] height){
        boolean flag=true;
        int result=0;
        int startIndex=-1;
        int endIndex=-1;
        while(flag){
            for (int i = 0; i <height.length ; i++) {
                if (height[i]>0&&startIndex==-1&&endIndex==-1) {
                    startIndex = i;
                }
                if (height[i]>0&&startIndex!=-1){
                    endIndex=i;
                    if (endIndex-startIndex>0){
                        result+=(endIndex-startIndex-1);
                    }
                    startIndex=endIndex;
                    endIndex=-1;
                }
            }
            for (int i = 0; i <height.length ; i++) {
                if (height[i]-1>=0){
                     height[i]=height[i]-1;
                }else {
                    height[i]=0;
                }
            }
            if (isEmpty(height)){
                continue;
            }else {
                break;
            }
        }
       System.out.println(result);
    }
    public static boolean  isEmpty(int[] height){
        int num=0;
        for (int i = 0; i <height.length ; i++) {
            if (height[i]>0){
                num++;
            }
        }
        return num<=1?false:true;
    }

}
