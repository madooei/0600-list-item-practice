package demo;

import listitem.DetectCycle;
import listitem.ListItem;

/** A demo of DetectCycle on the cycle from the problem statement. */
public final class DetectCycleDemo {

  private DetectCycleDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Build head -> 8 -> 7 -> 5 -> 9, where 9 points back to 7.
    ListItem head = new ListItem(8);
    ListItem seven = new ListItem(7);
    ListItem five = new ListItem(5);
    ListItem nine = new ListItem(9);
    head.next = seven;
    seven.next = five;
    five.next = nine;
    nine.next = seven;
    System.out.println("list: head -> 8 -> 7 -> 5 -> 9 -> back to 7");

    // Expect true: following next from 9 leads back to 7.
    System.out.println("hasCycle: " + DetectCycle.hasCycle(head));
  }
}
