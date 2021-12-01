import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File day1Input = new File("src\\main\\resources\\day1.txt");
        Day1 run1 = new Day1(day1Input);

        System.out.println("Welcome to ruuffian's advent of code 2021!");

        System.out.println("--Day One Problems--");
        System.out.println("Part One:: " + run1.partOne());
        System.out.println("Part Two:: " + run1.partTwo());
    }
}
