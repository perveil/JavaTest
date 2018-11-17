package AlgorithmTest;

import java.util.Arrays;

/*
*  Z 字形排列成给定的行数：
*  思路：
*
*
* */
public class CreateZ {
    public static void main(String[] args) {
        System.out.println(createZ("ABCDEFGHIJKEFSDRX",5));
    }
    public static String createZ(String s,int numRows){
        if (s.length()<=numRows||numRows==1){
          return  s;
        }
        char [] aimChars=s.toCharArray();
        int temp=2*numRows-2;
        int scaleNum=aimChars.length/temp+1;
        StringBuilder []result=new StringBuilder[numRows];
        for (int r = 0; r <numRows ; r++) {
            result[r]=new StringBuilder();
        }
        int i=temp,j=0;
        for (int n=0; n <scaleNum ; j=i,i+=temp,n++) {
            if (i>aimChars.length-1){
                i-=temp;
                break;
            }
            result[0].append(aimChars[j]); //
            int head=j+1; //头
            int tail=i-1; //尾
            for (int k = 1; k < numRows; k++) {
                if (head<tail){
                    result[k].append(aimChars[head]).append(aimChars[tail]);
                }else if(head==tail){
                    result[k].append(aimChars[head]);
                }else{
                    continue;
                }
                head++;
                tail--;
            }
        }
        if (i<=aimChars.length-1){
            result[0].append(aimChars[i]);
            for (int k = 1; k < numRows; k++) {
                if (i<aimChars.length-1){
                    result[k].append(aimChars[++i]);
                }else{
                    break;
                }

            }
        }
        String resultT="";
        for (int q = 0; q <numRows ; q++) {
            resultT+=result[q];

        }
        return resultT.replaceAll(" ","");


    }
}
