package com.subham.dsnalgo.linkedlist;


/**
 * 
 * @author <b>Subham Santra</b>
 * 
 * <b>How to create singly-linked-list ?</b>
 * 
 * ListNode<Intger> head = SinglyLinkedListUtil.<Integer>creator()
 * 				.start(new ListNode<Integer>(1))
 * 				.push(new ListNode<Integer>(5))
 * 				.push(new ListNode<Integer>(10))
 * 				.get();
 * 
 */

public class SinglyLinkedListUtil {
    static class Builder<T> {
	private ListNode<T> head;
	private ListNode<T> current;

	public Builder() {
	    head = current = null;
	}

	public Builder<T> start(ListNode<T> node) {
	    current = head = node;
	    return this;
	}

	public Builder<T> push(ListNode<T> node) {
	    current.next = node;
	    current = current.next;
	    return this;
	}

	public ListNode<T> get() {
	    return head;
	}
    }

    public static <T> Builder<T> creator() {
	return new Builder<T>();
    }

    public <T> ListNode<T> create(ListNode<T> node) {
	return node;
    }

    public <T> void push(ListNode<T> head, ListNode<T> node) {
	ListNode<T> pointer = head;
	while (pointer.next != null) {
	    pointer = pointer.next;
	}
	pointer.next = node;
    }

    public <T> String prettyPrint(ListNode<T> head) {
	StringBuilder builder = new StringBuilder();
	ListNode<T> node = head;
	builder.append("[");
	while (node != null) {
	    builder.append(node);
	    node = node.next;
	    if (node != null) {
		builder.append(",");
	    }
	}
	builder.append("]");
	return builder.toString();
    }
}