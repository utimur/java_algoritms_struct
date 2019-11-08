package Algoritms.Search;

import java.lang.reflect.Array;
import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new LinkedList<>();
        adjacencyList.add(Arrays.asList(0));
        adjacencyList.add(Arrays.asList(1,2));
        adjacencyList.add(Arrays.asList(3,4));
        adjacencyList.add(Arrays.asList(4,5));
        adjacencyList.add(Arrays.asList(6));
        adjacencyList.add(Arrays.asList(6));
        adjacencyList.add(Arrays.asList(4));
        System.out.println(breadthFirstSearch(adjacencyList, 6, 2));
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("b","c"));
        graph.put("b", Arrays.asList("d","f"));
        graph.put("c", Arrays.asList("d","e"));
        graph.put("d", Arrays.asList());
        graph.put("f", Arrays.asList());
        graph.put("e", Arrays.asList("f"));
        System.out.println(graph);
        System.out.println(breadthSearch(graph, "a", "f" +
                ""));
    }

    public static boolean breadthSearch(Map<String, List<String>> graph, String key, String start) {
        if(!graph.containsKey(key) || !graph.containsKey(start)) return false;
        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(graph.get(start));
        while (!queue.isEmpty()) {
            String remove = queue.remove();
            if (key.equals(remove)) {
                return true;
            } else {
                if (graph.get(remove) != null) {
                    queue.addAll(graph.get(remove));
                }
            }
        }
        return false;
    }
    public static boolean breadthFirstSearch(List<List<Integer>> adjacencyList, Integer value, Integer start) {
        if(value > adjacencyList.size() || start > adjacencyList.size()) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(adjacencyList.get(start));

        int iter = 0;
        while (!queue.isEmpty()) {
            System.out.println(queue);
            iter++;
            Integer remove = queue.remove();
            if ( remove == value) {
                System.out.println(iter);
                return true;
            } else {
                queue.addAll(adjacencyList.get(remove+1));
            }
        }
        return false;
    }
}
