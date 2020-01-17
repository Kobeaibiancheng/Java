package collectionsframework;

public class Test {

        public static void main(String[] args) {
                BinaryTree binaryTree = new BinaryTree();
                TreeNode root = binaryTree.createTree();
                binaryTree.preOrderTraversal(root);
                System.out.println();
                binaryTree.inOrderTraversal(root);
                System.out.println();
                binaryTree.postOrderTraversal(root);
                System.out.println(binaryTree.getSize(root));
                System.out.println(binaryTree.getLeafSize(root));
                System.out.println(binaryTree.getKLevelSize(root,3));
                MySingleStack mySingleStack = new MySingleStack();
                System.out.println(mySingleStack.push(10));
                System.out.println(mySingleStack.push(20));
                System.out.println(mySingleStack.push(30));
                System.out.println(mySingleStack.peek());
                System.out.println(mySingleStack.pop());
                System.out.println(mySingleStack.peek());
                MyCircularQueue myCircularQueue = new MyCircularQueue(5);
                myCircularQueue.enQueue(5);
                myCircularQueue.enQueue(4);
                myCircularQueue.enQueue(2);
                myCircularQueue.enQueue(1);
                System.out.println(myCircularQueue.enQueue(6));
                System.out.println(myCircularQueue.front());
                System.out.println(myCircularQueue.Rear());


                MyListQueue myListQueue = new MyListQueue();
                myListQueue.offer(5);
                myListQueue.offer(2);
                myListQueue.offer(1);
                myListQueue.offer(4);
                myListQueue.offer(6);
                System.out.println(myListQueue.peek());//5
                System.out.println(myListQueue.poll());//5
                System.out.println(myListQueue.peek());//2
                MyStack<Integer> myStack1 = new MyStack<>();
                myStack1.push(1);
                myStack1.push(2);
                myStack1.push(30);
                myStack1.push(40);
                myStack1.push(50);
                myStack1.push(60);
                myStack1.push(70);
                myStack1.push(80);
                myStack1.push(90);
                myStack1.push(100);
                myStack1.push(110);
                System.out.println(myStack1.pop());//40
                System.out.println(myStack1.peek());//30
                MyStack<String> myStack2 = new MyStack<>();
                myStack2.push("hello");
                myStack2.push("world");
                myStack2.push("!!!");
                System.out.println(myStack2.pop());//!!!
                System.out.println(myStack2.peek());//world
                MyArrayList<String> myArrayList1 = new MyArrayList<>();
                myArrayList1.add("hello");
                myArrayList1.add("world");
                myArrayList1.add("!!!");
                System.out.println(myArrayList1.get());
                MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
                myArrayList2.add(1);
                myArrayList2.add(2);
                myArrayList2.add(3);
                System.out.println(myArrayList2.get());
                //MyArrayList<int> myArrayList3 = new MyArrayList<>();  错误的*/
    }
}
