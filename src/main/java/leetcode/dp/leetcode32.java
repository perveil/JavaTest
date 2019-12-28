package leetcode.dp;

public class leetcode32 {

    /*
    *  每产生一对括号，结果加2
    *  1 表示状态‘(’ -1 表示状态 ‘)’
    *
    *
    * */
    public static void main(String[] args) {
        
        System.out.println(
                new leetcode32().longestValidParentheses(
                        "()(())"
                )
        );
    }
    public int longestValidParentheses(String s) {
        int result=0;
        char [] temp=s.toCharArray();
        int  [] aim=new int[s.length()];
        for (int i = 0; i <aim.length; i++) {
            aim[i]=temp[i]=='('?1:-1; //状态转换为 1，-1
        }
        int dp[]=new int[s.length()];   //dp数组
        int ans[]=new int[s.length()];  //记录第i位的状态是否得到匹配，如果匹配为1，不匹配为0,均初始化为0
        for (int i = 0; i <temp.length ; i++) {
            for (int j = i-1; j >-1 ; j--) {
                if (ans[j]==0&&aim[i]<0&&aim[j]+aim[i]==0){
                    if (dp[j]+2>dp[i]) ans[i]=ans[j]=1;
                    else ans[j]=0;
                    dp[i]=Math.max(dp[j]+2,result+2); //设置状态转换
                }
                else{
                    dp[i]=result;
                }
            }
        }
        return result;
    }
}
