package leetcode.tree.Trie;

import java.util.Arrays;

public class leetcode820_单词压缩 {
    public int minimumLengthEncoding(String[] words) {
        int len=0;
        Trie trie=new Trie();
        Arrays.sort(words,(s1,s2)->s2.length() - s1.length());
        /*
        * words 依据长度从大到小的排序=》先插入长度较长的字符串，以免重复变换len
        * */
        for (String s:words){
            len+= trie.insert(new StringBuilder(s).reverse().toString());
        }
        return len;
    }
    /*
    * 写一个静态内部类
    * */
    static class Trie{
        private final int AlPHA_SIZE=26;
        private Trie[] child=new Trie[AlPHA_SIZE];
        public Trie() {}
        /** Inserts a word into the trie. */
        public int insert(String word) {
            Trie temp=this;
            boolean isNew = false;
            for (char c:
                    word.toCharArray()) {
                if (temp.child[c-'a']==null){  //c不在tmp的子节点中
                    isNew=true; //出现新节点
                    temp.child[c-'a']=new Trie();
                }
                temp=temp.child[c-'a'];
            }
            return isNew?word.length()+1:0;
            // 没出现新节点就返回0
        }
    }
}
