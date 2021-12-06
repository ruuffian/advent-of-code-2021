import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6 {
    private final List<String> ray = new ArrayList<>();

    public Day6(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            ray.add(scanner.next());
        }
    }

    public int partOne() {
        return 0;
    }

    public int partTwo() {
        return 0;
    }
}