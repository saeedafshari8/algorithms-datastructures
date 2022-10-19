package algorithms.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Graph {

    List<Integer> dfs(int node);

    List<Integer> bfs(int node);

    boolean pathExistsBetween(Integer source, Integer destination);

    boolean hasCycle();

    boolean isMulti();

    boolean isPseudo();

    boolean isNull();

    boolean isComplete();

    boolean isRegular();

    List<List<Integer>> connectedComponents();

    List<List<Integer>> stronglyConnectedComponents();

    List<Integer> shortestPathBetween(Integer source, Integer destination);

    int inDegreeOfNode(Integer node);

    int outDegreeOfNode(Integer node);

    /*
    DAG: Directed Acyclic Graph
     */
    List<Integer> topologicalSort(Integer node);

    static Map<Integer, List<Integer>> directedGraphMatrixToAdjacencyMap(int[][] graph) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    tmp.add(j);
                }
            }
            result.put(i, tmp);
        }
        return result;
    }
}
