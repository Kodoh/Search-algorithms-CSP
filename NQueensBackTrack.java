import java.util.ArrayList;
import java.util.List;

public class NQueensBackTrack {
    private static int n;
    private static List<List<String>> solutions;

    public static void main(String[] args) {
        n = Integer.parseInt(args[0]);
        solutions = new ArrayList<>();
        int[] positions = new int[n];
        backtrack(0, positions);
        printSolutions();
    }

    public static void backtrack(int depth, int[] positions) {
        if (depth == n) {
            addSolution(positions);
            return;
        }

        for (int d = 0; d < n; d++) { // Foreach d in D_depth
            positions[depth] = d; // assign(x_depth, d)
            boolean consistent = true; // Assume placement is valid

            for (int past = 0; past < depth && consistent; past++) { // For past = 1 to depth-1
                consistent = isSafe(past, depth, positions); // Check consistency
            }

            if (consistent) {
                backtrack(depth + 1, positions); // Proceed to next depth
            }
        }
    }

    private static boolean isSafe(int past, int depth, int[] positions) {
        return positions[past] != positions[depth] &&
               Math.abs(positions[past] - positions[depth]) != (depth - past);
    }

    private static void addSolution(int[] positions) {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (positions[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        solutions.add(solution);
    }

    private static void printSolutions() {
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println("Total Solutions: " + solutions.size());
    }
}

