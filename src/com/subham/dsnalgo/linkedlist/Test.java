package com.subham.dsnalgo.linkedlist;

public class Test {

    public Test() {
    }

    public static void main(String[] args) {
	SinglyLinkedListUtil singlyLinkedListUtil = new SinglyLinkedListUtil();
	ListNode<Integer> listNode = SinglyLinkedListUtil.<Integer>creator()
		.start(new ListNode<Integer>(-5))
		.push(new ListNode<Integer>(5))
		.push(new ListNode<Integer>(9))
		.push(new ListNode<Integer>(10))
		.get();
	System.out.println(singlyLinkedListUtil.prettyPrint(listNode));
    }
}