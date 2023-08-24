package com.company;
//Description: printing a graph matrix

public class Graph {
    private int numOfNodes;
    private boolean directed;
    private boolean weighted;
    private float[][] matrix;
    private boolean[][] isSetMatrix;

    public Graph(int numOfNodes, boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
        this.numOfNodes = numOfNodes;
        matrix = new float[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
    }

    public void addEdge(int source, int destination, float weight) {
        float valueToAdd = weight;

        if (!weighted) {
            valueToAdd = 1;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                //We only want to print the values of those positions that have been marked as set
                if (isSetMatrix[i][j]) {
                    System.out.format("%8s", matrix[i][j]);
                }
                else {
                    System.out.format("%8s", "/  ");
                }
            }
            System.out.println();
        }
    }

   public static void main(String[] args) {

       Graph graph = new Graph(9, false, true);
       graph.addEdge(2, 1, 7);
       graph.addEdge(3, 1, 9);
       graph.addEdge(6, 1, 14);
       graph.addEdge(2, 3, 10);
       graph.addEdge(2, 4, 15);
       graph.addEdge(3, 6, 2);
       graph.addEdge(3, 4, 11);
       graph.addEdge(4, 5, 1);
       graph.addEdge(5, 6, 1);

       graph.printMatrix();
   }
}
