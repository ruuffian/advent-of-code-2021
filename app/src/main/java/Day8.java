import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day8 {
    private final List<SevenSegment> ray = new ArrayList<>();

    public Day8(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        String delim = "[|]|\\n";
        scanner.useDelimiter(delim);
        while (scanner.hasNext()) {
            SevenSegment tmp = new SevenSegment();
            String test = scanner.next().trim();
            String dig = scanner.next().trim();
            tmp.testSig = test.split(" ");
            tmp.digitSig = dig.split(" ");
            ray.add(tmp);
        }
    }

    public int partOne() {
        int count = 0;
        for (SevenSegment seg : ray) {
            for (String dig : seg.digitSig) {
                if (dig.length() == 2 || dig.length() == 4 || dig.length() == 3 || dig.length() == 7)
                    count++;
            }
        }
        return count;
    }

    public int partTwo() {
        for (SevenSegment seg : ray) {
            ArrayList[] possible;
            possible = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>()};
            for (String test : seg.testSig) {
                if (test.length() == 2) {
                    seg.one.addAll(Arrays.stream(test.split("")).collect(Collectors.toList()));
                }
                if (test.length() == 4) {
                    seg.four.addAll(Arrays.stream(test.split("")).collect(Collectors.toList()));
                }
                if (test.length() == 3) {
                    seg.seven.addAll(Arrays.stream(test.split("")).collect(Collectors.toList()));
                }
                // 1,4,7,8
            }
            for (String s : seg.eight) {
                if (!(seg.four.contains(s) && seg.seven.contains(s))) {
                    seg.zero.add(s);
                }
                if (seg.four.contains(s) && !seg.seven.contains(s))
                    seg.zero.add(s);
            }
            seg.zero.addAll(seg.seven);
            // 0 complete
            seg.three.addAll(seg.seven);

            System.out.println("success?");
        }
        return 0;
    }
}

class SevenSegment {
    List<String> template = new ArrayList<>() {{
        add("a");
        add("b");
        add("c");
        add("d");
        add("e");
        add("f");
        add("g");
    }};
    String[] testSig;
    String[] digitSig;
    Set<String> zero = new HashSet<>(), one = new HashSet<>(), two = new HashSet<>(), three = new HashSet<>(),
            four = new HashSet<>(), five = new HashSet<>(), six = new HashSet<>(), seven = new HashSet<>(), eight = new HashSet<>(template),
            nine = new HashSet<>();
}