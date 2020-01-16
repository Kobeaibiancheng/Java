package collectionsframework;

class TreeNode {
    public char value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char value) {
        this.value = value;
    }
}

public class BinaryTree {
    public TreeNode createTree() {
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    //递归前序遍历
    public  void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //递归中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }
    //递归后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 子问题思路 - 二叉树节点的个数
     * 等于左子树的节点个数 + 右子树的节点个数
     */
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int size = getSize(root.left) + getSize(root.right) + 1;
        return size;
    }

    //子问题思路 - 求叶子节点
    public int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }else if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

}
