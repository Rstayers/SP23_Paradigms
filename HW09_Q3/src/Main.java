import java.util.*;
public class Main {
    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();

        // Test Case 1
        Map<String, List<String>> tree1 = new HashMap<>();
        tree1.put("a", Arrays.asList("b", "c"));
        tree1.put("b", Collections.emptyList());
        tree1.put("c", Arrays.asList("d", "e"));
        tree1.put("d", Collections.emptyList());
        tree1.put("e", Collections.emptyList());

        List<String> output1 = traversal.traverse("a", tree1);
        System.out.println(output1); // Expected: ["a", "b", "c", "e", "d"]

        // Test Case 2
        Map<String, List<String>> tree2 = new HashMap<>();
        tree2.put("A", Arrays.asList("B", "C"));
        tree2.put("B", Arrays.asList("D", "E"));
        tree2.put("C", Arrays.asList("F", "G"));
        tree2.put("D", Collections.emptyList());
        tree2.put("E", Collections.emptyList());
        tree2.put("F", Collections.emptyList());
        tree2.put("G", Collections.emptyList());

        List<String> output2 = traversal.traverse("A", tree2);
        System.out.println(output2); // Expected: ["A", "B", "C", "G", "F", "E", "D"]
    }
}