package com.lhz.Algorithm.Graph;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 15:55
 * 稀疏图-邻接表
 */
public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        m = 0;
        this.directed = directed;
        g = (Vector<Integer>[]) new Vector[n];
        //每一个节点都是一个链表
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }

    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    //验证图中是否有从i到j的边
    @Override
    public boolean hasEdge(int i, int j) {
        assert i >= 0 && i < n;
        assert j >= 0 && j < n;

        for (int k = 0; k < g[i].size(); k++) {
            if (g[i].elementAt(k) == j) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(int i, int j) {
        assert i >= 0 && i < n;
        assert j >= 0 && j < n;

        if (hasEdge(i, j)) {
            return;
        }

        g[i].add(j);
        //考虑到自己指向自己的情况和是否为无向图的情况
        if (i != j && !this.directed) {
            g[j].add(i);
        }
        m++;
    }


    //显示图的信息
    @Override
    public void show(){
        for(int i=0;i<n;i++){
            System.out.print("vertex"+i+":\t");
            for(int j=0;j<g[i].size();j++){
                System.out.print(g[i].elementAt(j)+"\t");
            }
            System.out.println();
        }
    }

    //返回一个顶点的所有边
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
