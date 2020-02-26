package collectionsframework;

import java.util.*;

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


    //迭代前序遍历二叉树
    public List<Character> preOrderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.value);
                //System.out.print(cur.value + " ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
    /*public void preOrderTraversalNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.value + " ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;

        }
    }*/


    //迭代中序遍历二叉树
    public List<Character> inOrderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.value);
            //System.out.print(cur.value + " ");
            cur = cur.right;
        }
        return list;
    }
    /*public void inOrderTraversalNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }*/


    //迭代后序遍历二叉树
    public List<Character> postOrderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                list.add(cur.value);
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return list;
    }
    /*public void postOrderTraversalNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.print(cur.value + " ");
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
    }*/

    /*public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }*/
    //二叉树层序遍历
    public List<List<Character>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Character>> ret = new ArrayList<>();
        //List<Integer> list = new ArrayList<>();

        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                //assert cur != null;
                list.add(cur.value);
                size--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
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


    /*private boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }else if (leftTree == null) {
            return false;
        }else if (rightTree == null) {
            return false;
        }else {
            if (leftTree.value == rightTree.value) {
                return isSymmetricChild(leftTree.left,rightTree.right)
                        && isSymmetricChild(leftTree.right,rightTree.left);
            }else {
                return false;
            }
        }
    }*/
    private boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return false;
        }
        return leftTree.value == rightTree.value && isSymmetricChild(leftTree.left,rightTree.right)
                && isSymmetricChild(leftTree.right,rightTree.left);
    }
    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }


    //判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;

    }

}