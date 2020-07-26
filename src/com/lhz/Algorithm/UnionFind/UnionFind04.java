package com.lhz.Algorithm.UnionFind;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 0:37
 * 并查集第四版，基于rank的优化
 * 根据两个元素所在树的高度不同判断合并方向
 * 将树的高度比较低的集合合并到树的高度比较高的集合上
 */
public class UnionFind04 {
    // parent[i]表示第一个元素所指向的父节点
    // rank[i]表示以i为根的集合所表示的树的层数
    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind04(int n) {
        count = n;
        parent = new int[n];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    public int find(int p) {
        assert (p >= 0 && p < count);
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
//        if(p!=parent[p]){
//            parent[p] = find(p);
//        }
//        return parent[p];
    }

    // 查看元素p和元素q是否所属一个集合
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[qRoot] > rank[pRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {     //rank[qRoot]==rank[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
