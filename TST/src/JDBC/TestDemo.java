package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class TestDemo {
    private static final DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);

        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("test");//设置默认库

        //等同于我们在 cmd 中如此连接 mysql
        //mysql -h127.0.0.1 -P3306 -uroot -p test

        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");//不会出现乱码

        dataSource = mysqlDataSource;
    }

    public static void main(String[] args) throws SQLException {
        //createTable();
        //insert();
        select();
    }

    //查询数据
    private static void select() throws SQLException {
        String sql = "SELECT id,username FROM users";
        try(Connection c = dataSource.getConnection()) {
            try(PreparedStatement statement = c.prepareStatement(sql)) {
                try(ResultSet rs = statement.executeQuery()) {
                    System.out.println("查询成功");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String username = rs.getString("username");
                        System.out.println(id + ", " + username);
                    }
                }
            }
        }
    }

    //插入数据
    private static void insert() throws SQLException {
        String[] names = {"kobe","Gigi"};
        String sql = "INSERT INTO users (username) VALUES (?)";
        try(Connection c = dataSource.getConnection()) {
            try(PreparedStatement statement = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                for (String name : names) {
                    statement.setString(1,name);
                    statement.executeUpdate();
                    try(ResultSet rs = statement.getGeneratedKeys()) {
                        rs.next();
                        int id = rs.getInt(1);
                        System.out.println("插入成功:" + id + ", " + name);
                    }
                }
            }
        }
    }

    //创建表
    private static void createTable() throws SQLException {
        String sql = "CREATE TABLE users (" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "username VARCHAR(255)" + ")";
        try(Connection c = dataSource.getConnection()) {
            try(PreparedStatement statement = c.prepareStatement(sql)) {
                statement.execute();
            }
        }
    }

}
