package leetcode;

public class leetcode556 {
    public static void main(String[] args) {
        System.out.println(
                new leetcode556().nextGreaterElement(1999999999)
        );
    }


    public int nextGreaterElement(int n) {
       char [] len =new String(""+n).toCharArray();
       int [] aima=new int[len.length];
        for (int i = 0; i <len.length ; i++) {
            aima[i]=len[i]-'0';
        }
        if (nextPermutation(aima)){
            int result=0;
            for (int i = 0; i <aima.length ; i++) {
                result+=aima[i]*Math.pow(10,aima.length-i-1);
                if (result==-2147483648) return -1;
            }
            return result> Integer.MAX_VALUE?-1:result;
        }else {
            return -1;
        }
    }
    public boolean nextPermutation(int[] nums) {
        if (nums.length==0) return false;
        int len=nums.length;
        int i=len-1;
        while(i>0&&nums[i-1]>=nums[i]){  //找到尾部的逆序序列
            i--;
        }
        //旋转逆序数组
        for (int j = i; j <=(i+len-1)/2 ; j++) {
            int temp=nums[j];
            nums[j]=nums[(i+len-1)-j];
            nums[(i+len-1)-j]=temp;
        }
        if (i>0){
            for (int j = i; j <len ; j++) {
                if(nums[j]>nums[i-1]){
                    int temp=nums[i-1];
                    nums[i-1]=nums[j];
                    nums[j]=temp;
                    break;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}
