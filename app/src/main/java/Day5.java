import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    private final List<List<int[]>> ray = new ArrayList<>();

    public Day5(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            List<int[]> tmp = new ArrayList<>();
            tmp.add(Arrays.stream(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray());
            scanner.next();
            tmp.add(Arrays.stream(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray());
            ray.add(tmp);
        }
    }

    public int partOne() {
        int[][] floor = new int[1000][1000];
        for (int[] ray : floor) {
            Arrays.fill(ray, 0);
        }
        for (List<int[]> pair : ray) {
            int[] point1 = pair.get(0);
            int[] point2 = pair.get(1);
            if (point1[0] == point2[0]) {
                if (point1[1] < point2[1]) {
                    for (int i = point1[1]; i <= point2[1]; i++) {
                        floor[i][point1[0]]++;
                    }
                } else {
                    for (int i = point2[1]; i <= point1[1]; i++) {
                        floor[i][point1[0]]++;
                    }
                }
            } else if (point1[1] == point2[1]) {
                if (point1[0] < point2[0]) {
                    for (int j = point1[0]; j <= point2[0]; j++) {
                        floor[point1[1]][j]++;
                    }
                } else {
                    for (int j = point2[0]; j <= point1[0]; j++) {
                        floor[point1[1]][j]++;
                    }
                }
            }
        }
        int count = 0;
        for (int[] integers : floor) {
            for (int j = 0; j < floor.length; j++) {
                if (integers[j] >= 2)
                    count++;
            }
        }
        return count;
    }

    public int partTwo() {
        int[][] floor = new int[1000][1000];
        for (int[] ray : floor) {
            Arrays.fill(ray, 0);
        }
        for (List<int[]> pairs : ray) {
            int[] point1 = pairs.get(0);
            int[] point2 = pairs.get(1);
            if (point1[0] == point2[0]) {
                if (point1[1] < point2[1]) {
                    for (int i = point1[1]; i <= point2[1]; i++) {
                        floor[i][point1[0]]++;
                    }
                } else {
                    for (int i = point2[1]; i <= point1[1]; i++) {
                        floor[i][point1[0]]++;
                    }
                }
            } else if (point1[1] == point2[1]) {
                if (point1[0] < point2[0]) {
                    for (int j = point1[0]; j <= point2[0]; j++) {
                        floor[point1[1]][j]++;
                    }
                } else {
                    for (int j = point2[0]; j <= point1[0]; j++) {
                        floor[point1[1]][j]++;
                    }
                }
            } else {
                int distance = Math.abs(point1[0] - point2[0]);
                if (point1[0] < point2[0] && point1[1] < point2[1]) {
                    for (int i = 0; i <= distance; i++) {
                        floor[point1[1] + i][point1[0] + i]++;
                    }
                } else if (point1[0] < point2[0]) {
                    for (int i = 0; i <= distance; i++) {
                        floor[point1[1] - i][point1[0] + i]++;
                    }
                } else if (point1[1] < point2[1]) {
                    for (int i = 0; i <= distance; i++) {
                        floor[point1[1] + i][point1[0] - i]++;
                    }
                } else {
                    for (int i = 0; i <= distance; i++) {
                        floor[point2[1] + i][point2[0] + i]++;
                    }
                }
            }
        }
        int count = 0;
        for (int[] integers : floor) {
            for (int j = 0; j < floor.length; j++) {
                if (integers[j] >= 2)
                    count++;
            }
        }
        return count;
    }
}