import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;

public class Day9 {
    private final Integer[][] map = new Integer[100][100];

    public Day9(File inputFile) throws FileNotFoundException {
        Scanner lines = new Scanner(inputFile);
        int i = 0, j = 0;
        while (lines.hasNext()) {
            Scanner heights = new Scanner(lines.nextLine()).useDelimiter("");
            while (heights.hasNext()) {
                map[i][j] = heights.nextInt();
                j++;
            }
            i++;
            j = 0;
        }
    }

    public int partOne() {
        int cur, sum = 0;
        for (int i = 0; i < map.length; i++) {
            boolean low;
            for (int j = 0; j < map[i].length; j++) {
                cur = map[i][j];
                low = true;
                if (i > 0) {
                    if (cur >= map[i - 1][j]) low = false;
                }
                if (i < map.length - 1) {
                    if (cur >= map[i + 1][j]) low = false;
                }
                if (j > 0) {
                    if (cur >= map[i][j - 1]) low = false;
                }
                if (j < map[i].length - 1) {
                    if (cur >= map[i][j + 1]) low = false;
                }
                if (low) sum += cur + 1;
            }
        }
        return sum;
    }

    public int partTwo() {
        int cur;
        List<Integer[]> lowest = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            boolean low;
            for (int j = 0; j < map[i].length; j++) {
                cur = map[i][j];
                low = true;
                if (i > 0) {
                    if (cur >= map[i - 1][j]) low = false;
                }
                if (i < map.length - 1) {
                    if (cur >= map[i + 1][j]) low = false;
                }
                if (j > 0) {
                    if (cur >= map[i][j - 1]) low = false;
                }
                if (j < map[i].length - 1) {
                    if (cur >= map[i][j + 1]) low = false;
                }
                if (low) lowest.add(new Integer[]{i, j});
            }
        }
        int[] maxes = new int[3];
        maxes[0] = MIN_VALUE;
        maxes[1] = MIN_VALUE;
        maxes[2] = MIN_VALUE;
        for (Integer[] cords : lowest) {
            int sum = traversal(cords[0], cords[1]);
            Arrays.sort(maxes);
            int tmp;
            if (sum > maxes[0]) {
                if (sum > maxes[1]) {
                    if (sum > maxes[2]) {
                        tmp = maxes[2];
                        maxes[2] = sum;
                        maxes[0] = maxes[1];
                        maxes[1] = tmp;
                    } else {
                        tmp = maxes[1];
                        maxes[1] = sum;
                        maxes[0] = tmp;
                    }
                } else maxes[0] = sum;
            }
        }
        return maxes[0] * maxes[1] * maxes[2];
    }

    public int traversal(int i, int j) {
        return 1 + traversal(i, j, new ArrayList<>());
    }

    private int traversal(int i, int j, List<int[]> visited) {
        int sum = 0;
        int[] curr = new int[]{i, j};
        if (i > 0) {
            if (map[i - 1][j] != 9 && !hasBeenVisited(visited, i - 1, j)) {
                visited.add(curr);
                sum += 1 + traversal(i - 1, j, visited);
            }
        }
        if (j < map[0].length - 1) {
            if (map[i][j + 1] != 9 && !hasBeenVisited(visited, i, j + 1)) {
                visited.add(curr);
                sum += 1 + traversal(i, j + 1, visited);
            }
        }
        if (i < map.length - 1) {
            if (map[i + 1][j] != 9 && !hasBeenVisited(visited, i + 1, j)) {
                visited.add(curr);
                sum += 1 + traversal(i + 1, j, visited);
            }
        }
        if (j > 0) {
            if (map[i][j - 1] != 9 && !hasBeenVisited(visited, i, j - 1)) {
                visited.add(curr);
                sum += 1 + traversal(i, j - 1, visited);
            }
        }
        visited.add(curr);
        return sum;
    }

    boolean hasBeenVisited(List<int[]> visited, int i, int j) {
        for (int[] visit : visited) {
            if (visit[0] == i && visit[1] == j) return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer[] nums : map) {
            for (Integer num : nums) {
                builder.append(" ").append(num).append(" ");
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}