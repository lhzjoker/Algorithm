package com.lhz.Algorithm.UnionFind;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/27 0:09
 * 并查集版本2，优化union
 * 把每一个元素看成一个节点（并不是真的节点），把并起来的集合通过节点连接起来
 */
public class UnionFind02 {
    // 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
    // parent[i]表示第一个元素所指向的父节点
    private int[] parent;
    private int count;

    public UnionFind02(int n) {
        count = n;
        parent = new int[n];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    public int find(int p) {
        assert (p >= 0 && p < count);
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p!=parent[p]){
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

        parent[pRoot] = qRoot;
    }
}
