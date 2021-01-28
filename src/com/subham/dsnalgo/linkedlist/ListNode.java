package com.subham.dsnalgo.linkedlist;

final class ListNode<T> {
    T val;
    ListNode<T> next;
    ListNode<T> prev;

    public ListNode(T val) {
	super();
	this.val = val;
	next = prev = null;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((next == null) ? 0 : next.hashCode());
	result = prime * result + ((prev == null) ? 0 : prev.hashCode());
	result = prime * result + ((val == null) ? 0 : val.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ListNode<?> other = (ListNode<?>) obj;
	if (next == null) {
	    if (other.next != null)
		return false;
	} else if (!next.equals(other.next))
	    return false;
	if (prev == null) {
	    if (other.prev != null)
		return false;
	} else if (!prev.equals(other.prev))
	    return false;
	if (val == null) {
	    if (other.val != null)
		return false;
	} else if (!val.equals(other.val))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "[" + val + "]";
    }
}
