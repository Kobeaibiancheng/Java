package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    /*private static int globalUserId = -1;
    private static String gloablUsername = null;*/
    private static void menu() {
        System.out.println("===============");
        System.out.println("1.用户注册");
        System.out.println("2.用户登录");
        System.out.println("3.发表文章");
        System.out.println("4.文章列表页");
        System.out.println("5.文章详情页");
        System.out.println("===============");
    }

    private static void register() throws SQLException {
        // 需要用户名输入用户名 + 密码
        Scanner scanner = new Scanner(System.in);
        String username =scanner.nextLine();
        String password = scanner.nextLine();

        //利用JDBC套路 运行 sql 语句

        /*Connection con = DriverManager.getConnection(
                url,mysqlUsername,mysqlPassword
        );
        Statement statement = con.createStatement();
        String sql = String.format(
                "INSERT INTO users (username, password) VALUES ('%s', '%s')",
                username, password);
        System.out.println(sql);
        statement.executeUpdate(sql);
        statement.close();

        con.close();*/

        try(Connection con = DriverManager.getConnection(url,mysqlUsername,mysqlPassword)) {
            try(Statement statement = con.createStatement()) {
                String sql = String.format(
                        "INSERT INTO users (username, password) VALUES ('%s', '%s')",
                        username, password);
                System.out.println(sql);
                statement.executeUpdate(sql);
            }
        }


    }
    private static final String url = "jdbc:mysql://127.0.0.1:3306/project?useSSL=false&characterEncoding=utf8";
    private static final String mysqlUsername = "root";
    private static final String mysqlPassword = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();

            int select = scanner.nextInt();
            scanner.nextLine();

            switch(select) {
                case 1:
                    register();
                    break;
            }
        }

    }
}
