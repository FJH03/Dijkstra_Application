package nuc.ss.frame;

import nuc.ss.entry.User;

import javax.swing.*;
import java.awt.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042601-刘耀昕
 * @ClassName: SelectBrowseFrame
 * @Date: 2022/12/25
 * @Time: 19:13
 * @Description:添加自定义描述
 */
public class SelectBrowseFrame extends JFrame {
    private JLabel l_user, l_welcome, l_line1, l_line2, l_picture, l_text;
    private JButton b_fast, b_all;

    public SelectBrowseFrame(User u) {
        this.setTitle("选择浏览方式");
        this.setSize(500, 340);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init(u);
        this.setVisible(true);
    }

    public void init(User u) {
        // 初始化JLable+设置字体
        Font f1 = new Font("宋体", Font.LAYOUT_RIGHT_TO_LEFT, 15);
        String temp;
        if (u.getSex() == '男') {
            temp = "先生";
        } else {
            temp = "女士";
        }
        l_user = new JLabel("您好," + u.getName() + temp, JLabel.LEADING);
        l_user.setFont(f1);
        l_welcome = new JLabel("欢迎您使用观光决策系统", JLabel.RIGHT);
        l_welcome.setFont(f1);
        l_line1 = new JLabel("——————————————————————————————————————");
        l_line2 = new JLabel("——————————————————————————————————————");
        ImageIcon image = new ImageIcon("image/" + "girl.jpg");
        l_picture = new JLabel(image);
        l_text = new JLabel("请您选择您的游览方式", JLabel.CENTER);
        l_text.setFont(f1);
        // 初始化JButton
        Font f2 = new Font("华文楷体", Font.BOLD, 30);
        b_fast = new JButton("快速游览");
        b_fast.setFont(f2);        // 设置JButton中的字体
        b_all = new JButton("全景点游览");
        b_all.setFont(f2);

        // 自定义布局
        this.setLayout(null);
        // 设置p的布局，第一块
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 5, 5));
        p.add(l_user);
        p.add(l_welcome);
        p.setBounds(5, 5, 475, 25);
        this.add(p);
        // 第二块
        p = new JPanel();
        p.setLayout(new GridLayout(1, 1, 5, 5));
        p.add(l_line1);
        p.setBounds(5, 10, 475, 40);
        this.add(p);
        // 第三块
        p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 5, 5));
        p.add(l_picture);
        p.add(l_text);
        p.setBounds(5, 50, 475, 130);
        this.add(p);
        // 第四块
        p = new JPanel();
        p.setLayout(new GridLayout(1, 1, 5, 5));
        p.add(l_line2);
        p.setBounds(5, 175, 475, 40);
        this.add(p);
        // 第五块
        p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 5, 5));
        p.add(b_fast);
        p.add(b_all);
        b_fast.addActionListener(e-> new ScenicPage(u));
        b_all.addActionListener(e-> new AllScenicFrame(u));
        p.setBounds(5, 215, 475, 75);
        this.add(p);
    }
}
