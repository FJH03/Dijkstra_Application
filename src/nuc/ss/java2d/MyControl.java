package nuc.ss.java2d;

import nuc.ss.entry.Scenic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042613-窦文杰
 * @ClassName: MyControl
 * @Date: 2022/12/26
 * @Time: 14:26
 * @Description:添加自定义描述
 */
public class MyControl extends JPanel {
    BufferedImage image;
    List<Scenic> spot;

    public MyControl(List<Scenic> spots) {
        File file = new File("image/maps.jpg");
        try {
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.spot = spots;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        int width = this.getWidth();
        int height = this.getHeight();

        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        g.drawImage(image, 0, 0, width, height, null);
        int[][] b = {{323, 221}, {745, 208}, {1019, 265}, {986, 514}, {658, 637}, {326, 490}, {323, 221}};
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.BLUE);
            g.drawLine(b[i][0], b[i][1], b[i + 1][0], b[i + 1][1]);
        }
        g.drawLine(715, 450, 745, 208);
        g.drawLine(715, 450, 986, 514);
        g.drawLine(715, 450, 326, 490);
        g.drawLine(715, 450, 658, 637);
        g.drawLine(745, 208, 986, 514);
        g.drawLine(745, 208, 326, 490);
        g.drawLine(658, 637, 323, 221);
        g.drawLine(658, 637, 1019, 265);


        int[][] Spots = new int[spot.size()][2];
        Scenic spot1[] = new Scenic[spot.size()];
        for (int i = 0; i < spot.size(); i++) {
            spot.toArray(spot1);
        }
        for (int i = 0; i < spot1.length; i++) {
            Spots[i][0] = spot1[i].getS_pointx();
            Spots[i][1] = spot1[i].getS_pointy();
        }
        for (int i = 0; i < spot1.length - 1; i++) {
            g.setColor(Color.RED);
            g.drawLine(Spots[i][0], Spots[i][1], Spots[i + 1][0], Spots[i + 1][1]);
        }
    }
}
