package nuc.ss.frame;

import nuc.ss.dao.Find;
import nuc.ss.entry.Scenic;
import nuc.ss.entry.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: RegisterFrame
 * @Date: 2022/12/13
 * @Time: 17:04
 * @Description:登录窗体
 */

public class LoginFrame extends JFrame {
    public static LinkedList<Scenic> T = new LinkedList<>();
    JLabel l_id, l_password, l;
    JTextField t_id;
    JPasswordField t_password;
    JButton b_register, b_login,b_update;
    JPanel p1,p2;

    public static void main(String[] args) {
        Scenic[] spot = new Scenic[7];
        spot[0] = new Scenic(1, "中国煤炭博物馆", "*****", "8:00", "18:00", 326, 490);
        spot[1] = new Scenic(2, "晋祠", "****", "8:30", "19:00", 323, 221);
        spot[2] = new Scenic(3, "双塔寺", "*****", "8:00", "19:00", 745, 208);
        spot[3] = new Scenic(4, "青龙古镇", "***", "9:00", "18:30", 1019, 265);
        spot[4] = new Scenic(5, "悬空寺", "****", "8:30", "18:00", 986, 514);
        spot[5] = new Scenic(6, "迎泽公园", "*****", "6:00", "23:00", 715, 450);
        spot[6] = new Scenic(7, "蒙山大佛", "***", "9:00", "17:30", 658, 637);
        Collections.addAll(T, spot);
        new LoginFrame();
    }

    public LoginFrame() {
        this.setTitle("观光决策平台登录页面");
        this.setLocation(400, 200);
        this.setSize(380, 525);
        init();
        this.setVisible(true);
    }

    public void init() {
        ImageIcon ii = new ImageIcon("image/login.jpg");
        l = new JLabel(ii);
        Font font = new Font("宋体", Font.CENTER_BASELINE, 20);
        l.setBounds(0, 0, 380, 215);
        this.add(l);

        l_id = new JLabel("用户名", JLabel.CENTER);
        l_id.setFont(font);
        l_password = new JLabel("密码", JLabel.CENTER);
        l_password.setFont(font);


        t_id = new JTextField();
        t_password = new JPasswordField();
        p1 = new JPanel();

        b_register = new JButton("注册");
        b_register.setFont(font);
        b_register.addActionListener(e -> {
            try {
                new RegisterFrame();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        t_id.setText("2113042621");
        t_password.setText("SXY-E.YT");
        b_login = new JButton("登录");
        b_login.setFont(font);
        b_login.addActionListener(e -> {
            Find f = new Find();
            try {
                if (f.Find(t_id.getText(), new String(t_password.getPassword()))) {
                    User u = f.getUserMessage(t_id.getText(), new String(t_password.getPassword()));
                    JOptionPane.showMessageDialog(this, "登陆成功!", "提示对话框", JOptionPane.YES_NO_CANCEL_OPTION);
                    this.setVisible(false);
                    new SelectBrowseFrame(u);
                    new ScenicPicture();
                } else {
                    JOptionPane.showMessageDialog(this, "该用户名不存在或密码错误！", "警告对话框", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        b_update = new JButton("更改密码");
        b_update.setFont(font);
        b_update.addActionListener(e->{
            new updateFrame();
            this.setVisible(false);
        });
        p1.setLayout(new GridLayout(2, 2));
        p1.add(l_id);
        p1.add(t_id);
        p1.add(l_password);
        p1.add(t_password);

        this.setLayout(null);
        this.add(p1);
        p1.setBounds(2, 220, 360, 180);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3,4,5));
        p2.add(b_login);
        p2.add(b_register);
        p2.add(b_update);
        p2.setBounds(2,405,360,80);
        this.add(p2);
    }
}
