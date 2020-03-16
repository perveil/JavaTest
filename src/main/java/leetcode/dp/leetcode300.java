package leetcode.dp;

/*
*  尝试一次：失败，思路错误
*  尝试第二次：依然使用第一次的dp思路
* */
public class leetcode300 {
    public static void main(String[] args) {
        System.out.println(
                longestIncreamentSeq(
                        new int[]{
                                10,9,2,5,3,7,101,18
                        }

                )
        );
    }
    public  static  int longestIncreamentSeq(int [] nums){
        if(nums.length==0){
            return 0;
        }
        int result=1;
        int resultArray []=new int [nums.length]; //dp的目标数组
        for (int i = 0; i <resultArray.length ; i++) { //初始化
            resultArray[i]=1;
        }
        for (int i = 1; i <nums.length ; i++) {
            int max=1;
            for (int j = i-1;j >-1 ;j--) {
                if (nums[i]>nums[j] && resultArray[j]+1>max) {
                    resultArray[i] = resultArray[j] + 1;
                    max= resultArray[i];
                }
            }
            if (result<max) result=max;
        }
         return result;
    }
    //二分查找法
    /*
    * 首先将第一个元素存入vec数组，然后依次看后面的元素。若后面的元素大于vec数组的最后一个元素，则将其加入到vec末尾，否则将它替换掉vec数组中第一个大于等于它的元素。最后返回vec的大小即可
    *
    * */
    public  static  int BlongestIncreamentSeq(int [] nums){
        if (nums.length<=1){
            return  nums.length;
        }
        int resultlist []=new int [nums.length]; // 二分查找
        resultlist[0]=nums[0];
        int res=0;
        for (int i = 1; i <nums.length; i++) {
            if (nums[i]>resultlist[res]){
                resultlist[++res]=nums[i];
            }else{
                int l=0;
                int r=res;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    // 如果存在就不替换对应元素
                    if (resultlist[mid] == nums[i]) {
                        l = mid;
                        break;
                    } else if (resultlist[mid] >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                resultlist[l]=nums[i];
            }
        }
        return res++;
    }
}
