import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6 {
    private final List<Integer> ray = new ArrayList<>();

    public Day6(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        scanner.useDelimiter(",").tokens().mapToInt(Integer::parseInt).forEach(ray::add);
        scanner.close();
    }

    // If I had any brain at all, I would have done part 1 the same way I did part 2. Unfortunately, I have less than any brain at all. :(
    public int partOne() {
        List<Integer> ocean = new ArrayList<>(ray);
        for (int day = 0; day < 80; day++) {
            List<Integer> dayPassed = new ArrayList<>();
            for (Integer fish : ocean) {
                if (fish != 0)
                    dayPassed.add(--fish);
                else {
                    dayPassed.add(6);
                    dayPassed.add(8);
                }
            }
            ocean = dayPassed;
        }
        return ocean.size();
    }

    public long partTwo() {
        Map<Integer, Long> fishCount = new HashMap<>();
        Arrays.stream(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8}).forEach(key -> fishCount.put(key, 0L));
        ray.forEach(fish -> fishCount.compute(fish, (key, val) -> (val == null) ? 0 : val + 1));
        for (int day = 0; day < 256; day++) {
            long fishCreated = fishCount.get(0);
            for (int i = 0; i < 9; i++) {
                int index = i;
                if (i < 8)
                    fishCount.compute(i, (key, val) -> (val == null) ? 0 : fishCount.get(index + 1));
                else
                    fishCount.put(8, fishCreated);
            }
            fishCount.compute(6, (key, val) -> (val == null) ? 0 : val + fishCreated);
        }
        return fishCount.values().stream().reduce(0L, Long::sum);
    }
}