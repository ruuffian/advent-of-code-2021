import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class Day1Test {
    @Test
    public void partOneTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\Day1\\example.txt");
        Day1 one = new Day1(input);
        Assertions.assertEquals(7, one.partOne());
    }

    @Test
    public void partTwoTest() throws FileNotFoundException {
        File input = new File("src\\test\\resources\\Day1\\example.txt");
        Day1 two = new Day1(input);
        Assertions.assertEquals(5, two.partTwo());
    }
}
