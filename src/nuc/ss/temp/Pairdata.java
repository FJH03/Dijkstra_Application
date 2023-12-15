package nuc.ss.temp;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: Pairdata
 * @Date: 2022/12/12
 * @Time: 13:38
 * @Description:个人自定义元组类型
 */
public class Pairdata {
    private double first;
    private int second;

    public double getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public Pairdata(double first, int second) {
        this.first = first;
        this.second = second;
    }
}
