package listitem;

/** Runs the reverse-a-linked-list scenarios against the naive solution. */
public class ReverseLinkedListNaiveTest extends ReverseLinkedListTest {

  @Override
  protected ListItem reverse(ListItem head) {
    return ReverseLinkedList.reverseListNaive(head);
  }
}
