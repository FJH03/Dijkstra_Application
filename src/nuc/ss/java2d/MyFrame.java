package nuc.ss.java2d;

import nuc.ss.entry.Scenic;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042613-窦文杰
 * @ClassName: MyFrame
 * @Date: 2022/12/26
 * @Time: 14:29
 * @Description:添加自定义描述
 */
public class MyFrame extends JFrame{
    public MyFrame(String title, List<Scenic> spots) {
        super(title);

        JPanel root = new JPanel();
        this.setContentPane(root);

        MyControl c = new MyControl(spots);
        root.add(c);
        c.setPreferredSize(new Dimension(1280, 720));

        Border border1 = new LineBorder(Color.BLUE,2);
        c.setBorder(border1);
    }
}
