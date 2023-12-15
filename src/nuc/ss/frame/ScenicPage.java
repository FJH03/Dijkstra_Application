package nuc.ss.frame;

import nuc.ss.entry.Scenic;
import nuc.ss.entry.User;
import nuc.ss.java2d.MyFrame;
import nuc.ss.solve.ShortestPath;

import javax.swing.*;
import java.awt.*;

import static nuc.ss.frame.LoginFrame.T;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042611-蔡介予
 * @ClassName: ScenicPage
 * @Date: 2022/12/25
 * @Time: 17:45
 * @Description:添加自定义描述
 */
public class ScenicPage extends JFrame {
    private JLabel l_welcome, l_type1, l_type2;
    private JComboBox<String> c_type1, c_type2;
    private JTable t_spot;
    private String id1, id2;

    public ScenicPage(User u) {
        this.setLayout(null);
        this.setTitle("景点页面");
        this.setSize(500, 400);
        this.setLocation(300, 200);

        JPanel J1 = new JPanel();
        J1.setLayout(new GridLayout(1, 1));
        String temp = null;
        if (u.getSex() == '男') {
            temp = "先生";
        } else {
            temp = "女士";
        }
        l_welcome = new JLabel("您好," + u.getName() + temp + ",欢迎来到快速选择景点页面！");
        J1.add(l_welcome);
        J1.setBounds(15, 5, 500, 20);
        this.add(J1);
        init();
        this.setVisible(true);
    }

    public void init() {
        JPanel J2 = new JPanel();
        Object[] SpotCol = {"编号", "名称", "推荐指数", "开放时间", "关闭时间"};
        Scenic[] spot = new Scenic[7];
        for (int i = 0; i < T.size(); i++) {
            T.toArray(spot);
        }
        Object[][] Spot = new Object[spot.length][7];

        for (int i = 0; i < spot.length; i++) {
            Spot[i][0] = spot[i].getS_id();
            Spot[i][1] = spot[i].getS_name();
            Spot[i][2] = spot[i].getS_recommend();
            Spot[i][3] = spot[i].getS_opentime();
            Spot[i][4] = spot[i].getS_closetime();
        }

        t_spot = new JTable(Spot, SpotCol);
        J2.add(new JScrollPane(t_spot));
        J2.setBounds(2, 25, 500, 200);
        this.add(J2);

        JPanel J3 = new JPanel();
        J3.setLayout(new GridLayout(1, 1, 5, 5));
        l_type1 = new JLabel("<起始点>", JLabel.CENTER);
        c_type1 = new JComboBox<>();
        c_type1.addItem("晋祠");
        c_type1.addItem("中国煤炭博物馆");
        c_type1.addItem("双塔寺");
        c_type1.addItem("迎泽公园");
        c_type1.addItem("蒙山大佛");
        c_type1.addItem("青龙古镇");
        c_type1.addItem("悬空寺");
        l_type2 = new JLabel("<终止点>", JLabel.CENTER);
        c_type2 = new JComboBox<>();
        c_type2.addItem("晋祠");
        c_type2.addItem("中国煤炭博物馆");
        c_type2.addItem("双塔寺");
        c_type2.addItem("迎泽公园");
        c_type2.addItem("蒙山大佛");
        c_type2.addItem("青龙古镇");
        c_type2.addItem("悬空寺");
        JButton b_project = new JButton("规划");
        b_project.addActionListener(e -> {
            id1 = c_type1.getSelectedItem().toString();
            id2 = c_type2.getSelectedItem().toString();
            Scenic a = null;
            Scenic b = null;
            for(Scenic I : T) {
                if(id1 == I.getS_name()) {
                    a = I;
                }else if(I.getS_name() == id2) {
                    b = I;
                }
            }
            ShortestPath S = new ShortestPath();
            S.init();
            assert b != null;
            S.add(1,2, 10);S.add(2,1, 10);
            S.add(1,3,18);S.add(3,1,18);
            S.add(1,6,12);S.add(6,1,12);
            S.add(1,7,10);S.add(7,1,10);

            S.add(2,3,13);S.add(3,2,13);
            S.add(2,7,18);S.add(7,2,18);

            S.add(3,4,6);S.add(4,3,6);
            S.add(3,6,8);S.add(6,3,8);
            S.add(3,5,11);S.add(5,3,11);


            S.add(4,5,7);S.add(5,4,7);
            S.add(4,7,14);S.add(7,4,14);

            S.add(5,7,8);S.add(7,5,8);
            S.add(5,6,6);S.add(6,5,6);

            S.add(6,7,6);S.add(7,6,6);

            if(S.dijkstra(a.getS_id(),b.getS_id()) == -1) {
                JOptionPane.showMessageDialog(this,"这两个景点不可达","警告对话框", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"景点" + a.getS_name() + "到" + b.getS_name() + "的距离为" + S.dijkstra(a.getS_id(),b.getS_id()) + "km。","提示",JOptionPane.CANCEL_OPTION);
                JFrame Frame = new MyFrame("图片展示",S.getshortestpath(a.getS_id(),b.getS_id()));
                Frame.setSize(1280,780);
                Frame.setVisible(true);
            }
        });

        J3.add(l_type1);
        J3.add(c_type1);
        J3.add(l_type2);
        J3.add(c_type2);
        J3.add(b_project);
        J3.setBounds(5, 225, 450, 50);
        this.add(J3);
    }
}
