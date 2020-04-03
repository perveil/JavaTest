package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode297_二叉树的序列化和反序列化 {
    public String serialize(TreeNode root) {
        return  rserialize(root,"");
    }
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    /*
    * 完全二叉树非递归的构造，层次遍历
    * */
    public TreeNode deserialize(String data) {
        if (data.equals("")||data.equals("[]")) return null;
        data = data.trim();                         //去除空格
        data = data.substring(1, data.length() - 1); //去除[ 、]
        if (data.length() == 0) {
            return null;
        }

        String[] parts = data.split(",");  //split by ,
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));  //root
        Queue<TreeNode> nodeQueue = new LinkedList<>();  //节点队列，先进先出
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) { //遍历结束
                break;
            }

            item = parts[index++];     //node 的左节点
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {  //遍历结束
                break;
            }

            item = parts[index++];         //node的右节点
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
