package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class leetcode914_卡牌分组 {
    /*
     *  卡牌分组：从给定的deck中选取一个数字x，如果deck各类牌的数目都可以被x整除
     * */
    public boolean hasGroupsSizeXo(int[] deck) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i <deck.length; i++) {
            set.add(deck[i]); //获取X的所有可能取值
        }
        Map<Integer,Integer> map=new HashMap<>(); //值与个数的k-v
        for (Integer i:
                deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count=0;
        for (Integer i:
                set) {
            if (i<2) continue;
            for (Integer j:
                    map.values()) {
                if (j>=i&&j%i==0){
                    count+=j/i;
                    if (count==set.size()){
                        return true;
                    }
                }else{ //当除不尽时说明不可整除
                    break;
                }
            }
            count=0;
        }
        return count==set.size();
    }
   /*
    *  实际上是求各个字符个数的最小公约数
    * */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>(); //值与个数的k-v
        for (Integer i:
                deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int x=0;
        for (Integer j:
                map.values()) {
            x=gcd(x,j);
            if(x==1){
                return false;
            }
        }
        return x>=2;
    }
    private int gcd (int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public static void main(String[] args) {
        new leetcode914_卡牌分组().hasGroupsSizeX(new int[]{
                1,2,3,4,4,3,2,1
        });
    }

}
