import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class Day2Test {
    @Test
    public void partOneTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\DayOne\\day1.txt");
        Day1 one = new Day1(input);
        Assertions.assertEquals(one.partOne(), 7);
    }

    @Test
    public void partTwoTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\DayOne\\day1.txt");
        Day1 one = new Day1(input);
        Assertions.assertEquals(one.partTwo(), 5);
    }
}
