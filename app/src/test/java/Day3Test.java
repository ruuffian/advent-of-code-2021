import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class Day3Test {
    @Test
    public void commonBitTest1() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\Day3\\commonBit1.txt");
        Day3 obj = new Day3(input);
        Assertions.assertEquals(1, obj.getCommonBit(obj.ray, 0));
        Assertions.assertEquals(0, obj.getCommonBit(obj.ray, 1));
        Assertions.assertEquals(0, obj.getCommonBit(obj.ray, 2));
        Assertions.assertEquals(1, obj.getCommonBit(obj.ray, 3));
    }

    @Test
    public void partOneTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\Day3\\example.txt");
        Day3 one = new Day3(input);
        Assertions.assertEquals(198, one.partOne());
    }

    @Test
    public void partTwoTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\Day3\\example.txt");
        Day3 two = new Day3(input);
        Assertions.assertEquals(230, two.partTwo());
    }
}
