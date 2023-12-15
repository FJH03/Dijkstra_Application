package nuc.ss.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-蔡介予
 * @ClassName: ScenicPicture
 * @Date: 2022/12/25
 * @Time: 22:54
 * @Description:添加自定义描述
 */
public class ScenicPicture extends JFrame implements ActionListener {
    private JButton b_1 = new JButton("上一张");
    private JButton b_2 = new JButton("下一张");
    private Container c;
    private JLabel l;
    private int i = 1;

    public ScenicPicture() {
        //设置窗口的标题
        this.setTitle("图片浏览页面");
        //获得容器中的附属容器

        c = this.getContentPane();
        c.setLayout(new BorderLayout());

        l = new JLabel(new ImageIcon("image/" + i + ".jpg"));
        c.add(l);
        c.add(b_1, BorderLayout.WEST);
        c.add(b_2, BorderLayout.EAST);
        //创建监听器
        b_1.addActionListener(e -> {
            i--;
            l.setVisible(false);
            l = new JLabel(new ImageIcon("image/" + i + ".jpg"));
            if (i == 0) {
                b_1.setEnabled(false);
                JOptionPane.showMessageDialog(this, "当前为第一张图片", "提示框", JOptionPane.ERROR_MESSAGE);
            } else {
                b_1.setEnabled(true);
                b_2.setEnabled(true);
            }

            c.add(l);
            l.setVisible(true);
        });
        b_2.addActionListener(e -> {
            // TODO Auto-generated method stub

            i++;
            l.setVisible(false);
            l = new JLabel(new ImageIcon("image/" + i + ".jpg"));
            if (i == 8) {
                b_2.setEnabled(false);
                JOptionPane.showMessageDialog(this, "当前为最后一张图片", "提示框", JOptionPane.ERROR_MESSAGE);
            } else {
                b_2.setEnabled(true);
                b_1.setEnabled(true);
            }

            c.add(l);
            l.setVisible(true);
        });

        this.setLocation(150, 150);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
