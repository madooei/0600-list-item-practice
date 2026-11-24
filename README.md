# List Item — Practice: Reverse a Linked List, Detect a Cycle, and Kth to Last

The chapter's three worked problems: reverse a linked list, detect a cycle, and find the kth-to-last element, each with a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it). The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      listitem/
        ListItem.java                  # the chapter's node class, vendored here
        ReverseLinkedListNaive.java    # build a new list by prepending each value
        ReverseLinkedListInPlace.java  # re-point each link in place
        DetectCycle.java               # Floyd's slow/fast two-pointer solution
        KthToLast.java                 # two-pointer gap solution
      demo/                            # one demo per solution class
        ReverseLinkedListNaiveDemo.java
        ReverseLinkedListInPlaceDemo.java
        DetectCycleDemo.java
        KthToLastDemo.java
    test/
      listitem/
        ReverseLinkedListTest.java          # abstract: shared scenarios
        ReverseLinkedListNaiveTest.java     # runs them against ReverseLinkedListNaive
        ReverseLinkedListInPlaceTest.java   # runs them against ReverseLinkedListInPlace
        DetectCycleTest.java
        KthToLastTest.java
  scripts/
    test.sh                       # compile everything and run the JUnit tests
    run.sh                        # compile everything and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh listitem.ReverseLinkedListNaiveTest` — compiles everything and runs one test class only. Use this while you are working on one solution and the others are still empty. The class names are listed in the layout above.
- `scripts/run.sh demo.DetectCycleDemo` — compiles everything and runs that one demo. Every solution class has its own demo, `<Class>Demo`.

## What's here

- `listitem.ReverseLinkedListNaive` — `reverseList`, which builds a new list by prepending each value: O(n) time, O(n) extra space.
- `listitem.ReverseLinkedListInPlace` — `reverseList`, which re-points each link with three references: O(n) time, O(1) auxiliary space.
- `listitem.DetectCycle` — `hasCycle`, Floyd's slow/fast two-pointer technique: O(n) time, O(1) auxiliary space.
- `listitem.KthToLast` — `kthToLast`, a two-pointer gap held k steps apart so the list is traversed once: O(n) time, O(1) auxiliary space.
- `listitem.ListItem` — the chapter's node class (a `value` and a `next` reference). Vendored here unchanged, under the same package, so this problem's code has no dependency on the lecture-notes sibling's own code and compiles and runs on its own.
- `demo.ReverseLinkedListNaiveDemo`, `demo.ReverseLinkedListInPlaceDemo`, `demo.DetectCycleDemo`, and `demo.KthToLastDemo` — one demo per solution class, each on the list from its problem statement.
