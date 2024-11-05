import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private static int n;

    public static void main(String[] args) {
        n = Integer.parseInt(args[0]);
        solveFourQueens();
    }

    public static void solveFourQueens() {
        // 1D array to save space (each row needs a Queen hence just store where queen is on that row).
        int[] positions = new int[n];
        List<int[]> solutions = new ArrayList<>(); 

        generatePermutations(positions, 0, solutions);

        if (solutions.isEmpty()) {
            System.out.println("No solutions found.");
        } else {
            System.out.println("Solutions for the N-Queens problem:");
            for (int[] solution : solutions) {
                printSolution(solution);
            }
        }
    }

    public static void generatePermutations(int[] positions, int row, List<int[]> solutions) {
        if (row == n) {
            // if final row and we have a valid position then add to solutions
            if (isValid(positions)) {
                solutions.add(positions.clone()); // Add valid solution
            }
            return;
        }
        
        // if not final row / not valid just keep assigning values
        for (int col = 0; col < n; col++) {
            positions[row] = col;
            generatePermutations(positions, row + 1, solutions);
        }
    }

    // if on diagnols / horizontal / vertical then not valid else valid
    public static boolean isValid(int[] positions) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (positions[i] == positions[j] || Math.abs(positions[i] - positions[j]) == j - i) {
                    return false;
                }
            }
        }
        return true;
    }

    // displaying as an array would be boring no?
    public static void printSolution(int[] positions) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (positions[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
