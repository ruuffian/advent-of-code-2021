import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    private final List<Integer[][]> boards = new ArrayList<>();
    private final int[] order;

    public Day4(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        order = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        while (scanner.hasNext()) {
            Integer[][] board = new Integer[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            boards.add(board);
        }
    }

    public int partOne() {
        for (int num : order) {
            for (Integer[][] board : boards) {
                int[] cord = searchBoard(board, num);
                if (cord[0] != -1) {
                    board[cord[0]][cord[1]] = -1;
                }
                if (boardComplete(board)) {
                    return returnUnmarked(board) * num;
                }
            }
        }
        return 0;
    }

    public int partTwo() {
        for (int num : order) {
            for (int i = 0; i < boards.size(); i++) {
                Integer[][] board = boards.get(i);
                int[] cord = searchBoard(board, num);
                if (cord[0] != -1) {
                    board[cord[0]][cord[1]] = -1;
                }
                if (boardComplete(board)) {
                    if (boards.size() > 1) {
                        boards.remove(board);
                        i--;
                    } else
                        return returnUnmarked(board) * num;
                }
            }
        }
        return 0;
    }

    public int[] searchBoard(Integer[][] board, int target) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public boolean boardComplete(Integer[][] board) {
        for (int i = 0; i < board.length; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1)
                    rowCount++;
                if (board[j][i] == -1)
                    colCount++;
            }
            if (rowCount == 5 || colCount == 5)
                return true;
        }
        return false;
    }

    public int returnUnmarked(Integer[][] board) {
        int sum = 0;
        for (Integer[] row : board) {
            for (Integer val : row) {
                if (val != -1) {
                    sum += val;
                }
            }
        }
        return sum;
    }
}