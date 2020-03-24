package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode1002_查找常用字符 {
    /*
    *  暴力思路：
    *  set 存储着在第一个字符串中出现的字符，也就说 常用字符 一定在此Set中
    *  charnum 存储的是公共字符的出现次数
    * */
    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<>();
        Set<Character> set= new HashSet<Character>();
        int [] charnum=new int[26];
        for(int i=0;i<A[0].length();i++){
            set.add(A[0].toCharArray()[i]); // 获得在第一个串中出现的字符
            charnum[A[0].toCharArray()[i]-'a']++;
        }
        for (int i = 1; i <A.length ; i++) {
            int [] charnum_temp=new int[26];
            for (int j = 0; j <A[i].length() ; j++) {
               if (set.contains(A[i].toCharArray()[j])){  //如果在Set中，charnum_temp对应字符++
                   charnum_temp[A[i].toCharArray()[j]-'a']++;
               }
            }
            /*
            * 交集，共同字符取最小
            * */
            for (int j = 0; j <26; j++) {
                charnum[j]=Math.min(charnum[j],charnum_temp[j]);
            }
        }
        for (int i = 0; i <26 ; i++) {
            if (charnum[i]>0){
                for (int j = 0; j <Math.abs(charnum[i]); j++) {
                    res.add(""+(char)('a'+i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1002_查找常用字符().commonChars(new String[]{
                "cool"
        });
    }
}
