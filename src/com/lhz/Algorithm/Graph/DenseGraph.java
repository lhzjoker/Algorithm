package com.lhz.Algorithm.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 15:35
 * 稠密图，邻接矩阵
 */
public class DenseGraph implements Graph{
    private int m;  //边数
    private int n;  //节点数
    private boolean directed;   //是否为无向图
    private boolean[][] g;  //图的具体数据

    //初始化一个图
    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        m = 0;
        this.directed = directed;
        //g是一个n*n的布尔矩阵，每一个g[i][j]均为false，表示没有任何边
        g = new boolean[n][n];
    }

    //返回图的边
    @Override
    public int E() {
        return m;
    }

    //返回图的节点数
    @Override
    public int V() {
        return n;
    }

    //将两个节点连接起来,即向图添加一个边
    @Override
    public void addEdge(int i, int j) {
        assert i >= 0 && i < n;
        assert j >= 0 && j < n;
        if(hasEdge(i,j)){
            return;
        }

        g[i][j] = true;
        //如果是无向图，另一个方向也设置成true
        if(!this.directed){
            g[j][i] = true;
        }
        m++;
    }

    //判断两个点有没有连接起来
    @Override
    public boolean hasEdge(int i, int j){
        assert i >= 0 && i < n;
        assert j >= 0 && j < n;
        return g[i][j];
    }

    //显示图的信息
    @Override
    public void show(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //返回一个顶点的所有边
    @Override
    public Iterable<Integer> adj(int v){
        assert v>=0&&v<n;
        Vector<Integer> adj = new Vector<Integer>();
        for(int i=0;i<n;i++){
            if(g[v][i]){
                adj.add(i);
            }
        }
        return adj;
    }


}
