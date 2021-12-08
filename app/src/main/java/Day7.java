import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Day7 {
    private final Map<Integer, Integer> freqList = new HashMap<>();

    public Day7(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            int next = scanner.nextInt();
            freqList.compute(next, (key, val) -> (val == null) ? 1 : val + 1);
        }
    }

    public int partOne() {
        int min = MAX_VALUE;
        Map<Integer, Integer> cache = new HashMap<>();

        for (Integer pos : freqList.keySet()) {
            int sum = 0;
            if (!cache.containsKey(pos)) {
                for (int pos2 : freqList.keySet()) {
                    if (pos != pos2)
                        sum += freqList.get(pos2) * Math.abs(pos2 - pos);
                }
                cache.put(pos, sum);
            } else {
                sum = cache.get(pos);
            }
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }

    public int partTwo() {
        int min = MAX_VALUE;
        Map<Integer, Integer> cache = new HashMap<>();
        for (Integer pos : freqList.keySet()) {
            int sum = 0;
            if (!cache.containsKey(pos)) {
                for (int pos2 : freqList.keySet()) {
                    int n = Math.abs(pos - pos2);
                    sum += freqList.get(pos2) * (n * (n + 1)) / 2;
                }
                cache.put(pos, sum);
            } else {
                sum = cache.get(pos);
            }
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }
}
