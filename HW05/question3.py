class Node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right

    def __str__(self):
        return self.value


class tree_iterator:
    def __init__(self, root):
        self.root = root

    def __iter__(self):
        # Initialize the iterator state: queue for current level nodes, direction flag, and next level nodes queue.
        self.current_level = [self.root] if self.root else []
        self.left_to_right = False
        self.next_level = []
        self.level_values = []
        self.level_index = 0  # Index to keep track of current node in the level_values.
        return self

    def __next__(self):
        # When level_values is exhausted, prepare the next level.
        if self.level_index >= len(self.level_values):
            if not self.current_level and not self.next_level:
                raise StopIteration  # No more elements to traverse.

            # Process the current level, prepare for the next level.
            self.level_values = [node.value for node in self.current_level]
            if not self.left_to_right:
                self.level_values.reverse()

            # Prepare next level and switch direction.
            for node in self.current_level:
                if node.left:
                    self.next_level.append(node.left)
                if node.right:
                    self.next_level.append(node.right)

            self.current_level = self.next_level
            self.next_level = []
            self.left_to_right = not self.left_to_right
            self.level_index = 0

        # Return the current element and move to the next one.
        value = self.level_values[self.level_index]
        self.level_index += 1
        return value


e = Node("E", None, None)
d = Node("D", None, None)
c = Node("C", d, e)
b = Node("B", None, None)
root = Node("A", b, c)
for v in tree_iterator(root):
    print(v)
