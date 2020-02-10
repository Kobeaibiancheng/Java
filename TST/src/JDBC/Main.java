package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String ur1 = "jdbc:mysql://127.0.0.1:3306/java?useSSL=false&characterEncoding=utf8";
        String user = "root";//连接 mysql 的用户
        String password = "";//连接 mysql 的密码
        Connection connection = DriverManager.getConnection(
                ur1,user,password);



        /*//INSERT 插入一些数据
        {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users (ID,name) VALUES (1,'张三'),(2,'Gigi'),(3,'事故飞机')";
            statement.executeUpdate(sql);//通过 statement 对象来执行语句sql
            //statement.close();
        }*/


        //执行 SELECT 语句
        {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<String> nameList = new ArrayList<>();
            while (resultSet.next()) {
                /*
                需要不同的数据，调用不同的方法
                int r = resultSet.getInt();
                long r = resultSet.getLong();
                String r = resultSet.getString();*/

                //下标是从 1 开始，不是从 0 开始
                int id = resultSet.getInt(1);
                //int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                //结果集马上销毁，所以通过 List 保存结果
                nameList.add(name);

                System.out.println(id + ", " + name);
            }

            resultSet.close();

            statement.close();
        }

        /*
        //UPDATE 修改
        {
            Statement statement = connection.createStatement();
            String sql = "UPDATE users SET name = 'kobe' WHERE ID = 1";
            statement.executeUpdate(sql);
            //statement.close();
        }
        //DELETE
        {
            Statement statement = connection.createStatement();
            //Statement statement = connection.createStatement();
            String sql = "DELETE FROM users";
            statement.executeUpdate(sql);
            statement.close();
        }*/
        connection.close();
    }
}
