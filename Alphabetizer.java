package main;

import java.util.ArrayList;
import java.util.List;

/**
 * An alphabetizer represents a [uni]directional (commonly diagrammed with an arrow)
 * data channel similar to the Pipe and Circular Shift class, but handles new set of
 * shifted lines from the pipe after the circular shift occurs.
 *
 * @param Pipe<String> input string
 * @param Pipe<String> output string
 */
public class Alphabetizer {
    private final Pipe<String> input;
    private final Pipe<String> output;

    public Alphabetizer(Pipe<String> input, Pipe<String> output) {
        this.input = input;
        this.output = output;
    }

    public void process() {
        List<String> lines = new ArrayList<>();
        while (!input.isEmpty()) lines.add(input.read());
        lines.stream().sorted().forEach(output::write);
    }
}
