package listitem;

/** The reverse-a-linked-list worked problem. */
public final class ReverseLinkedList {

  private ReverseLinkedList() {
    // This class should not be instantiated!
  }

  // Reverses the list by building a new list; the original list is
  // unchanged. head may be null.
  public static ListItem reverseListNaive(ListItem head) {
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

  // Reverses the list in place. head may be null.
  public static ListItem reverseListInPlace(ListItem head) {
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
