import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    private final List<Board> boards = new ArrayList<>();
    private final String[] order;

    public Day4(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        order = scanner.nextLine().split(",");
        while (scanner.hasNext()) {
            Integer[][] board = new Integer[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            boards.add(new Board(board));
        }
    }

    public int partOne() {
        for (String num : order) {
            for (Board board : boards) {
                int[] cord = searchBoard(board, Integer.parseInt(num));
                if (cord[0] != -1) {
                    board.selectBoard[cord[0]][cord[1]] = true;
                }
                if (boardComplete(board.selectBoard)) {
                    return returnUnmarked(board) * Integer.parseInt(num);
                }
            }
        }
        return 0;
    }

    public int[] searchBoard(Board board, int target) {
        for (int i = 0; i < board.valueBoard.length; i++) {
            for (int j = 0; j < board.valueBoard.length; j++) {
                if (board.valueBoard[i][j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public boolean boardComplete(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j])
                    count++;
            }
            if (count == 5)
                return true;
        }
        // PLEASE FOR THE LOVE OF GOD REWRITE THIS METHOD
        for (int j = 0; j < board.length; j++) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j])
                    count++;
            }
            if (count == 5)
                return true;
        }
        return false;
    }

    public int returnUnmarked(Board board) {
        int sum = 0;
        for (int i = 0; i < board.selectBoard.length; i++) {
            for (int j = 0; j < board.selectBoard.length; j++) {
                if (!board.selectBoard[i][j]) {
                    sum += board.valueBoard[i][j];
                }
            }
        }
        return sum;
    }

    public int partTwo() {
        for (String num : order) {
            for (int i = 0; i < boards.size(); i++) {
                Board board = boards.get(i);
                int[] cord = searchBoard(board, Integer.parseInt(num));
                if (cord[0] != -1) {
                    board.selectBoard[cord[0]][cord[1]] = true;
                }
                if (boardComplete(board.selectBoard)) {
                    if (boards.size() > 1) {
                        boards.remove(board);
                        i--;
                    } else
                        return returnUnmarked(board) * Integer.parseInt(num);
                }
            }
        }
        return 0;
    }
}

class Board {
    Integer[][] valueBoard;
    boolean[][] selectBoard;

    public Board(Integer[][] valueBoard) {
        this.valueBoard = valueBoard;
        selectBoard = new boolean[valueBoard.length][valueBoard.length];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                selectBoard[i][j] = false;
            }
        }
    }
}