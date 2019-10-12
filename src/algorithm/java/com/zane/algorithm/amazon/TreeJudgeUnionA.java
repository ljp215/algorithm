package com.zane.algorithm.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * There are n nodes numbered from 0 to n-1 and a set of edges (undirected).
 * Please determine if it is a valid tree.
 * <p/>
 * For example:
 * n = 5, edge set = {{0,1}, {0,2}, {2,3}, {2,4}}
 * Result: true
 * <p/>
 * n = 5, edge set = {{0,1}, {1,2}, {0,2}, {2,3}, {2,4}}
 * Result: false
 * <p/>
 * n = 4, edge set = {{0,1}, {2,3}}
 * Result: false
 * <p/>
 * <p/>
 * Author: luojinping
 * Date: 16/1/29
 * Time: 15:53
 */
public class TreeJudgeUnionA {
    private static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // the number of edges
    private int n;

    // edge list
    private List<Edge> edges = new ArrayList<>();

    // the index of group
    private int[] group;

    public TreeJudgeUnionA(int n, List<Edge> edges) {
        this.n = n;
        this.edges = edges;

        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    private int find(int i) {
        return group[i];
    }

    private void union(int groupI, int groupJ) {
        for (int i = 0; i < n; i++) {
            if (group[i] == groupJ) {
                group[i] = groupI;
            }
        }
    }

    public boolean isTree() {
        for (Edge edge : edges) {
            int groupX = find(edge.start);
            int groupY = find(edge.end);

            if (groupX != groupY) {
                union(groupX, groupY);
            } else {
                // find circle because input two vertex which both in the same group
                System.out.println("Exist a circle");
                return false;
            }
        }

        printGroup();

        int groupId = group[0];
        for (int i = 1; i < n; i++) {
            if (groupId != group[i]) {
                return false;
            }
        }

        return true;
    }

    public void printGroup() {
        for (int i = 1; i < n; i++) {
            System.out.print(group[i] + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 5;
        List<Edge> edges = new ArrayList<>();
        addEdge(edges, 0, 1);
        addEdge(edges, 0, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 4);
        isTree(n, edges);

        n = 5;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 1, 2);
        addEdge(edges, 0, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 4);
        isTree(n, edges);

        n = 4;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 2, 3);
        isTree(n, edges);

        n = 6;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 1, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 3, 4);
        addEdge(edges, 4, 5);
        addEdge(edges, 0, 6);
        isTree(n, edges);
    }

    protected static void addEdge(List<Edge> edges, int i, int j) {
        edges.add(new Edge(i, j));
    }

    protected static void isTree(int n, List<Edge> edges) {
        TreeJudgeUnionA treeJudgeUnionA = new TreeJudgeUnionA(n, edges);

        boolean isTree = treeJudgeUnionA.isTree();

        System.out.println("This is a tree? " + isTree);
    }
}
