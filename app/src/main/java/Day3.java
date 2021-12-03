import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {
    public final List<Integer[]> ray = new ArrayList<>();

    public Day3(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            ray.add(Arrays.stream(scanner.next().split("")).map(Integer::parseInt).toArray(Integer[]::new));
        }
    }

    public double partOne() {
        Integer[] bits = new Integer[ray.get(0).length];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = commonBit(ray, i);
        }
        long gammaRate = binaryConversion(bits);
        long epsilonRate = binaryConversion(binaryNot(bits));
        return gammaRate * epsilonRate;
    }

    public long partTwo() {
        List<Integer[]> oxygen = ray;
        List<Integer[]> carbon = ray;

        int index = 0;
        while (oxygen.size() > 1) {
            List<Integer[]> tmp = new ArrayList<>();
            int bit = commonBit(oxygen, index);
            for (Integer[] item : oxygen) {
                if (item[index] == bit)
                    tmp.add(item);
            }
            index++;
            oxygen = tmp;
        }

        index = 0;
        while (carbon.size() > 1) {
            List<Integer[]> tmp = new ArrayList<>();
            int bit = commonBit(carbon, index);
            for (Integer[] item : carbon) {
                if (item[index] != bit)
                    tmp.add(item);
            }
            index++;
            carbon = tmp;
        }
        long oxygenGeneratorRating = binaryConversion(oxygen.get(0));
        long carbonScrubberRating = binaryConversion(carbon.get(0));
        return oxygenGeneratorRating * carbonScrubberRating;
    }

    public int getCommonBit(List<Integer[]> ray, int index) {
        return this.commonBit(ray, index);
    }

    private int commonBit(List<Integer[]> ray, int index) {
        int count = 0;
        for (Integer[] item : ray) {
            if (item[index] == 1)
                count++;
            else
                count--;
        }
        if (count >= 0)
            return 1;
        else
            return 0;
    }

    public long binaryConversion(Integer[] bits) {
        long val = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                val += (long) Math.pow(2, (bits.length - 1 - i));
            }
        }
        return val;
    }

    public Integer[] binaryNot(Integer[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1)
                bits[i] = 0;
            else
                bits[i] = 1;
        }
        return bits;
    }
}