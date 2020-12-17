package ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int x;
    int y;
    char type;

    public Node(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
class LinearClassifier {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int lines = sc.nextInt();
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            char type = sc.next().charAt(0);
            Node node = new Node(x,y,type);
            if (type == 'A'){
                listA.add(node);
            }else {
                listB.add(node);
            }
        }
        for (int i = 0; i < lines; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int count = 0;
            for (int j = 0; j < listA.size(); j++) {
                if ((-a-b*(listA.get(j).x)/c < listA.get(j).y)) {
                    count++;
                }else {
                    count--;
                }
            }
            if (count != 0) {
                System.out.println("No");
                continue;
            }
            for (int j = 0; j < listB.size(); j++) {
                if ((-a-b*(listB.get(j).x)/c < listB.get(j).y)) {
                    count++;
                }else {
                    count--;
                }
            }
            if (count != 0) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }
    }
}
