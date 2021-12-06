import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        // Inputs
        File day1Input = new File("src\\main\\resources\\day1.txt");
        File day2Input = new File("src\\main\\resources\\day2.txt");
        File day3Input = new File("src\\main\\resources\\day3.txt");
        File day4Input = new File("src\\main\\resources\\day4.txt");
        File day5Input = new File("src\\main\\resources\\day5.txt");
        File day6Input = new File("src\\main\\resources\\day6.txt");


        // Init Each Day
        Day1 run1 = null;
        Day2 run2 = null;
        Day3 run3 = null;
        Day4 run4 = null;
        Day5 run5 = null;
        Day6 run6 = null;


        try {
            run1 = new Day1(day1Input);
            run2 = new Day2(day2Input);
            run3 = new Day3(day3Input);
            run4 = new Day4(day4Input);
            run5 = new Day5(day5Input);
            run6 = new Day6(day6Input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please try again");
            System.out.println(e);
            System.exit(-1);
        }

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

        System.out.println("--Day Four Problems--");
        System.out.println("Part One:: " + run4.partOne());
        System.out.println("Part Two:: " + run4.partTwo());

        System.out.println("--Day Five Problems--");
        System.out.println("Part One:: " + run5.partOne());
        System.out.println("Part Two:: " + run5.partTwo());

        System.out.println("--Day Six Problems--");
        System.out.println("Part One:: " + run6.partOne());
        System.out.println("Part Two:: " + run6.partTwo());
    }
}
