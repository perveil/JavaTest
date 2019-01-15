package DataStructure;
/*
*   数据结构之字典树
* */
public class TireTree {
    private TrieNode root ;
    TireTree() // 初始化字典树
    {
        root = new TrieNode();
    }
    //插入一个字符串
    public void insert(String str){
        if (str == null || str.length() == 0)
        {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();//将目标单词转换为字符数组
        for (int i = 0, len = str.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)  //如果当前节点的儿子节点中没有该字符，则构建一个TrieNode并复值该字符
            {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            }
            else   //如果已经存在，则将由根至该儿子节点组成的字符串模式出现的次数+1
            {
                node.son[pos].num++;
            }
            node = node.son[pos];  //字典树的延申
        }
        node.isEnd = true;  //到了字典树的叶子节点，node.isEnd =true
    }
    //判断是否有某个单词(按照某种顺序)
    public boolean has(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        TrieNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]!=null)
            {
                node=node.son[pos];
            }
            else
            {
                return false;
            }
        }
        //走到这一步，表明可能完全匹配，也可能部分匹配，如果最后一个字符节点为末端节点，则是完全匹配，否则是部分匹配
        return node.isEnd;
    }
    // 打印指定前缀的单词
    public String hasPrefix(String prefix)
    {
        if (prefix == null || prefix.length() == 0)
        {
            return null;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)
            {
                return null;
            }
            else
            {
                node = node.son[pos];
            }
        }
        preTraverse(node, prefix);
        return null;
    }
    //前序遍历
    public void preTraverse(TrieNode node, String prefix)
    {
        if (!node.isEnd)
        {
            for (TrieNode child : node.son)
            {
                if (child != null)
                {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }
     //静态内部类
      class TrieNode{
        private int num;// 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private  TrieNode[] son;// 所有的儿子节点
        private boolean isEnd;// 是不是最后一个节点
        private char val;// 默认节点的值

        TrieNode()
        {
            num = 1;
            son = new TrieNode[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        new TireTree().insert("abcdefg");
    }
}
