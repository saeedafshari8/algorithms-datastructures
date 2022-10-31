package algorithms.datastructure.graph;

import java.util.*;

public class DirectedGraph implements Graph {

    private final Map<Integer, List<Integer>> adjacencyMap;

    public DirectedGraph(int[][] adjacencyMatrix) {
        this.adjacencyMap = Graph.directedGraphMatrixToAdjacencyMap(adjacencyMatrix);
    }

    public DirectedGraph(Map<Integer, List<Integer>> adjacencyMap) {
        this.adjacencyMap = adjacencyMap;
    }

    @Override
    public List<Integer> dfs(int node) {
        if (!adjacencyMap.containsKey(node)) {
            throw new IllegalStateException(String.format("Node [%d] not found", node));
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        dfsRecursive(result, node, visitedSet);
        return result;
    }

    private void dfsRecursive(List<Integer> result, int node, Set<Integer> visitedSet) {
        if (visitedSet.contains(node)) return;
        result.add(node);
        visitedSet.add(node);
        List<Integer> neighbors = adjacencyMap.get(node);
        if (neighbors == null) return;
        for (int neighbor : neighbors) {
            dfsRecursive(result, neighbor, visitedSet);
        }
    }

    @Override
    public List<Integer> bfs(int node) {
        if (!adjacencyMap.containsKey(node)) {
            throw new IllegalStateException(String.format("Node [%d] not found", node));
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Integer> aQueue = new ArrayDeque<>();
        aQueue.add(node);
        while (!aQueue.isEmpty()) {
            Integer aNode = aQueue.remove();
            if (visitedSet.contains(aNode)) continue;
            result.add(aNode);
            visitedSet.add(aNode);
            List<Integer> neighbors = adjacencyMap.get(aNode);
            if (neighbors == null) continue;
            aQueue.addAll(neighbors);
        }
        return result;
    }

    @Override
    public boolean pathExistsBetween(Integer source, Integer destination) {
        return dfs(source).contains(destination);
    }

    @Override
    public boolean hasCycle() {
        Set<Integer> visitedSet = new HashSet<>();
        for (Integer node : adjacencyMap.keySet()) {
            if (visitedSet.contains(node)) continue;
            if (hasCycleRecursive(node, node, visitedSet)) return true;
        }
        return false;
    }

    private boolean hasCycleRecursive(Integer node, Integer sourceNode, Set<Integer> visitedSet) {
        if (visitedSet.contains(node) && node.equals(sourceNode)) return true;
        if (visitedSet.contains(node)) return false;
        visitedSet.add(node);
        List<Integer> neighbors = adjacencyMap.get(node);
        if (neighbors == null) return false;
        for (Integer neighbor : neighbors) {
            if (hasCycleRecursive(neighbor, sourceNode, visitedSet)) return true;
        }
        return false;
    }

    @Override
    public boolean isMulti() {
        return false;
    }

    @Override
    public boolean isPseudo() {
        return false;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean isRegular() {
        return false;
    }

    @Override
    public List<List<Integer>> connectedComponents() {
        List<List<Integer>> components = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        for (Integer node : adjacencyMap.keySet()) {
            List<Integer> result = new ArrayList<>();
            dfsRecursive(result, node, visitedSet);
            if (!result.isEmpty()) components.add(result);
        }
        return components;
    }

    @Override
    public List<List<Integer>> stronglyConnectedComponents() {
        return null;
    }

    @Override
    public int shortestPathBetween(Integer source, Integer destination) {
        Queue<Map.Entry<Integer, Integer>> aQueue = new ArrayDeque<>();
        aQueue.add(new AbstractMap.SimpleEntry<>(source, 0));
        Set<Integer> visited = new HashSet<>();

        while (!aQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = aQueue.remove();
            if (visited.contains(entry.getKey())) {
                continue;
            }
            visited.add(entry.getKey());
            if (Objects.equals(entry.getKey(), destination)) return entry.getValue();
            List<Integer> neighbors = adjacencyMap.get(entry.getKey());
            if (neighbors == null) continue;
            for (Integer neighbor : neighbors) {
                aQueue.add(new AbstractMap.SimpleEntry<>(neighbor, entry.getValue() + 1));
            }
        }
        return -1;
    }

    @Override
    public int inDegreeOfNode(Integer node) {
        return 0;
    }

    @Override
    public int outDegreeOfNode(Integer node) {
        return 0;
    }

    @Override
    public List<Integer> topologicalSort(Integer node) {
        return null;
    }
}
