package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode118Or119 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows==0) return null;
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        List<Integer> level_0=new ArrayList<>();
        level_0.add(1);
        levels.add(level_0); //加入第一层
        for (int i = 1; i <numRows; i++) {
             List<Integer> i_level=new ArrayList<>();
             i_level.add(1);
            for (int j = 2; j <(i+1); j++) {
                i_level.add(levels.get(i-1).get(j-1)+levels.get(i-1).get(j-2));
            }
            i_level.add(1);
            levels.add(i_level);
        }
        return  levels;
    }

    public static void main(String[] args) {
        new leetcode118Or119().generate(2);
    }
}
