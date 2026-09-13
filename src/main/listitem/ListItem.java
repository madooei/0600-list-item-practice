package listitem;

/**
 * An item in a linked list, exactly as the chapter defines it: a value and a
 * reference to the next item. The class and its fields are package-private on
 * purpose; encapsulation comes later in the course.
 */
class ListItem {
  int value; // the data stored in this item
  ListItem next; // reference to the next item in the list

  // constructor to initialize the value
  ListItem(int value) {
    this.value = value;
    this.next = null; // next is initialized to null by default
  }
}
