package nuc.ss.solve;

import nuc.ss.entry.Scenic;
import nuc.ss.temp.Pairdata;

import java.util.*;

import static nuc.ss.frame.LoginFrame.T;


/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: ShortestPath
 * @Date: 2022/12/17
 * @Time: 22:14
 * @Description:最短路径算法
 */
public class ShortestPath {
    public static int N = 100010;
    public static int head[];
    public static int edge[];
    public static int next[];
    private double dist[];
    private double w[];
    int[] prev = new int[N];
    int idx;

    /**
     * dijkstra堆优化算法预处理
     */
    public void init() {
        head = new int[N];
        edge = new int[N];
        next = new int[N];
        dist = new double[N];
        w = new double[N];
        Arrays.fill(head, -1);
    }

    /**
     * 添加一条从a到b的有向边(景点编号从1到N-1均可),邻接表建边
     *
     * @param a  起始景点编号
     * @param b  终止景点编号
     * @param val 距离
     */
    public void add(int a, int b, double val) {
        edge[idx] = b;
        w[idx] = val;
        next[idx] = head[a];
        head[a] = idx++;
    }

    /**
     * 求解最短距离(采用dijkatra堆优化版算法)
     * @param a 起始景点编号
     * @param b 终止景点编号
     * @return start到end的最短距离(-1为不可达)
     */
    public double dijkstra(int a, int b) {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[a] = 0;
        Queue<Pairdata> Q = new LinkedList<>();
        Q.add(new Pairdata(dist[a], a));//队首入队,first存储更新后的距离,second存储点的编号
        while (!Q.isEmpty()) {
            //提取队首并删除队首元素
            Pairdata t = Q.poll();
            for (int i = head[t.getSecond()]; i != -1; i = next[i]) {
                if (dist[edge[i]] > t.getFirst() + w[i]) {
                    //依次更新最短距离
                    dist[edge[i]] = t.getFirst() + w[i];
                    prev[edge[i]] = t.getSecond();
                    Q.add(new Pairdata(dist[edge[i]], edge[i]));
                }
            }
        }
        return dist[b] < 0x3f3f3f3f ? dist[b] : -1;
    }

    /**
     * 遍历Vector容器可获得最短路径的遍历次序(在dijkstra算法执行成功后使用)
     * @param start 起始景点编号
     * @param end 终止景点
     */
    public LinkedList<Scenic> getshortestpath(int start, int end) {
        LinkedList<Integer> V = new LinkedList<>();
        LinkedList<Scenic> res = new LinkedList<>();
        while (end != start && end != 0) {
            V.add(end);
            end = prev[end];
        }
        V.add(end);
        Collections.swap(V, 0, V.size() - 1);
        for (int i : V) {
            for (Scenic S : T) {
                if (S.getS_id() == i) {
                    res.add(S);
                }
            }
        }
        return res;
    }
}
