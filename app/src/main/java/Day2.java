import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    private final List<Instruction> ray = new ArrayList<>();

    public Day2(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            Instruction command = new Instruction();
            command.direction = scanner.next();
            command.magnitude = scanner.nextInt();
            ray.add(command);
        }
    }

    public int partOne() {
        int depth = 0, position = 0;
        for (Instruction command : ray) {
            if (command.direction.equals("forward")) {
                position += command.magnitude;
            } else if (command.direction.equals("down")) {
                depth += command.magnitude;
            } else {
                depth -= command.magnitude;
            }
        }
        return depth * position;
    }

    public int partTwo() {
        int aim = 0, depth = 0, position = 0;
        for (Instruction command : ray) {
            if (command.direction.equals("down")) {
                aim += command.magnitude;
            } else if (command.direction.equals("up")) {
                aim -= command.magnitude;
            } else {
                position += command.magnitude;
                depth += aim * command.magnitude;
            }
        }
        return depth * position;
    }
}

class Instruction {
    String direction;
    int magnitude;
}