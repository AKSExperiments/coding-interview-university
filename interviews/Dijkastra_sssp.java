package interviews;
//sssp - Single source shortest path
public class Dijkastra_sssp {
    // visited vertices
    // hashmap for every vertex, and corresponding distance, updated when a shorter path is found
    //

    // visit neighbours of source, allot edge values
    // find min of all current edges
    // explore that edge, visit it's neighbors, update the hashmap
    static final int V = 9;

    int minDistance(int[] dist, Boolean[] visited) {
        int min_dist = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] < min_dist) {
                min_dist = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void dijkstra(int[][] graph, int src) {
        // distance array
        // boolean visited array
        int[] dist = new int[V];
        Boolean[] visited = new Boolean[V];

        // initialize
        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // set src dist as 0
        dist[src] = 0;
        // iterate over vertices
        for(int count = 0; count < V - 1; count++) {
            // update the min distance for
            int u = minDistance(dist, visited);
            visited[count] = true;
            for( int i = 0; i < V; i++) {
                if(!visited[i] && graph[u][i]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkastra_sssp t = new Dijkastra_sssp();
        t.dijkstra(graph, 0);
    }
}
