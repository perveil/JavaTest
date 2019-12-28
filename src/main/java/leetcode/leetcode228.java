package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode228 {
    public static void main(String[] args) {
        new leetcode228().summaryRanges(new int[]{
                0,2,3,4,6,8,9
        });
    }
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result=new ArrayList<>();
        int head=nums[0]; //记录前一个数字
        int tail=nums[0];
        String res="";
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]-tail==1){
                tail=nums[i];
            }else{
                res=head==tail?head+"":head+"->"+tail;
                result.add(res);
                head=nums[i];
                tail=nums[i];
            }
        }
        if (head==tail) result.add(""+head);
        else  result.add(""+head+"->"+tail);
        return result;
    }
}
