import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {
    private final List<String> ray = new ArrayList<>();

    public Day3(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            ray.add(scanner.next());
        }
    }

    public double partOne() {
        int[] bits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        double gamma = 0;
        double epsilon = 0;
        for (String s : ray) {
            String[] split = s.split("");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("1"))
                    bits[i] += 1;
                else
                    bits[i] -= 1;
            }
        }
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0)
                bits[i] = 1;
            else
                bits[i] = 0;
        }
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                gamma += Math.pow(2, (bits.length - 1 - i));
            } else {
                epsilon += Math.pow(2, (bits.length - 1 - i));
            }
        }
        return gamma * epsilon;
    }

    public int partTwo() {
        int oxygen = oxygen();
        int carbon = carbon();
        return oxygen * carbon;
    }

    public int oxygen() {
        int value = 0;
        List<String> oxygen = ray;
        int index = 0;
        while (oxygen.size() > 1) {
            List<String> tmp = new ArrayList<>();
            int bit = 0;
            char choice = ' ';
            for (String s : oxygen) {
                if (s.charAt(index) == '1') {
                    bit++;
                } else {
                    bit--;
                }
            }
            if (bit >= 0)
                choice = '1';
            else
                choice = '0';
            for (int i = 0; i < oxygen.size(); i++) {
                if (oxygen.get(i).charAt(index) == choice) {
                    tmp.add(oxygen.get(i));
                }
            }
            index++;
            oxygen = tmp;
        }
        String[] array = oxygen.get(0).split("");
        for (int i = 0; i < array.length; i++) {
            if (Integer.parseInt(array[i]) == 1) {
                value += Math.pow(2, (array.length - 1 - i));
            }
        }
        return value;
    }

    public int carbon() {
        int value = 0;
        List<String> oxygen = ray;
        int index = 0;
        while (oxygen.size() > 1) {
            List<String> tmp = new ArrayList<>();
            int bit = 0;
            char choice = ' ';
            for (String s : oxygen) {
                if (s.charAt(index) == '1') {
                    bit++;
                } else {
                    bit--;
                }
            }
            if (bit >= 0)
                choice = '1';
            else
                choice = '0';
            for (int i = 0; i < oxygen.size(); i++) {
                if (oxygen.get(i).charAt(index) != choice) {
                    tmp.add(oxygen.get(i));
                }
            }
            index++;
            oxygen = tmp;
        }
        String[] array = oxygen.get(0).split("");
        for (int i = 0; i < array.length; i++) {
            if (Integer.parseInt(array[i]) == 1) {
                value += Math.pow(2, (array.length - 1 - i));
            }
        }
        return value;
    }
}