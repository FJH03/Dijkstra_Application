package nuc.ss.solve;

import nuc.ss.entry.Scenic;

import java.util.LinkedList;

import static nuc.ss.frame.LoginFrame.T;
import static nuc.ss.solve.ShortestPath.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DFS_ergodic
 * @Date: 2022/12/23
 * @Time: 10:41
 * @Description:DFS全遍历
 */
public class DFS_ergodic {
    private final boolean[] st = new boolean[N];
    LinkedList<Integer> L = new LinkedList<>();
    public void dfs(int u) {
        st[u] = true;
        L.add(u);
        for (int i = head[u]; i != -1; i = next[i]) {
            if(!st[edge[i]]) {
                dfs(edge[i]);
            }
        }
    }

    public LinkedList<Scenic> geDFSresult() {
        LinkedList<Scenic> result = new LinkedList<>();
        for(int i : L) {
            for(Scenic j : T) {
                if(j.getS_id() == i) {
                    result.add(j);
                }
            }
        }
        return result;
    }
}
