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

    //子问题思路 - 求第k层节点个数
    public int getKLevelSize(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }

    //前序遍历查找value所在的节点
    public TreeNode find(TreeNode root,int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        TreeNode ret = find(root.left, value);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right, value);
        if (ret != null) {
            return ret;
        }
        return null;
    }
    //相同树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.value != q.value) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一个树的子树
    public boolean isSubTree(TreeNode s,TreeNode t) {
        if (s == null || t == null) return false;
        if (isSameTree(s,t)) return true;
        if (isSubTree(s.left,t)) return true;
        if (isSubTree(s.right,t)) return true;
        return false;
    }

}