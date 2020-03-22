package leetcode;

public class leetcode13_罗马数字转数字 {
    /*
    * 小值在大值左边为大值减去小值，在右边为大值
    * X   X  I  V
    * 10 10 -1  5
    * */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));  //记录前一位的所表示的数值
        for (int i = 1; i <s.length() ; i++) {
            int curnum=getValue(s.charAt(i));
            if (preNum<curnum){
                sum-=preNum;
            }else {
                sum+=preNum;
            }
            preNum=curnum;
        }
        sum+=preNum; // 最后一位

        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
