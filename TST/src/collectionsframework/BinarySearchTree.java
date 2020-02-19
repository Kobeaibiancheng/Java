package collectionsframework;

public class BinarySearchTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;


    //插入
    public void insert(int key) {
        Node node = new Node(key);
        Node parent = null;
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else if (cur.data > key){
                parent = cur;
                cur = cur.left;
            }else {
                return;
            }
        }
        if (parent.data < key) {
            parent.right = node;
        }else{
            parent.left = node;
        }

    }



    //查找   key
    public Node search(int key) {
        if (root == null) {
            return null;
        }else {
            Node cur = root;
            while (cur != null) {
                if (cur.data > key) {
                    cur = cur.left;
                }else if (cur.data < key) {
                    cur = cur.right;
                }else {
                    return cur;
                }
            }
        }
        return null;
    }


    //遍历
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    //遍历
    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //删除关键字为key的节点
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                //找到了要删除的节点
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    public void removeNode(Node parent,Node cur){
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            //找右边的最小值
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            cur.data = target.data;
            //左节点肯定是 null
            if (target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }

        }
    }
}
