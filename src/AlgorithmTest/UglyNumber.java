package AlgorithmTest;
/*
*
* 题目:我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求从小到大的顺序的第 1500个丑数。
* */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(findIndexOfUglyNumber(150));
        System.out.println(BetterMethodOfUglyNumber(150));
    }
    public static int  findIndexOfUglyNumber(int index){
        int modIndex=0;
        int num=1;
        while(modIndex<index){
            if (isUgly(num)){
                modIndex++;
            }
            num++;
        }
        return --num;
    }

    public static boolean isUgly(int num){

        while(num%2==0){
            num /=2;
        }
        while(num%3==0){
            num /=3;
        }
        while(num%5==0){
            num /=5;
        }
        return num==1?true:false;


    }
    /*
    *优化的核心是只操作丑数，而不操作其他数，时间复杂度大幅提高。
    * */
    public static int  BetterMethodOfUglyNumber(int index){

        int [] aimNumArray=new int[index];  //初始化目标数组
        aimNumArray[0]=1; //1是第一个丑数
        int nextIndex=1;// 从第二个丑数开始计算
        /*
        *
        * */
        int tIndexOf2=0;
        int tIndexOf3=0;
        int tIndexOf5=0;

        while(nextIndex<index){
            int minNum= min(aimNumArray[tIndexOf2]*2,aimNumArray[tIndexOf3]*3,aimNumArray[tIndexOf5]*5);
            aimNumArray[nextIndex]=minNum;
            /*
            *z之前的丑数是有序排列的，所以为了优化算法，寻找边界值
            * */
            while(aimNumArray[tIndexOf2]*2<=aimNumArray[nextIndex]){
                ++tIndexOf2;
            }
            while(aimNumArray[tIndexOf3]*3<=aimNumArray[nextIndex]){
                ++tIndexOf3;
            }
            while(aimNumArray[tIndexOf5]*5<=aimNumArray[nextIndex]){
                ++tIndexOf5;
            }
            ++nextIndex;
        }
        return aimNumArray[nextIndex-1];
    }
    //求出三个值的最小值
    public static int min(int numfor2,int numfor3,int numfor5){
        int min=numfor2>numfor3 ? numfor3:numfor2;
        return min=min>numfor5?numfor5:min;
    }
}
