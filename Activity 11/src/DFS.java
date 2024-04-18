import java.util.*;

public class DFS {
    public List<String> traverse(String root, Map<String, List<String>> graph) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        // Start by pushing the root node onto the stack
        stack.push(root);

        while (!stack.isEmpty()) {
            String node = stack.pop();

            // If the node has not been visited, we process it
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);

                // Get all adjacent nodes; push them onto the stack in reverse order
                // to maintain correct order of traversal
                List<String> neighbors = graph.get(node);
                if (neighbors != null) {
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        String neighbor = neighbors.get(i);
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        return result;
    }

}

