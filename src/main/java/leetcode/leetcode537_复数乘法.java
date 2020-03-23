package leetcode;

public class leetcode537_复数乘法 {
    public String complexNumberMultiply(String a, String b) {
        int[] numa=split(a);
        int[] numb=split(b);
        int res01=numa[0]*numb[0]-(numa[1]*numb[1]); //实数部
        int res02=numa[0]*numb[1]+numa[1]*numb[0];   //虚数部
        return res01+"+"+res02+"i";

    }
    public int[] split(String a) {
        int[] numa=new int[2];
        int indexOfPlus=a.indexOf("+");
        numa[0]=Integer.parseInt(a.substring(0,indexOfPlus));
        numa[1]=Integer.parseInt(a.substring(indexOfPlus+1,a.length()-1));
        return numa;
    }

    public static void main(String[] args) {
        new leetcode537_复数乘法().complexNumberMultiply("1+-1i","1+-1i");
    }
}
