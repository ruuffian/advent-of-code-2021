import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                    if (cur >= map[i - 1][j])
                        low = false;
                }
                if (i < map.length - 1) {
                    if (cur >= map[i + 1][j])
                        low = false;
                }
                if (j > 0) {
                    if (cur >= map[i][j - 1])
                        low = false;
                }
                if (j < map[i].length - 1) {
                    if (cur >= map[i][j + 1])
                        low = false;
                }
                if (low)
                    sum += cur + 1;
            }
        }
        return sum;
    }

    public int partTwo() {
        return 0;
    }
}