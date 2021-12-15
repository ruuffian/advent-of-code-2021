import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
REFACTOR WITH ENUMS!!!
 */
public class Day10 {
    private final List<char[]> lines = new ArrayList<>();

    public Day10(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split("");
            char[] chars = new char[line.length];
            for (int i = 0; i < line.length; i++) {
                chars[i] = line[i].charAt(0);
            }
            lines.add(chars);
        }
    }

    public int partOne() {
        Close close = new Close();
        Open open = new Open();
        List<Character> corrupted = new ArrayList<>();
        for (char[] line : lines) {
            Stack<Character> brackets = new Stack<>();
            for (char c : line) {
                if (close.isPresent(c)) {
                    char lastToken = brackets.pop();
                    if (c != ')' && c - 2 != lastToken) {
                        corrupted.add(c);
                    } else if (c == ')' && c - 1 != lastToken) {
                        corrupted.add(c);
                    }
                } else if (open.isPresent(c)) {
                    brackets.push(c);
                }
            }
        }
        int syntaxScore = 0;
        for (char corrupt : corrupted) {
            if (corrupt == ')')
                syntaxScore += 3;
            if (corrupt == ']')
                syntaxScore += 57;
            if (corrupt == '}')
                syntaxScore += 1197;
            if (corrupt == '>')
                syntaxScore += 25137;
        }
        return syntaxScore;
    }

    public long partTwo() {
        Close close = new Close();
        Open open = new Open();
        List<char[]> incomplete = new ArrayList<>();

        for (char[] line : lines) {
            boolean corrupted = false;
            Stack<Character> brackets = new Stack<>();
            for (char c : line) {
                if (close.isPresent(c)) {
                    char lastToken = brackets.pop();
                    if (c != ')' && c - 2 != lastToken) {
                        corrupted = true;
                    } else if (c == ')' && c - 1 != lastToken) {
                        corrupted = true;
                    }
                } else if (open.isPresent(c)) {
                    brackets.push(c);
                }
            }
            if (!corrupted)
                incomplete.add(line);
        }
        List<Long> scores = new ArrayList<>();
        for (char[] line : incomplete) {
            Stack<Character> brackets = new Stack<>();
            for (char c : line) {
                if (close.isPresent(c)) {
                    brackets.pop();
                } else if (open.isPresent(c)) {
                    brackets.push(c);
                }
            }
            if (!brackets.isEmpty()) {
                List<Character> completion = new ArrayList<>();
                while (!brackets.isEmpty()) {
                    completion.add(brackets.pop());
                }
//                Collections.reverse(completion);
                long score = 0;
                for (char c : completion) {
                    score *= 5;
                    if (c == '(') score += 1;
                    if (c == '[') score += 2;
                    if (c == '{') score += 3;
                    if (c == '<') score += 4;
                }
                scores.add(score);
            }
        }
        Collections.sort(scores);
        return scores.get((int) Math.ceil(scores.size() - 1) / 2);
    }
}

class Open {
    char[] chars = new char[]{'{', '[', '(', '<'};

    public boolean isPresent(char a) {
        for (char b : chars) {
            if (a == b) return true;
        }
        return false;
    }
}

class Close {
    char[] chars = new char[]{'}', ']', ')', '>'};

    public boolean isPresent(char a) {
        for (char b : chars) {
            if (a == b) return true;
        }
        return false;
    }
}