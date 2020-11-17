package interviews;
  
import java.util.*;

public class course_sch_dfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map < Integer, List < Integer >> adjMap = new HashMap < > ();
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            if (adjMap.get(v) == null) {
                adjMap.put(v, new ArrayList < > ());
            }
            adjMap.get(v).add(u);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false && isCyclicDFSUtil(i, adjMap, visited, recursionStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclicDFSUtil(int node, Map < Integer, List < Integer >> adjMap, boolean[] visited, boolean[] recursionStack) {
        System.out.print(node);
        System.out.print(" | ");
        System.out.print(adjMap);
        System.out.print(" | ");
        System.out.print(visited);
        System.out.print(" | ");
        System.out.println(recursionStack);
        visited[node] = true;
        recursionStack[node] = true;
        List < Integer > adjList = adjMap.getOrDefault(node, new ArrayList < > ());
        for (int next: adjList) {
            if (visited[next] == false) {
                if (isCyclicDFSUtil(next, adjMap, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[next] == true) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1}};
        int numCourses = 2;
        course_sch_dfs a = new course_sch_dfs();
        a.canFinish(numCourses, prerequisites);
    }
}