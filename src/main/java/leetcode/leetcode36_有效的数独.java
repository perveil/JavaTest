package leetcode;/*
  @Date:2020/4/27 11:27
  @Author:Administrator
*/

import java.util.*;

public class leetcode36_有效的数独 {
    List<ArrayList<Integer>> rows=new ArrayList<>();
    List<ArrayList<Integer>> cols=new ArrayList<>();
    List<ArrayList<Integer>> sub=new ArrayList<>();
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <board.length; i++) {
            rows.add(new ArrayList<>());
            cols.add(new ArrayList<>());
            sub.add(new ArrayList<>());
        }
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if(board[i][j]!='.'){ //是个数字
                    //验证行
                    //之前存在的话就说明重复，返回即可
                    if (rows.get(i).contains(Integer.valueOf(board[i][j]))){
                        return false;
                    }else {
                        rows.get(i).add(Integer.valueOf(board[i][j]));
                    }
                    //验证列
                    if (cols.get(i).contains(Integer.valueOf(board[i][j]))){
                        return false;
                    }else {
                        cols.get(i).add(Integer.valueOf(board[i][j]));
                    }
                    //验证子数组
                    int x=(i/3)*3+j/3;
                    if (sub.get(x).contains(Integer.valueOf(board[i][j]))){
                        return false;
                    }else {
                        sub.get(x).add(Integer.valueOf(board[i][j]));
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode36_有效的数独().isValidSudoku(new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        });
    }

}
