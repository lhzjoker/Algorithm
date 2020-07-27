package com.lhz.Algorithm.Graph;

import javax.xml.stream.FactoryConfigurationError;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 23:17
 * 广度优先遍历和最短路径
 */
public class ShortestPath {
    Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph graph, int s) {
        this.graph = graph;
        assert s >= 0 && s < graph.V();

        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
        bfs(s);
    }

    //深度优先遍历
    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i : graph.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    //判断从s点到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.V();
        return visited[w];
    }

    //查询从s到w点的路径
    public Vector<Integer> path(int w) {
        Vector<Integer> vector = new Vector<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int p = w;
        while (from[p] != -1) {
            stack.push(p);
            p = from[p];
        }

        while (!stack.isEmpty()) {
            vector.add(stack.pop());
        }

        return vector;
    }

    public void showPath(int w) {

        assert hasPath(w);

        Vector<Integer> path = path(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.elementAt(i));
            if (i == path.size() - 1) {
                System.out.println();
            } else {
                System.out.print("->");
            }
        }
    }

    //查看从s到w的最短路径
    //如果不存在就返回-1
    public int length(int w) {
        assert w >= 0 && w < graph.V();
        return ord[w];
    }
}
