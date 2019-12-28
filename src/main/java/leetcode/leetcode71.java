package leetcode;

import java.util.Stack;

public class leetcode71 {
    public static void main(String[] args) {
        new leetcode71().simplifyPath("/a/./b/../../c/");
    }
    public String simplifyPath(String path) {
        String [] aims=path.split("/");
        Stack<String> stack=new Stack<>();
        for (int i = 0; i <aims.length ; i++) {
            if (aims[i].equals("")){
                continue;
            }else if (aims[i].equals("..")){
                stack.pop();
            }else if (aims[i].equals(".")){

            }else{

            }
        }
        return "";
    }
}
