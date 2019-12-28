package leetcode;
/*
* 与字符串相乘与异曲同工之妙
* */
public class leetcode415 {
    public static void main(String[] args) {
        System.out.println(
                new leetcode415().addStrings("9","52")
        );
    }
    public String addStrings(String num1, String num2) {
        if (num1.length()<num2.length()){
            return addStrings(num2,num1);
        }
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+1];
        for(int i=m-1,j=n-1; i >= 0; i--) {
            int add=0;
            if (j>=0){
                    add = (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
                    j--;
               }else
                   add = (num1.charAt(i) - '0') +pos[i];
                int p1 = i , p2 = i + 1;
                int sum = add + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
