package collectionsframework;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createTree();

        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.postOrderTraversalNor(root));
        /*binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.inOrderTraversalNor(root));*/
        //binaryTree.preOrderTraversal(root);
        //System.out.println(binaryTree.preOrderTraversalNor(root));

        System.out.println(binaryTree.levelOrder(root));
    }

}
