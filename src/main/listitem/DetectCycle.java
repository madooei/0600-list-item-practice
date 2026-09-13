package listitem;

/** The detect-a-cycle worked problem. */
public final class DetectCycle {

  private DetectCycle() {
    // This class should not be instantiated!
  }

  // Determines whether the list contains a cycle using two pointers.
  // head may be null.
  public static boolean hasCycle(ListItem head) {
    ListItem slow = head;
    ListItem fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true; // there is a cycle
      }
    }

    return false; // no cycle found
  }
}
