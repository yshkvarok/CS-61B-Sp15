import java.util.Formatter;

/**
 * SortedComparableList.java
 * A list of Comparables in ascending order.
 */
public class SortedComparableList {
    /** First element of list. */
    public Comparable head;
    /** Remaining elements of list. */
    public SortedComparableList tail;

    /** A list with head HEAD0 and tail TAIL0. */
    public SortedComparableList(Comparable head0, SortedComparableList tail0) {
    	head = head0;
    	tail = tail0;
    }

    /** A list with null tail, and head = 0. */
    public SortedComparableList(){
        head = 0;
        tail = null;
    }

    /** Inserts Comparable c into its correct location in this list. */
    public void insert(Comparable c) {
    	if (head == (Comparable) 0) {
    		head = c;
    		return;
    	}
        if (c.compareTo(head) < 0) {
        	tail = new SortedComparableList(head, tail);
        	head = c;
        }
        else {
        	SortedComparableList curr = this;
        	while (curr.tail != null && c.compareTo(curr.tail.head) > 0) {
        		curr = curr.tail;
        	}
        	curr.tail = new SortedComparableList(c, curr.tail);
        }
    }

    /** Returns the i-th int in this list.
     *  The first element, which is in location 0, is the 0th element.
     *  Assume i takes on the values [0, length of list - 1]. */
    public Comparable get(int i) {
        if (i == 0) return head;
        else {
        	SortedComparableList curr = this;
        	for (int j = 0; j < i; j++) {
        		curr = curr.tail;
        	}
        	return curr.head;
        }
    }

    /** Adds every item in THAT to this list. */
    public void extend(SortedComparableList that) {
        if (head != null) {
        	that.insert(head);
        	while (that.tail != null) {
        		that = that.tail;
        		this.insert(that.head);
        	}
        }
    }

    /** Returns a list consisting of the elements of L starting from
      * position START, and going all the way to the END. The head of the
      * list L is the 0th element of the list.
      *
      * This method should NOT modify L. */
    public static SortedComparableList subTail(SortedComparableList L, int start) {
        SortedComparableList oldLst = L;
        
        for (int i = 0; i < start; i++) {
        	oldLst = oldLst.tail;
        }

        return oldLst;
    }

    /** Returns the sublist consisting of LEN items from list L,
     *  beginning with item START (where the first item is 0).
     *
     *  Does not modify the original list elements.
     *  Assume START and END are >= 0.
     */
    public static SortedComparableList sublist(SortedComparableList L, int start, int len) {
        SortedComparableList newLst = subTail(L, start);
        SortedComparableList ptr = newLst;

        for (int i = 0; i < len-1; i++) {
        	ptr = ptr.tail;
        }
        ptr.tail = null;
        return newLst;
    }

    /** Removes items from L at position len+1 and later. */
    public static void expungeTail(SortedComparableList L, int len) {
        SortedComparableList ptr = L;

        for (int i = 0; i < len; i++) ptr = ptr.tail;
        ptr.tail = null;
    }

    /**
     *  Takes this list and, wherever two or more consecutive items are
     *  equal, it removes duplicates so that only one consecutive copy
     *  remains. No two consecutive items in this list are equals at the
     *  end of this method.
     *
     *  You can assume the list is in sorted order when this method is
     *  called.
     *
     *  For example, if the input list is [ 0 0 0 0 1 1 3 3 3 4 ], the
     *  output list is [ 0 1 3 4 ].
     **/
    public void squish() {
    	SortedComparableList ptr = this;
        if (ptr.head != null) {
        	while (ptr.tail != null) {
        		if (ptr.head.compareTo(ptr.tail.head) == 0)
        			ptr.tail = ptr.tail.tail;
        		else ptr = ptr.tail;
        	}
        }
    }

    /** Duplicates each Comparable so that for every original
     *  Comparable, there will end up being two consecutive Comparables.
     *
     *  You can assume the list is in sorted order when this method is
     *  called.
     *
     *  For example, if the input list is [ 2 3 4 7 ], the
     *  output list is [ 2 2 3 3 4 4 7 7 ].
     *
     *  NOTE: Do not try to make copies of the Comparables. Set
     *  the HEAD variable equal to the HEAD variable you are trying to
     *  duplicate.
     **/
    public void twin() {
    	if (head != null) {
    		SortedComparableList ptr = this;
        	ptr.tail = new SortedComparableList(ptr.head, ptr.tail);
        	ptr = ptr.tail;

        	while (ptr.tail != null) {
        		ptr = ptr.tail;
        		if (ptr.tail != null)
        			ptr.tail = new SortedComparableList(ptr.head, ptr.tail);
        		else
        			ptr.tail = new SortedComparableList(ptr.head, null);
        		ptr = ptr.tail;
        	}
        }
    }

    /** Returns NULL if no cycle exists, else returns cycle location. */
    private int detectCycles(SortedComparableList A) {
        SortedComparableList tortoise = A;
        SortedComparableList hare = A;
        if (A == null) {
            return 0;
        }
        int cnt = 0;
        while (true) {
            cnt++;
            if (hare.tail != null) {
                hare = hare.tail.tail;
            }
            else{
                return 0;
            }
            tortoise = tortoise.tail;
            if (tortoise == null || hare == null) {
                return 0;
            }
            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    /** Returns true iff X is a SortedComparableList containing the
     *  same sequence of Comparables as THIS. Cannot handle cycles. */
    public boolean equals(Object x) {
        if (!(x instanceof SortedComparableList)) {
            return false;
        }
        SortedComparableList L = (SortedComparableList) x;
        SortedComparableList p;
        for (p = this; p != null && L != null; p = p.tail, L = L.tail) {
            if (p.head != L.head) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;
        for (SortedComparableList p = this; p != null; p = p.tail) {
            out.format("%s%d", sep, p.head);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }

    public static void main(String[] args) {
    	SortedComparableList lst = new SortedComparableList();
    	lst.insert(6);
    	lst.insert(7);
    	lst.insert(8);
    	lst.insert(9);
    	lst.insert(10);
    	System.out.println(lst.toString());
    	lst.twin();
    	System.out.println(lst.toString());
    }
}