package com.lhz.Algorithm.Graph;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 18:53
 * 关于无权图的联通分量，深度优先遍历和两个节点是否联通
 */
public class Components {
    Graph graph;    //图的引用
    private boolean[] visited;  //记录dfs过程中节点是否被访问
    private int count;  //图的联通分量
    private int[] id;   //每个节点所对应联通分量的标记

    //图的深度优先遍历
    public void dfs(int v){
        visited[v] = true;
        id[v] = count;
        for(int i:graph.adj(v)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public  Components(Graph graph){
        this.graph = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        count = 0;
        for(int i=0;i<graph.V();i++){
            visited[i] = false;
            id[i] = -1;
        }

        for(int i=0;i<graph.V();i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
    }

    //图的联通量
    public int count(){
        return count;
    }

    //两个节点是否相通
    public boolean isConnected(int v,int w){
        assert v>=0&&v<graph.V();
        assert w>=0&&w<graph.V();
        return id[v] == id[w];
    }
}
