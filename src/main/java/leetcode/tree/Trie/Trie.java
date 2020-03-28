package leetcode.tree.Trie;
/*
* 字典树/前缀树/
* */
public class Trie {
    private final int AlPHA_SIZE=26;
    private Trie[] child=new Trie[AlPHA_SIZE];
    boolean isEndOFWord=false;
    public Trie() {}
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp=this;
        for (char c:
             word.toCharArray()) {
            if (temp.child[c-'a']==null){  //c不在tmp的子节点中
                temp.child[c-'a']=new Trie();
            }
            temp=temp.child[c-'a'];
        }
        temp.isEndOFWord=true; //temp 已经到了word的最后一个字符
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp=this;
        for (char i : word.toCharArray()) {
            if (temp.child[i-'a']==null){
                return  false;
            }
            temp=temp.child[i-'a'];
        }
        return temp.isEndOFWord?true:false;
        //当这个word的最后一个字符是Trie树的叶子节点时，则这个word存在于Trie树中
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char i : prefix.toCharArray()) {
            if (tmp.child[i-'a'] == null) {
                return false;
            }
            tmp = tmp.child[i-'a'];
        }
        return true;
    }
}
