package IO;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //传入路径（Path）,构造文件对象
        //路径可以是绝对路径，也可以是相对路径
        /*{
            File file = new File("E:\\Test\\src");
            System.out.println(file);
            System.out.println(file.exists());//是否存在
            System.out.println(file.getName());//获得名字
            System.out.println(file.isFile());//是否是普通文件
            System.out.println(file.isHidden());//是否是隐藏文件
            System.out.println(file.isDirectory());
            System.out.println(file.canRead());//是否有可读权限
            System.out.println(file.canWrite());//是否有可写权限
            System.out.println(file.canExecute());//是否有可执行权限
        }


        //传入一个父路径
        {
            String parent = "E:\\Test\\src";
            String path = "新建文本文档.txt";
            File file = new File(parent,path);
            System.out.println(file);

            //常见的用法
            System.out.println(file.exists());//是否存在
            System.out.println(file.getName());//获得名字
            System.out.println(file.isFile());//是否是普通文件
            System.out.println(file.isHidden());//是否是隐藏文件
            System.out.println(file.isDirectory());
            System.out.println(file.canRead());//是否有可读权限
            System.out.println(file.canWrite());//是否有可写权限
            System.out.println(file.canExecute());//是否有可执行权限
        }*/


        //演示文件的创建过程
        /*{
            String parent = "E:\\Test\\src";
            String fileName = "kobe";
            File file = new File(parent,fileName);
            boolean success = file.createNewFile();
            if (success) {
                System.out.println(fileName + "创建成功");
            }else{
                System.out.println(fileName + "创建失败");
            }
        }
*/

        //演示文件夹的创建
//        {
//            String parent = "E:\\Test";
//            String fileName = "java演示创建文件夹";
//            File file = new File(parent,fileName);
//            boolean success = file.mkdir();
//            if (success) {
//                System.out.println(fileName + " 文件夹创建成功");
//            }else {
//                System.out.println(fileName + " 文件夹创建失败");
//            }
//        }

        //演示文件夹删除
        /*{
            String parent = "E:\\Test";
            String fileName = "java演示创建文件夹";
            File file = new File(parent,fileName);
            System.out.println(file.exists());

            boolean success = file.delete();//不是移动到回收站，而是直接删除，无法恢复
            if (success) {
                System.out.println(fileName + " 文件夹删除");
            }else {
                System.out.println(fileName + " 文件夹不存在");
            }
        }*/
        //演示deleteOnExit
        /*{
            String parent = "E:\\Test\\src";
            String fileName = "kobe";
            File file = new File(parent, fileName);
            System.out.println(file.exists());

            file.deleteOnExit();//不是立马删除，而是等 JVM 进程结束才会删除

            Scanner sc = new Scanner(System.in);
            System.out.println("只要不按回车 就不会删除");
            sc.nextLine();
        }*/

        //扫描文件目录
        {
            String path = "E:\\Test\\src";
            File dir = new File(path);
            File[] files = dir.listFiles();
            //files == null;
            //files.length == 0;
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
