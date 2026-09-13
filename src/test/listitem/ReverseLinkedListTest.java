package listitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests for the reverse-a-linked-list problem. Each test is one scenario from
 * the notes, run against whichever solution the concrete subclass wires up.
 */
public abstract class ReverseLinkedListTest {

  // Reverses the given list using the solution under test.
  protected abstract ListItem reverse(ListItem head);

  @Test
  public void emptyListReversesToNull() {
    assertNull(reverse(link()));
  }

  @Test
  public void singleNodeReversesToItself() {
    assertChainValues(reverse(link(5)), 5);
  }

  @Test
  public void twoNodesSwapOrder() {
    assertChainValues(reverse(link(3, 5)), 5, 3);
  }

  @Test
  public void threeNodesFromTheProblemStatement() {
    assertChainValues(reverse(link(7, 3, 5)), 5, 3, 7);
  }

  @Test
  public void ascendingValuesBecomeDescending() {
    assertChainValues(reverse(link(3, 5, 7)), 7, 5, 3);
  }

  @Test
  public void duplicateValuesReverseByPosition() {
    assertChainValues(reverse(link(1, 1, 2)), 2, 1, 1);
  }

  @Test
  public void longerListReverses() {
    assertChainValues(reverse(link(1, 2, 3, 4, 5)), 5, 4, 3, 2, 1);
  }

  // Builds a linked list holding the given values in order and returns its
  // head (null when no values are given).
  private static ListItem link(int... values) {
    ListItem head = null;
    for (int i = values.length - 1; i >= 0; i--) {
      ListItem item = new ListItem(values[i]);
      item.next = head;
      head = item;
    }
    return head;
  }

  // Walks the chain from head and asserts it holds exactly the expected
  // values, in order, ending in null.
  private static void assertChainValues(ListItem head, int... expected) {
    ListItem current = head;
    for (int i = 0; i < expected.length; i++) {
      if (current == null) {
        fail("chain ended after " + i + " items; expected " + expected.length);
      }
      assertEquals(expected[i], current.value, "value at position " + i);
      current = current.next;
    }
    assertNull(current, "chain has more than " + expected.length + " items");
  }
}
