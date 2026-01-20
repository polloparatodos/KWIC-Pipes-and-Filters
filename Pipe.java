package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Pipe represents a [uni]directional (commonly diagrammed with an arrow) data channel
 * in a pipes-and-filters architecture.
 *
 * The pipe makes use of FIFO (First In, First Out) semantics for passing data
 * between independent filters. It contains no processing logic and does not
 * expose its internal storage, ensuring loose coupling between producers and
 * consumers.
 *
 * @param <T> the type of data transmitted through the pipe
 */

public class Pipe<T> {

  private final Queue<T> buffer = new LinkedList<>();

  /**
   * Writes data to pipe
   * 
   * @param data item of specific type to be written to the pipe
   */
  public void write(T item) {
      buffer.add(item);
  }

  /*
   * Read and dequeue (remove) subsequent item from pipe
   * 
   * @return next item or null if pipe has no next item
   */
  public T read() {
      return buffer.poll();
  }

  /*
   * Determine if pipe is empty
   * 
   * @return boolean: true if empty, false if non-empty
   */
  public boolean isEmpty() {
      return buffer.isEmpty();
  }
}
