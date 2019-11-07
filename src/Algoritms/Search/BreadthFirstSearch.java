package Algoritms.Search;

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
        System.out.println(breadthFirstSearch(adjacencyList, 6));
    }

    public static boolean breadthFirstSearch(List<List<Integer>> adjacencyList, Integer value) {
        if(value > adjacencyList.size()) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(adjacencyList.get(0));
//        System.out.println(queue);
//        System.out.println(queue.remove());
//        System.out.println(queue);
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
