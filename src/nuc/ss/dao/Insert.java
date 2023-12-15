package nuc.ss.dao;

import nuc.ss.entry.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: Insert
 * @Date: 2022/12/18
 * @Time: 17:52
 * @Description:数据库插入操作
 */
public class Insert {
    public Insert(User u) throws SQLException, ClassNotFoundException {
        Connection conn = UserJDBC.getconnection();
        String sqlsetence = "insert into user values('" + u.getId() + "','" + u.getName() + "','" + u.getIdcard() + "','" + u.getPhone() + "','" + u.getPassword() + "','" + u.getSex() + "')";
        PreparedStatement psmt = conn.prepareStatement(sqlsetence);
        psmt.executeUpdate();
        if (conn != null) {
            conn.close();
        }
        if (psmt != null) {
            psmt.close();
        }
    }
}
