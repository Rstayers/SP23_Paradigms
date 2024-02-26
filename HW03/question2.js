function solve(amount, bottles) {
    const visited = new Set();
    const queue = [[[...Array(bottles.length).fill(0)], [[...Array(bottles.length).fill(0)]]]]; // Initialize with all bottles empty and an empty path
    visited.add(queue[0][0].toString());

    while (queue.length > 0) {
        const [currentState, currentPath] = queue.shift();

        // Check if any bottle reaches the target amount
        for (let i = 0; i < currentState.length; i++) {
            if (currentState[i] === amount) {
				finalState = [...Array(bottles.length).fill(0)];
				finalState[i] = amount;
                return currentPath.concat([finalState]);
            }
        }

        // Generate all possible next states
        for (let i = 0; i < currentState.length; i++) {
            // Fill bottle i
            if (currentState[i] < bottles[i]) {
                const nextStateFill = [...currentState];
                nextStateFill[i] = bottles[i];
                const nextPathFill = [...currentPath, nextStateFill];
                if (!visited.has(nextStateFill.toString())) {
                    queue.push([nextStateFill, nextPathFill]);
                    visited.add(nextStateFill.toString());
                }
            }

            // Empty bottle i
            if (currentState[i] > 0) {
                const nextStateEmpty = [...currentState];
                nextStateEmpty[i] = 0;
                const nextPathEmpty = [...currentPath, nextStateEmpty];
                if (!visited.has(nextStateEmpty.toString())) {
                    queue.push([nextStateEmpty, nextPathEmpty]);
                    visited.add(nextStateEmpty.toString());
                }
            }

            // Pour from bottle i to bottle j
            for (let j = 0; j < currentState.length; j++) {
                if (i !== j) {
                    const nextStatePour = [...currentState];
                    const pourAmount = Math.min(nextStatePour[i], bottles[j] - nextStatePour[j]);
                    nextStatePour[i] -= pourAmount;
                    nextStatePour[j] += pourAmount;
                    const nextPathPour = [...currentPath, nextStatePour];
                    if (!visited.has(nextStatePour.toString())) {
                        queue.push([nextStatePour, nextPathPour]);
                        visited.add(nextStatePour.toString());
                    }
                }
            }
        }
    }

    return null; // If target amount cannot be reached
}


// Example usage:
console.log(solve(2, [5, 3])); // Output: [ [0, 0], [5, 0], [2, 3], [2, 0] ]
console.log(solve(1, [2, 4])); // Output: null
console.log(solve(8, [10, 2, 1])); // Output: [ [0, 0, 0], [10, 0, 0], [8, 2, 0], [8, 0, 0] ]
console.log(solve(8, [3, 4, 2, 1])); // Output: null

