package listitem;

/** Runs the reverse-a-linked-list scenarios against the in-place solution. */
public class ReverseLinkedListInPlaceTest extends ReverseLinkedListTest {

  @Override
  protected ListItem reverse(ListItem head) {
    return ReverseLinkedList.reverseListInPlace(head);
  }
}
