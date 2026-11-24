package demo;

import listitem.KthToLast;
import listitem.ListItem;

/** A demo of KthToLast on the list from the problem statement. */
public final class KthToLastDemo {

  private KthToLastDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Build head -> 8 -> 7 -> 5 -> 9 -> null.
    ListItem head = new ListItem(8);
    head.next = new ListItem(7);
    head.next.next = new ListItem(5);
    head.next.next.next = new ListItem(9);
    System.out.println("list: head -> 8 -> 7 -> 5 -> 9 -> null");

    // k = 1 is the second to last item. Expect 5.
    ListItem item = KthToLast.kthToLast(head, 1);
    System.out.println("kthToLast(head, 1): " + item.value);
  }
}
