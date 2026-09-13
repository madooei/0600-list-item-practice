package listitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests for the kth-to-last problem. Each test is one scenario from the
 * notes. The method returns an item inside the original list, so a test
 * checks the chain that starts at the returned item: the kth-to-last item
 * followed by everything after it.
 */
public class KthToLastTest {

  @Test
  public void lastElementWithKZero() {
    assertChainValues(KthToLast.kthToLast(link(8, 7, 5, 9), 0), 9);
  }

  @Test
  public void secondToLastWithKOne() {
    assertChainValues(KthToLast.kthToLast(link(8, 7, 5, 9), 1), 5, 9);
  }

  @Test
  public void thirdToLastWithKTwo() {
    assertChainValues(KthToLast.kthToLast(link(8, 7, 5, 9), 2), 7, 5, 9);
  }

  @Test
  public void headWithKEqualToLengthMinusOne() {
    assertChainValues(KthToLast.kthToLast(link(8, 7, 5, 9), 3), 8, 7, 5, 9);
  }

  @Test
  public void kEqualToLengthIsOutOfBounds() {
    assertNull(KthToLast.kthToLast(link(8, 7, 5, 9), 4));
  }

  @Test
  public void negativeKIsOutOfBounds() {
    assertNull(KthToLast.kthToLast(link(8, 7, 5, 9), -1));
  }

  @Test
  public void emptyListHasNoKthToLast() {
    assertNull(KthToLast.kthToLast(link(), 0));
  }

  @Test
  public void singleNodeWithKZero() {
    assertChainValues(KthToLast.kthToLast(link(5), 0), 5);
  }

  @Test
  public void singleNodeWithKOneIsOutOfBounds() {
    assertNull(KthToLast.kthToLast(link(5), 1));
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
