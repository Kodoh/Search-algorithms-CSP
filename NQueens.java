import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private static int n;

    public static void main(String[] args) {
        n = Integer.parseInt(args[0]);
        solveFourQueens();
    }

    public static void solveFourQueens() {
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
            if (isValid(positions)) {
                solutions.add(positions.clone()); // Add valid solution
            }
            return;
        }

        for (int col = 0; col < n; col++) {
            positions[row] = col;
            generatePermutations(positions, row + 1, solutions);
        }
    }

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
