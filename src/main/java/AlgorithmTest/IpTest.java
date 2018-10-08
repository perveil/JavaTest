package AlgorithmTest;

/*  给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
*IP地址由32位二进制数组成，为便于使用，常以XXX.XXX.XXX.XXX形式表现，每组XXX代表小于或等于255的10进制数。
* 所以说IP地址总共有四段，每一段可能有一位，两位或者三位，范围是[0, 255]，题目明确指出输入字符串只含有数字，
* 所以当某段是三位时，我们要判断其是否越界（>255)，还有一点很重要的是，当只有一位时，0可以成某一段，如果有两
* 位或三位时，像 00， 01， 001， 011， 000等都是不合法的，
* */
import java.util.ArrayList;

public class IpTest {
    public static void main(String[] args) {
        sToIpRes("25525511135");
    }
    public static void sToIpRes(String str){
        ArrayList<String> result=new ArrayList<String>();
        int len=str.length();
        for(int i=1;i<4&&i<len-2;i++){   //-2 而不是减3是因为截取是从i开始的 i>=1
            for(int j=i+1;j<i+4&&j<len-1;j++){
                for(int k=j+1;k<j+4&&k<len;k++){
                    if(len-k>=4)
                        continue;
                    int a=Integer.parseInt(str.substring(0,i));
                    int b=Integer.parseInt(str.substring(i,j));
                    int c=Integer.parseInt(str.substring(j,k));
                    int d=Integer.parseInt(str.substring(k));
                    //parseInt(String )  如果是以0开头就会被去掉0
                    if(a>255||b>255||c>255||d>255){
                        continue;
                    }
                    String ip=a+"."+b+"."+c+"."+d;
                    if(ip.length()<len+3){  //看数据有没有丢失
                        continue;
                    }
                    result.add(ip);

                }
            }
        }
        System.out.println(result);

    }
}
