package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode299 {
    public String getHint(String secret, String guess) {
        String res="";
        Map<Character,Integer> secret_map=new HashMap<>();
        Map<Character,Integer> guess_map=new HashMap<>();
        int numofBulls=0;
        int numofCows=0;
        for (int i = 0; i <secret.length(); i++) {
            if (secret.charAt(i)==guess.charAt(i)){
                numofBulls++;
            }else {
                secret_map.put(secret.charAt(i),secret_map.getOrDefault(secret.charAt(i),0)+1);
                guess_map.put(guess.charAt(i),guess_map.getOrDefault(guess.charAt(i),0)+1);
            }
        }
        for (Character c:
             secret_map.keySet()) {
            numofCows+=guess_map.getOrDefault(c,0)>=secret_map.get(c)?secret_map.get(c):guess_map.getOrDefault(c,0);
        }
        res+=numofBulls+"A"+numofCows+"B";
        return res;
    }

    public static void main(String[] args) {
        new leetcode299().getHint(
                "1807","7810"
        );
    }
}
