package Algoritms.Search;

import java.util.*;
import java.util.logging.Handler;
import java.util.stream.Collectors;

public class AlgDijkstra {
    public static void main(String[] args) {
        Map<String, HashMap<String, Integer>> graph
                = new HashMap<>();
        graph.put("a", new HashMap<>(){{
            put("b",3);
            put("c",4);
        }});
        graph.put("b", new HashMap<>(){{
            put("f",4);
            put("d",1);
        }});
        graph.put("c", new HashMap<>(){{
            put("d",1);
            put("e",1);
        }});
        graph.put("d", new HashMap<>());
        graph.put("e", new HashMap<>(){{
            put("f",1);
        }});
        graph.put("f", new HashMap<>());
        algDejkstra(graph, "a", "f");
    }

    public static int algDejkstra(Map<String, HashMap<String, Integer>> graph, String start, String end) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) return 0;
        Map<String, Integer> shortPath = new HashMap<>();
        for (String key : graph.keySet()) {
            shortPath.put(key, 0);
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String remove = queue.remove();
            HashMap<String, Integer> map = graph.get(remove);
            queue.addAll(map.keySet());
            for (String key : map.keySet()) {
                shortPath.replace(key, shortPath.get(key) + map.get(key));
            }
        }
        System.out.println(shortPath);
        return 0;
    }
}
