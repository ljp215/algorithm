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
public class TreeJudgeUnionB {
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

    // the size of tree
    private int[] size;

    public TreeJudgeUnionB(int n, List<Edge> edges) {
        this.n = n;
        this.edges = edges;

        group = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            size[i] = 1;
        }
    }

    private int find(int i) {
        // find the root of a tree which contains i node
        while (i != group[i]) {
            i = group[i];
        }

        return i;
    }

    private boolean union(int groupI, int groupJ) {
        int iRoot = find(groupI);
        int jRoot = find(groupJ);
        if (iRoot != jRoot) {
            if (size[iRoot] < size[jRoot]) {
                group[iRoot] = jRoot;
                size[jRoot] += size[iRoot];
            } else {
                group[jRoot] = iRoot;
                size[iRoot] += size[jRoot];
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isTree() {
        for (Edge edge : edges) {
            if (!union(edge.start, edge.end)) {
                System.out.println("input two nodes in the same tree");
                return false;
            }
        }

        boolean hasRoot = false;
        for (int i = 0; i < group.length; i++) {
            if (i == group[i]) {
                if (!hasRoot) {
                    hasRoot = true;
                } else {
                    System.out.println("exist more than one tree root");
                    return false;
                }
            }
        }

        printGroup();

        return hasRoot;

    }

    public void printGroup() {
        for (int i = 0; i < n; i++) {
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
        isTree(n, edges); // true

        n = 5;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 1, 2);
        addEdge(edges, 0, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 4);
        isTree(n, edges); // false

        n = 4;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 2, 3);
        isTree(n, edges);  // false

        n = 7;
        edges.clear();
        addEdge(edges, 0, 1);
        addEdge(edges, 1, 2);
        addEdge(edges, 4, 5);
        addEdge(edges, 3, 4);
        addEdge(edges, 2, 3);
        addEdge(edges, 0, 6);
        isTree(n, edges);  // true
    }

    protected static void addEdge(List<Edge> edges, int i, int j) {
        edges.add(new Edge(i, j));
    }

    protected static void isTree(int n, List<Edge> edges) {
        TreeJudgeUnionB treeJudgeUnionA = new TreeJudgeUnionB(n, edges);

        boolean isTree = treeJudgeUnionA.isTree();

        System.out.println("This is a tree? " + isTree);
    }
}
