import java.io.File;
import java.io.FileNotFoundException;

public class App{
    public static void main(String[] args) throws FileNotFoundException {
        // Inputs
        File day1Input = new File("src\\main\\resources\\day1.txt");
        File day2Input = new File("src\\main\\resources\\day2.txt");
        File day3Input = new File("src\\main\\resources\\day3.txt");

        // Init Each Day
        Day1 run1 = new Day1(day1Input);
        Day2 run2 = new Day2(day2Input);
        Day3 run3 = new Day3(day2Input);

        System.out.println("Welcome to ruuffian's advent of code 2021!");
        System.out.print('\n');

        // Print Solutions
        System.out.println("--Day One Problems--");
        System.out.println("Part One:: " + run1.partOne());
        System.out.println("Part Two:: " + run1.partTwo());

        System.out.println("--Day Two Problems--");
        System.out.println("Part One:: " + run2.partOne());
        System.out.println("Part Two:: " + run2.partTwo());

        System.out.println("--Day Three Problems--");
        System.out.println("Part One:: " + run3.partOne());
        System.out.println("Part Two:: " + run3.partTwo());
    }
}
