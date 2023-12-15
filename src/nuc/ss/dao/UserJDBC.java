package nuc.ss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserJDBC
 * @Date: 2022/12/18
 * @Time: 17:42
 * @Description:JDBC实现对数据库的连接
 */
public class UserJDBC {
    public static Connection getconnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/fjh_03?useUnicode=true&characterEncoding=utf8";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "SXY-E.YT");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
