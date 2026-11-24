package demo;

import listitem.ListItem;
import listitem.ReverseLinkedListNaive;

/** A demo of ReverseLinkedListNaive on the list from the problem statement. */
public final class ReverseLinkedListNaiveDemo {

  private ReverseLinkedListNaiveDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Build head -> 7 -> 3 -> 5 -> null.
    ListItem head = new ListItem(7);
    head.next = new ListItem(3);
    head.next.next = new ListItem(5);
    System.out.println("before: " + toText(head));

    // Expect head -> 5 -> 3 -> 7 -> null.
    head = ReverseLinkedListNaive.reverseList(head);
    System.out.println("after:  " + toText(head));
  }

  // The values from head to the end, as "head -> 7 -> 3 -> 5 -> null".
  private static String toText(ListItem head) {
    String text = "head";
    for (ListItem item = head; item != null; item = item.next) {
      text += " -> " + item.value;
    }
    return text + " -> null";
  }
}
