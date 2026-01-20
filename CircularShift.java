package main;

/**
 * A Circular Shift represents a [uni]directional (commonly diagrammed
 * with an arrow) data channel similar to the Pipe class, but
 * handles being removed from the input from the
 * pipe and appended to the end of the line until no additional appending
 * is required (no more words)
 *
 * @param Pipe<String> input string
 * @param Pipe<String> output string
 */
public class CircularShift {
    private final Pipe<String> input;
    private final Pipe<String> output;

    public CircularShift(Pipe<String> input, Pipe<String> output) {
        this.input = input;
        this.output = output;
    }

    public void process() {
        while (!input.isEmpty()) {
            String[] words = input.read().split(" ");

            for (int i = 0; i < words.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < words.length; j++) {
                    sb.append(words[(i + j) % words.length]).append(' ');
                }
                output.write(sb.toString().trim());
            }
        }
    }
}
