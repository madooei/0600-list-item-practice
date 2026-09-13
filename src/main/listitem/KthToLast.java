package listitem;

/** The kth-to-last worked problem. */
public final class KthToLast {

  private KthToLast() {
    // This class should not be instantiated!
  }

  // Returns the kth-to-last item in a single pass (k = 0 is the last item).
  // head may be null. Returns null if k is out of bounds.
  public static ListItem kthToLast(ListItem head, int k) {
    if (k < 0) {
      return null;
    }

    ListItem current = head;
    ListItem kth = head;
    int steps = 0;
    while (current != null) {
      current = current.next;
      if (steps > k) {
        kth = kth.next;
      }
      steps++;
    }
    if (steps <= k) {
      return null;  // k is out of bounds
    }
    return kth;
  }
}
