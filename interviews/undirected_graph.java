package interviews;

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

public class undirected_graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int nVerts;
    private Queue<Integer> q;

    public undirected_graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        q = new LinkedList<Integer>();
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

}

class Graph {
    class Edge {
        public int v,w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public Graph(int n) {

    }
}
