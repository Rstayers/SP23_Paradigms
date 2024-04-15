public class Homework8 {
    public boolean check(char[] correctPositions, String word) {
        if (correctPositions.length == 0) {
            return true; // If no positions are specified, it is true.
        }

        for (int i = 0; i < correctPositions.length; i++) {
            if (correctPositions[i] != '*') { // Check specific character match
                if (i >= word.length() || correctPositions[i] != word.charAt(i)) {
                    return false; // Return false if characters don't match or index is out of bounds for the word
                }
            }
        }
        return true; // If all checks are passed, return true
    }
}
