package leetcode.tree.seqtree;

public class SeqTree {
    private Integer length=100;
    private SeqTreeNode[] seqTreeNodes=new SeqTreeNode[this.length];
    private int [] nums;
    private int numsLength;
    public SeqTree(int length,int [] nums){
        this.nums=nums;
        numsLength=nums.length;
        createSeqTree(0,nums,0,length-1); //构造线段树
    }
    static  class SeqTreeNode{
        Integer val;
        int addMark;   //延迟标记:更新区间节点而不是去更新叶子节点，称为延迟标记
        SeqTreeNode(int val){
            this.val=val;
        }
    }
    //构建一颗线段树
    private void  createSeqTree(int root, int arr[], int istart, int iend){
        if(iend==istart){  //叶子节点
            seqTreeNodes[root]=new SeqTreeNode(arr[istart]);
        }else{
            int mid=(istart+iend)/2;
            createSeqTree(root*2+1,arr,istart,mid);  //左子树  2*root+1是因为线段树是一颗完全二叉树，所以寻找左子树的索引计算方式是 2*root+1
            createSeqTree(root*2+2,arr,mid+1,iend); //右子树 寻找右子树的索引计算方式是  2*root+2
            seqTreeNodes[root]=new SeqTreeNode(Math.min(seqTreeNodes[root*2+1].val, seqTreeNodes[root*2+2].val));
        }
    }
    /*
    *  每一颗子树的根节点代表着某一个区间的最小值
    *  root 代表线段树当前节点下标 初始为0
    *  [nstart,nend] 代表当前节点所表示的区间，初始值为 [0,length-1]
    *  [qstart,qend] 代表目标区间
    * */
    public int query(int root, int nstart, int nend, int qstart, int qend){
        if(qstart > nend || qend < nstart)    //目标区间与查询区间无交集
         return Integer.MAX_VALUE;
        if (qstart <= nstart && qend >= nend){ //查询区间在目标区间之间时，直接返回此时的根节点，需要注意的是[0,3]
            return seqTreeNodes[root].val;
        }
        int mid=(nstart+nend)/2;
        return Math.min(
                query(root*2+1,nstart,mid,qstart,qend),
                query(root*2+2,mid+1,nend,qstart,qend)
        );
    }
    /*
    *  线段树的单点更新，更新单点不就是更新叶子节点，所以问题转化成寻找叶子节点，而由线索树的特征可知，叶子节点所表示的区间是具体到某一个值
    *  例如：数组索引为3的节点 指的是[3,3] 的最小值
    * */
    public void  update(int root,int nstart, int nend, int index,int addval){
        if (nstart==nend){
            if (index==nstart){
                seqTreeNodes[root].val+=addval;
            }
            return;
        }
        int mid=(nstart+nend)/2;
        if (index<=mid){   //左子树更新
            update(root*2+1, nstart, mid, index, addval);
        }else {  //右子树更新
            update(root*2+2,  mid+1, nend, index, addval);
        }
        //更新之后回溯更改根节点的值
       seqTreeNodes[root].val=Math.min(seqTreeNodes[root*2+1].val,seqTreeNodes[root*2+2].val);
    }


    public static void main(String[] args) {
       SeqTree seqTree= new SeqTree(6,new int[]{
                2,5,1,4,9,3
        });
        System.out.println(seqTree.query(0,0,5,2,4));
    }
}
