package protsenko.hw1;

public class MyLinkedList {
	private Node first = new Node();
	private Node last = new Node();

	public void printAll() {
		Node currentElement = first.next;
		while ((currentElement) != null) {
			System.out.println(currentElement.value);
			currentElement = currentElement.next;
		}
	}

	public void add(String value) {
		var newNode = new Node();
		if (last.prev == null)
		{
			first.next = newNode;
			last.prev = newNode;
			newNode.prev = first;
			newNode.next = last;
			newNode.value = value;
		}
		else
		{
			newNode.prev = last.prev;
			last.prev.next = newNode;
			newNode.next = last;
			last.prev = newNode;
			newNode.value = value;

		}

	}

	public static class Node {
		private Node prev;
		private String value;
		private Node next;
	}
}
