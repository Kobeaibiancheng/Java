package collectionsframework;

public class SearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(8);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        //binarySearchTree.preOrder(binarySearchTree.root);
        binarySearchTree.remove(8);
        binarySearchTree.inorder(binarySearchTree.root);
        //System.out.println(binarySearchTree.root.right.data);
    }
}
