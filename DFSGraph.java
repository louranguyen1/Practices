package com.company;

//create a DFS graph
//DFS = try to print out as many nodes as possible starting at source node

public class DFSGraph {

    public int[][] mat;
    public int vert;

    public DFSGraph(int v) {
        vert = v;
        mat = new int[v][v];

        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < v; ++j)
                mat[i][j] = 0;
        }
    }

    public void addEdge(int u, int v) {
        mat[u][v] = 1;
    }


    private static void DFSUtil(DFSGraph g, int v, int[] vis) {
        System.out.print(v + " ");
        vis[v] = 1;
        for (int i = 0; i < g.vert; ++i) {
            if (g.mat[v][i] == 1 && vis[i] != 1) {

                DFSUtil(g, i, vis);
            }
        }
    }

    public static void DFS(DFSGraph g, int start) {
        int[] vis = new int[g.vert];
        for (int i = 0; i < g.vert; ++i)
            vis[i] = 0;

        DFSUtil(g, start, vis);

        for (int i = 0; i < g.vert; ++i) {
            if (vis[i] != 1)
                DFSUtil(g, i, vis);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DFSGraph g = new DFSGraph(5);
        g.addEdge(1, 0);
        g.addEdge(2, 0);
        g.addEdge(3, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 3);

        DFS(g, 0);
        DFS(g, 1);
        DFS(g, 2);
        DFS(g, 3);
        DFS(g, 4);
    }

}
