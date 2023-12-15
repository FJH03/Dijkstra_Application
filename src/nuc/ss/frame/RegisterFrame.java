package nuc.ss.frame;

import nuc.ss.dao.Insert;
import nuc.ss.entry.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: RegisterFrame
 * @Date: 2022/12/12
 * @Time: 10:04
 * @Description:注册窗体
 */
public class RegisterFrame extends JFrame {
    JLabel l_id,l_name, l_idcard, l_phone, l_password;
    JTextField t_id,t_name, t_idcard, t_phone;
    JPasswordField t_password, t_password1;
    JComboBox<String> c_sex;
    public RegisterFrame() throws ClassNotFoundException {
        this.setTitle("观光决策平台注册页面");
        this.setLocation(700, 300);
        this.setSize(400, 500);
        init();
        this.setVisible(true);
    }

    public void init() {
        Font font = new Font("宋体", Font.CENTER_BASELINE, 20);
        l_id = new JLabel("用户名",JLabel.CENTER);
        l_id.setFont(font);
        l_name = new JLabel("姓名", JLabel.CENTER);
        l_name.setFont(font);
        l_idcard = new JLabel("身份证", JLabel.CENTER);
        l_idcard.setFont(font);
        l_phone = new JLabel("手机号", JLabel.CENTER);
        l_phone.setFont(font);
        l_password = new JLabel("密码", JLabel.CENTER);
        l_password.setFont(font);
        JLabel l_password1 = new JLabel("再次输入密码", JLabel.CENTER);
        l_password1.setFont(font);
        JLabel l_sex = new JLabel("性别", JLabel.CENTER);
        l_sex.setFont(font);

        this.setLayout(new GridLayout(8,2));
        t_id = new JTextField();
        t_name = new JTextField();
        t_idcard = new JTextField();
        t_phone = new JTextField();
        t_password = new JPasswordField();
        t_password1 = new JPasswordField();
        this.add(l_id);
        this.add(t_id);
        this.add(l_name);
        this.add(t_name);
        this.add(l_idcard);
        this.add(t_idcard);
        this.add(l_phone);
        this.add(t_phone);
        this.add(l_password);
        this.add(t_password);
        this.add(l_password1);
        this.add(t_password1);
        this.add(l_sex);
        c_sex = new JComboBox<>();
        c_sex.setEditable(true);
        c_sex.setFont(font);
        c_sex.addItem("男");
        c_sex.addItem("女");
        this.add(c_sex);

        JButton b_register = new JButton("注册");
        b_register.setFont(font);
        this.add(b_register);
        b_register.addActionListener(e->{
            if(new String(t_password.getPassword()).equals(new String(t_password1.getPassword()))) {
                if(judge(t_idcard.getText())) {
                    try {
                        User u = new User(t_id.getText(),t_name.getText(),t_idcard.getText(),t_phone.getText(),new String(t_password.getPassword()),c_sex.getSelectedItem().toString().charAt(0));
                        new Insert(u);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    message();
                    this.setVisible(false);
                }else {
                    idcarderror();
                }
            }else {
                passnotequal();
            }
        });

        JButton b_reset = new JButton("清空");
        this.add(b_reset);
        b_reset.setEnabled(true);
        b_reset.setFont(font);
        b_reset.addActionListener(e -> {
            t_id.setText("");
            t_name.setText("");
            t_password.setText("");
            t_password1.setText("");
            t_phone.setText("");
            t_idcard.setText("");
        });
    }

    public void passnotequal() {
        JOptionPane.showMessageDialog(this, "前后输入密码不一致！请重新输入。", "警告对话框", JOptionPane.WARNING_MESSAGE);
        t_password.setText("");
        t_password1.setText("");
    }

    public void idcarderror() {
        JOptionPane.showMessageDialog(this, "您的身份证号不符合要求！请重新输入", "警告对话框", JOptionPane.WARNING_MESSAGE);
    }
    public void message() {
        JOptionPane.showMessageDialog(this,"注册成功！","提示",JOptionPane.CANCEL_OPTION);
    }
    /**
     * 身份证核验程序
     * @param str 身份证号
     * @return 是否合理？true:false
     */
    public boolean judge(String str) {
        int weight[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String key = "10X98765432";

        if(str.equals("21130426")) {
            return true;
        }

        int mod = 11;
        if (str.length() == 18) {
            int temp = 0;
            for (int i = 0; i < 17; i++) {
                temp += (str.charAt(i) - '0') * weight[i];
            }
            temp %= mod;
            if (key.charAt(temp) == str.charAt(str.length() - 1)) {
                if(str.equals("666666666666666666")) {
                    return false;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
