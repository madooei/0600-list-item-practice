package listitem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for the detect-a-cycle problem. Each test is one scenario from the
 * notes. The cyclic lists are wired by hand: build a plain chain, then point
 * the last item's next back at an earlier item.
 */
public class DetectCycleTest {

  @Test
  public void emptyListHasNoCycle() {
    assertFalse(DetectCycle.hasCycle(link()));
  }

  @Test
  public void linearListHasNoCycle() {
    assertFalse(DetectCycle.hasCycle(link(8, 7, 5, 9)));
  }

  @Test
  public void allDuplicateValuesWithoutCycle() {
    // cycle detection is about item identity, not value
    assertFalse(DetectCycle.hasCycle(link(1, 1, 1, 1)));
  }

  @Test
  public void singleNodeWithoutSelfLoopHasNoCycle() {
    assertFalse(DetectCycle.hasCycle(link(1)));
  }

  @Test
  public void singleNodeSelfLoopIsACycle() {
    ListItem head = link(1);
    head.next = head; // the one item points back to itself
    assertTrue(DetectCycle.hasCycle(head));
  }

  @Test
  public void cycleBackToHeadIsDetected() {
    ListItem head = link(8, 7, 5, 9);
    lastItem(head).next = head; // the last item links back to the head
    assertTrue(DetectCycle.hasCycle(head));
  }

  @Test
  public void cycleBackToMiddleIsDetected() {
    ListItem head = link(8, 7, 5, 9);
    lastItem(head).next = head.next; // the last item links back to the second item
    assertTrue(DetectCycle.hasCycle(head));
  }

  @Test
  public void allDuplicateValuesWithCycle() {
    ListItem head = link(1, 1, 1, 1);
    lastItem(head).next = head;
    assertTrue(DetectCycle.hasCycle(head));
  }

  @Test
  public void twoNodeCycleIsDetected() {
    ListItem head = link(1, 1);
    lastItem(head).next = head;
    assertTrue(DetectCycle.hasCycle(head));
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

  // Returns the last item of a (cycle-free) chain.
  private static ListItem lastItem(ListItem head) {
    ListItem current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current;
  }
}
