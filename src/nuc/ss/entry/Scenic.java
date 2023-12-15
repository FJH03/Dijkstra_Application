package nuc.ss.entry;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042611-蔡介予
 * @ClassName: Scenic
 * @Date: 2022/12/12
 * @Time: 9:43
 * @Description:景点实体
 */
public class Scenic {
    private int s_id;
    private String s_name,s_opentime,s_closetime,s_recommend;
    private int s_pointx,s_pointy;

    /**
     * 景点基本信息
     * @param s_id 编号(从1至N-1)编号
     * @param s_name 景点名称
     * @param s_opentime 开放时间
     * @param s_closetime 关闭时间
     * @param s_recommend 推荐度
     * @param s_pointx JAVA2D横坐标
     * @param s_pointy JAVA2D纵坐标
     */

    public Scenic(int s_id, String s_name, String s_opentime, String s_closetime, String s_recommend, int s_pointx, int s_pointy) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_opentime = s_opentime;
        this.s_closetime = s_closetime;
        this.s_recommend = s_recommend;
        this.s_pointx = s_pointx;
        this.s_pointy = s_pointy;
    }

    public Scenic() {
    }

    public int getS_id() {
        return s_id;
    }

    public int getS_pointx() {
        return s_pointx;
    }

    public int getS_pointy() {
        return s_pointy;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_recommend() {
        return s_recommend;
    }

    public String getS_opentime() {
        return s_opentime;
    }

    public String getS_closetime() {
        return s_closetime;
    }
}
