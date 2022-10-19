#DirectedGraph
A simple implementation of a binary tree with the following functionalities

```java
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
```

## List<Integer> dfs(int node)

Depth-first traverse of a graph

## List<Integer> bfs(int node)

Breadth-first traverse of a graph

## boolean pathExistsBetween(Integer source, Integer destination)

Checks if there is a path between two nodes in a graph

## boolean hasCycle()

Checks if there is a cycle in a graph

## boolean isMulti()

## boolean isPseudo()

## boolean isNull()

## boolean isComplete()

## boolean isRegular()

## List<List<Integer>> connectedComponents()

Returns a list of connected components in a graph

## Returns a list of connected components in a graph

## List<Integer> shortestPathBetween(Integer source, Integer destination);

## int inDegreeOfNode(Integer node)

## int outDegreeOfNode(Integer node)

## List<Integer> topologicalSort(Integer node)

Sorts a DAG: Directed Acyclic Graph 
