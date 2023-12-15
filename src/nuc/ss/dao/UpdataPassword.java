package nuc.ss.dao;

import java.sql.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-温绍卿
 * @ClassName: UpdataPassword
 * @Date: 2022/12/26
 * @Time: 12:20
 * @Description:更新密码的数据库操作
 */
public class UpdataPassword {
    public static Boolean updatePassword(String idcard, String password) throws SQLException, ClassNotFoundException {
        Connection conn = UserJDBC.getconnection();
        boolean flag = false;
        PreparedStatement pstm = conn.prepareStatement("select idcard from user");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            if (rs.getString("idcard").equals(idcard)) {
                flag = true;
            }
        }
        if (flag == true) {
            pstm.executeUpdate("update user set password = '" + password + "' where idcard = '" + idcard + "'");
            return true;
        }

        if(rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return false;
    }
}
