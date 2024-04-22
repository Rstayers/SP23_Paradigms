import java.util.*;

public class TreeTraversal {

        public List<String> traverse(String root, Map<String, List<String>> tree) {
            if (root == null || tree.isEmpty()) {
                return Collections.emptyList();
            }

            List<String> result = new ArrayList<>();
            Deque<String> currentLevel = new LinkedList<>();
            Deque<String> nextLevel = new LinkedList<>();
            boolean leftToRight = true;

            currentLevel.offer(root);

            while (!currentLevel.isEmpty()) {
                String node = leftToRight ? currentLevel.pollLast() : currentLevel.pollFirst();
                result.add(node);

                List<String> children = tree.getOrDefault(node, Collections.emptyList());

                // If we're going left to right, add the children to next level from left to right, so they can be processed from right to left on the next level
                if (leftToRight) {
                    if (children.size() == 1) {
                        nextLevel.offerFirst(children.get(0));
                    } else if (children.size() == 2) {
                        nextLevel.offerFirst(children.get(1));
                        nextLevel.offerFirst(children.get(0));
                    }
                } else {
                    // If we're going right to left, add the children to next level from right to left, so they can be processed from left to right on the next level
                    for (String child : children) {
                        nextLevel.offerLast(child);
                    }
                }

                // If the current level is empty, we switch to the next level and change the traversal direction
                if (currentLevel.isEmpty()) {
                    leftToRight = !leftToRight;
                    Deque<String> temp = currentLevel;
                    currentLevel = nextLevel;
                    nextLevel = temp;
                }
            }

            return result;
        }


}
