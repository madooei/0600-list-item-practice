package listitem;

/** Practice problem: reverse a linked list by building a new list. */
public final class ReverseLinkedListNaive {

  private ReverseLinkedListNaive() {
    // This class should not be instantiated!
  }

  // Reverses the list by building a new list; the original list is
  // unchanged. head may be null.
  public static ListItem reverseList(ListItem head) {
    ListItem reversedHead = null;
    ListItem current = head;
    while (current != null) {
      reversedHead = addFirst(reversedHead, current.value);
      current = current.next;
    }
    return reversedHead;
  }

  // Prepends a new item holding the given value and returns the new head.
  private static ListItem addFirst(ListItem head, int value) {
    ListItem newItem = new ListItem(value);
    newItem.next = head;
    return newItem;
  }
}
