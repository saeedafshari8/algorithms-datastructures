package algorithms.datastructure.graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void directedGraphMatrixToAdjacencyMapWorksCorrectly() {
        int[][] graph = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        Map<Integer, List<Integer>> adjacencyMap = Graph.directedGraphMatrixToAdjacencyMap(graph);

        assertAll(
                () -> assertEquals("0,1,2", adjacencyMap.keySet().stream().map(String::valueOf).collect(Collectors.joining(","))),
                () -> assertEquals("0,1,2", adjacencyMap.get(0).stream().map(String::valueOf).collect(Collectors.joining(","))),
                () -> assertEquals("0,1,2", adjacencyMap.get(1).stream().map(String::valueOf).collect(Collectors.joining(","))),
                () -> assertEquals("0,1,2", adjacencyMap.get(2).stream().map(String::valueOf).collect(Collectors.joining(",")))
        );
    }
}
