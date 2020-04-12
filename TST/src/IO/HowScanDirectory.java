package IO;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class HowScanDirectory {
    public static void main(String[] args) {
        File root = new File("E:\\Test");
        travelDepth(root);
        System.out.println("===========================");
        travelBroad(root);

    }

    private static void travelBroad(File root) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File front = queue.remove();
            System.out.println(front.getAbsolutePath());
            if (front.isDirectory()) {
                File[] files = front.listFiles();
                if (files != null) {
                    for (File file : files) {
                        queue.offer(file);
                    }
                }
            }
        }
    }

    //深度优先遍历
    private static void travelDepth(File node) {
        System.out.println(node.getAbsolutePath());
        //判断 node 是不是叶子节点
        if (node.isDirectory()) {
            File[] files = node.listFiles();
            if (files != null) {
                for (File file : files) {
                    travelDepth(file);
                }
            }
        }
    }


}
