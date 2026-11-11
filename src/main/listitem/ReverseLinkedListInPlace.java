package listitem;

/** Practice problem: reverse a linked list in place by re-pointing each link. */
public final class ReverseLinkedListInPlace {

  private ReverseLinkedListInPlace() {
    // This class should not be instantiated!
  }

  // Reverses the list in place. head may be null.
  public static ListItem reverseList(ListItem head) {
    ListItem prev = null;
    ListItem current = head;
    ListItem next = null;

    while (current != null) {
      next = current.next; // save the next node
      current.next = prev; // reverse the link
      prev = current; // move prev forward
      current = next; // move current forward
    }

    return prev; // at the end, prev will be the new head of the reversed list
  }
}
