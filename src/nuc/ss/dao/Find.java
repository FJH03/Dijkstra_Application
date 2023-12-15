package nuc.ss.dao;

import nuc.ss.entry.User;

import java.sql.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: Find
 * @Date: 2022/12/22
 * @Time: 16:13
 * @Description:数据库查找操作
 */
public class Find {
    public boolean Find(String id, String password) throws ClassNotFoundException, SQLException {
        Connection conn = UserJDBC.getconnection();
        PreparedStatement pstm = conn.prepareStatement("select password from user where user.id = '" + id + "'");
        ResultSet RS = pstm.executeQuery();
        String pass = null;
        while (RS.next()) {
            pass = RS.getString("password");
        }
        if (conn != null) {
            conn.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (pass == null || password.equals(pass) == false) {
            return false;
        } else {
            return true;
        }
    }

    public User getUserMessage(String id, String password) throws ClassNotFoundException, SQLException {
        Connection conn = UserJDBC.getconnection();
        PreparedStatement pstm = conn.prepareStatement("select * from user where user.id = '" + id + "'");
        ResultSet RS = pstm.executeQuery();
        String name = null;
        String idcard = null;
        String phone = null;
        char sex = 0;
        while (RS.next()) {
            name = RS.getString("name");
            idcard = RS.getString("idcard");
            phone = RS.getString("phone");
            sex = RS.getString("sex").charAt(0);
        }
        if (conn != null) {
            conn.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        User u = new User(id, name, idcard, phone, password, sex);
        return u;
    }
}

