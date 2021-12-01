import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Day1 {
    private final List<Integer> ray = new ArrayList<>();

    public Day1(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            ray.add(scanner.nextInt());
        }
    }

    public int partOne() {
        int prev = MAX_VALUE;
        int count = 0;
        for (Integer integer : ray) {
            if (integer > prev) {
                count++;
            }
            prev = integer;
        }
        return count;
    }

    public int partTwo() {
        int prevSum = MAX_VALUE;
        int countSum = 0;
        int i = 0;
        while (i < ray.size() - 2) {
            int curSum = ray.get(i) + ray.get(i + 1) + ray.get(i + 2);
            if (curSum > prevSum)
                countSum++;
            prevSum = curSum;
            i++;
        }
        return countSum;
    }
}
