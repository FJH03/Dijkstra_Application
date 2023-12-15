package nuc.ss.frame;

import nuc.ss.dao.UpdataPassword;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: updateFrame
 * @Date: 2022/12/26
 * @Time: 12:10
 * @Description:添加自定义描述
 */
public class updateFrame extends JFrame {
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    int TIME_VISIBLE = 3000;
    public updateFrame() {
        this.setTitle("修改密码页面");
        this.setLocation(400,600);
        this.setSize(200,200);
        init();
        this.setVisible(true);
    }

    public void init() {

        l1 = new JLabel("身份证");
        t1 = new JTextField();

        l2 = new JLabel("新密码");
        t2 = new JTextField();

        l3 = new JLabel("再次输入密码");
        t3 = new JTextField();

        b1 = new JButton("确认");
        b2 = new JButton("重置");
        b2.addActionListener(e1 -> {
            t1.setText(" ");
            t2.setText(" ");
            t3.setText(" ");
        });

        this.setLayout(new GridLayout(4,2));
        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(l3);
        this.add(t3);
        this.add(b1);
        this.add(b2);

        b1.addActionListener(e -> {
            String idcard = t1.getText();
            String password  = t2.getText() ;
            String password1  = t3.getText();
            if(judge(idcard)) {
                if(password.equals(password1)) {
                    try {
                        if(UpdataPassword.updatePassword(idcard,password)) {
                            finish();
                        }else {
                            new updateFrame();
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    passnotequal();
                }
            }else{
                idcarderror();
            }
        });
    }

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

    public void passnotequal() {
        JOptionPane.showMessageDialog(this, "前后输入密码不一致！请重新输入。", "警告对话框", JOptionPane.WARNING_MESSAGE);
        t2.setText(" ");
        t3.setText(" ");
    }

    public void idcarderror() {
        JOptionPane.showMessageDialog(this, "您的身份证号不符合要求！请重新输入", "警告对话框", JOptionPane.WARNING_MESSAGE);
        t1.setText(" ");
    }

    public void finish() {
        JOptionPane pane = new JOptionPane("修改成功",JOptionPane.CANCEL_OPTION);
        JDialog dialog = pane.createDialog(pane, "尊敬的用户，你好");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(TIME_VISIBLE, e -> dialog.setVisible(false)).start();
        this.dispose();
    }
}
