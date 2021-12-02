import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class Day2Test {
    @Test
    public void partOneTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\DayTwo\\day2.txt");
        Day2 two = new Day2(input);
        Assertions.assertEquals(two.partOne(), 150);
    }

    @Test
    public void partTwoTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\DayTwo\\day2.txt");
        Day2 two = new Day2(input);
        Assertions.assertEquals(two.partTwo(), 900);
    }
}
