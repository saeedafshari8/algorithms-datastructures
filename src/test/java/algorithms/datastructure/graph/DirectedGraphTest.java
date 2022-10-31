package algorithms.datastructure.graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    void dfsThrowsWhenNodeIsMissing() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}});

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> graph.dfs(10));

        assertEquals("Node [10] not found", exception.getMessage());
    }

    /*
           0
         /  \
        1    2
          \
           3
           |
           4
     */
    @Test
    void dfsReturnsCorrectNodes() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}});

        String dfs = graph.dfs(0).stream().map(String::valueOf).collect(Collectors.joining(","));

        assertEquals("0,1,3,4,2", dfs);
    }

    @Test
    void bfsThrowsWhenNodeIsMissing() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}});

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> graph.bfs(10));

        assertEquals("Node [10] not found", exception.getMessage());
    }

    /*
           0
         /  \
        1    2
          \
           3
           |
           4
     */
    @Test
    void bfsReturnsCorrectNodes() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}});

        String bfs = graph.bfs(0).stream().map(String::valueOf).collect(Collectors.joining(","));

        assertEquals("0,1,2,3,4", bfs);
    }

    /*
           0
         /  \
        1    2
          \
           3
           |
           4
     */
    @Test
    void pathExistsBetweenReturnsTrueWhenThereIsSelfLoop() {
        var graph = new DirectedGraph(new int[][]{{1}});

        boolean actual = graph.pathExistsBetween(0, 0);

        assertTrue(actual);
    }

    /*
           0
         /  \
        1    2
          \
           3
           |
           4
     */
    @Test
    void pathExistsBetweenReturnsTrue() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}});

        boolean actual = graph.pathExistsBetween(0, 4);

        assertTrue(actual);
    }

    /*
           0
         /  \
        1    2
          \
           3
           |
           4
     */
    @Test
    void pathExistsBetweenReturnsFalse() {
        var graph = new DirectedGraph(new int[][]{{0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}});

        boolean actual = graph.pathExistsBetween(1, 2);

        assertFalse(actual);
    }

    /*
           0
         /  \
        1    2  5 -> 6
          \
           3
           |
           4
     */
    @Test
    void connectedComponentsReturnsCorrectListOfComponents() {
        var graph = new DirectedGraph(new int[][]{
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0}
        });

        List<String> actual = graph.connectedComponents().stream()
                .map(it -> it.stream().map(String::valueOf).collect(Collectors.joining(","))).toList();

        assertAll(
                () -> assertEquals(actual.get(0), "0,1,3,4,2"),
                () -> assertEquals(actual.get(1), "5,6")
        );
    }

    /*
           0
         /  \
        1 -> 2  5 -> 6
          \
           3
           |
           4
     */
    @Test
    void hasCycleReturnsTrue() {
        var graph = new DirectedGraph(new int[][]{
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0}
        });

        boolean actual = graph.hasCycle();

        assertTrue(actual);
    }

    /*
           0
         /  \
        1    2  5 -> 6
          \
           3
           |
           4
     */
    @Test
    void hasCycleReturnsFalse() {
        var graph = new DirectedGraph(new int[][]{
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0}
        });

        boolean actual = graph.hasCycle();

        assertFalse(actual);
    }

    /*
           0
         /  \
        1    2  5 -> 6
          \
           3
           |
           4
     */
    @Test
    void shortestPathBetweenReturnsCorrectValue() {
        var graph = new DirectedGraph(new int[][]{
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0}
        });

        int actual = graph.shortestPathBetween(0, 4);

        assertEquals(3, actual);
    }
}
