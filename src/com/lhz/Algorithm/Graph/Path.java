package com.lhz.Algorithm.Graph;

import java.lang.annotation.ElementType;
import java.util.Stack;
import java.util.Vector;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 22:11
 * 求图中一个节点到另一个节点的路径
 */
public class Path {
    Graph graph;
    private boolean[] visited;
    private int[] from; //记录路径
    private int s;  //起始点

    //寻路算法
    public Path(Graph graph, int s) {
        this.graph = graph;
        assert s >= 0 && s < graph.V();
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }

        this.s = s;
        dfs(s);
    }

    public void dfs(int v) {
        visited[v] = true;
        for (int i : graph.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    //查询从s到w是否有路径
    public boolean hasPath(int w){
        assert w>=0&&w<graph.V();
        return visited[w];
    }

    //查询从s到w的路径，并存储到Vec中
    public Vector<Integer> path(int w){
        assert hasPath(w);
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Integer> s = new Stack<Integer>();
        int p = w;
        while (p!=-1){
            s.push(p);
            p = from[p];
        }

        //然后从栈顶取出元素，一次放入vec中，从而得到路径
        Vector<Integer> vector = new Vector<Integer>();
        while (!s.empty()){
            vector.add(s.pop());
        }

        return vector;
    }

    //打印从s到w的路径
    public void printPath(int w){
        assert hasPath(w);
        Vector<Integer> path = path(w);
        for(int i=0;i<path.size();i++){
            System.out.print(path.elementAt(i));
            if(i==path.size()-1){
                System.out.println();
            }else {
                System.out.print("->");
            }
        }
    }
}
