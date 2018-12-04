package AlgorithmTest;
/*
*
* */
public class MostWater2 {
    public static void main(String[] args) {
        int [] numbers={1,8,6,2,5,4,8,3,7};
        maxArea(numbers);
    }

    public static int maxArea(int[] height) {
        boolean flag=true;
        int result=0;
        int temp=1;
        int startIndex=-1;
        int endIndex=-1;
        while(flag){
            for(int i=0;i<height.length;i++){
                if(height[i]>=temp&&startIndex==-1){
                    startIndex=i;
                    for(int j=height.length-1;j>i;j--){
                        if(height[j]>=temp){
                            endIndex=j;
                            if(temp*(endIndex-startIndex)>result){
                                result=temp*(endIndex-startIndex);
                            }
                            temp++;
                            break;
                        }
                    }
                    if(endIndex==-1){
                        flag=false;
                    }
                    break;
                }
            }
            if (startIndex==-1){
                break;
            }
            startIndex=-1;
            endIndex=-1;
        }
        return result;
    }
}
