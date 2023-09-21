package application;

import application.NodeD;

public class LocationList_Martry {

	public NodeD head;
	private NodeD tail;
	private int Size;

	public LocationList_Martry(MartyrD name) {
		this.head = null;
		this.Size = 0;
	}

	public NodeD getHead() {
		return head;
	}

	public void setHead(NodeD head) {
		this.head = head;
	}

	public LocationList_Martry() {
		NodeD dummy = new NodeD(null);
		head = dummy;
	}

	public void insertAtHead(MartyrD data) {
		NodeD newNodeD = new NodeD(data);
		if (head.getNext() != null) {
			newNodeD.setNext(head.getNext());
			head.getNext().setPrev(newNodeD);
		}
		head.setNext(newNodeD);
		newNodeD.setPrev(head);
		Size++;

	}

	public void insertAtLast(MartyrD data) {
		NodeD newNodeD = new NodeD(data);
		NodeD current = head.getNext();
		while (current.getNext() != null)
			current = current.getNext();
		current.setNext(newNodeD);
		Size++;

	}

	public void insertSorted(MartyrD data) {
		NodeD newNodeD = new NodeD(data);
		NodeD current = head;

		while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0)
			current = current.getNext();

		if (current.getNext() == null) {
			newNodeD.setPrev(current);
			current.setNext(newNodeD);
		} else {
			newNodeD.setNext(current.getNext());
			newNodeD.setPrev(current);
			current.getNext().setPrev(newNodeD);
			current.setNext(newNodeD);
		}
		Size++;
	}

	public MartyrD delete(MartyrD data) {
		NodeD current = head;

		while (current.getNext() != null && current.getNext().getData().compareTo(data) <= 0)
			current = current.getNext();
		if (current != head && current.getNext().getData().compareTo(data) < 0) {
			MartyrD temp = current.getData();
			if (current.getNext() == null)
				current.getPrev().setNext(null);
			else {
				current.getNext().setPrev(current.getPrev());
				current.getPrev().setNext(current.getNext());
			}

		}
		Size--;
		return null;
	}

	public void traverase() {
		System.out.print("Head -> ");
		NodeD current = head.getNext();
		while (current != null) {
			System.out.print(current.data.toString() + "->");
			current = current.getNext();
		}
		System.out.print("null");
	}

	public void printList() {
		NodeD currentNodeD = head;
		while (currentNodeD != null) {
			System.out.print(currentNodeD.data + " ");
			currentNodeD = currentNodeD.next;
		}
		System.out.println();
	}

	public String getAllMartyr() {
		String str = "";
		NodeD currentNodeD = head;
		while (currentNodeD != null) {
			str += currentNodeD.data + "\n";
			currentNodeD = currentNodeD.next;
		}
		return str;
		
	}

	public void add(MartyrD martyr) {
		NodeD newNodeD = new NodeD(martyr);
		if (head == null) {
			head = newNodeD;
			tail = newNodeD;
		} else {
			tail.next = newNodeD;
			newNodeD.prev = tail;
			tail = newNodeD;
		}
		Size++;
	}

	public void insertSorted1(MartyrD value) {
		NodeD newNodeD = new NodeD(value);

		if (head.getData() == null) {
			System.out.println("test");
			head = newNodeD;
			tail = newNodeD;
		} else if (value.compareTo(head.getData()) < 0) {
			newNodeD.next = head;
			head.prev = newNodeD;
			head = newNodeD;
		} else if (value.compareTo(tail.getData()) >= 0) {
			tail.next = newNodeD;
			newNodeD.prev = tail;
			tail = newNodeD;
		} else {
			NodeD current = head.next;

			while (current != null && current.data.compareTo(value) < 0) {
				current = current.next;
			}

			NodeD prev = current.prev;

			prev.next = newNodeD;
			newNodeD.prev = prev;
			newNodeD.next = current;
			current.prev = newNodeD;
		}
		Size++;
	}

	public int getSize() {
		return Size;
	}

	public MartyrD get(int index) {
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
		}

		NodeD currentNodeD = head;
		for (int i = 0; i < index; i++) {
			currentNodeD = currentNodeD.next;
		}

		return currentNodeD.data;
	}

	public int getCount() {
		return Size;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= getSize()) {
			System.out.println("Invalid index");
			return;
		}

		if (index == 0) {
			if (head == null)
				return;

			head = head.next;
			if (head != null)
				head.prev = null;

			if (head == null)
				tail = null;
		} else if (index == getSize() - 1) {
			if (tail == null)
				return;

			tail = tail.prev;
			if (tail != null)
				tail.next = null;

			if (tail == null)
				head = null;
		} else {
			NodeD current;
			int currentIndex;

			if (index < getSize() / 2) {
				current = head;
				currentIndex = 0;

				while (currentIndex < index) {
					current = current.next;
					currentIndex++;
				}
			} else {
				current = tail;
				currentIndex = getSize() - 1;

				while (currentIndex > index) {
					current = current.prev;
					currentIndex--;
				}
			}
		}
		Size--;

	}

	public Object getItem(int index) {
		if (index < Size) {
			NodeD currentNodeD = head;
			for (int i = 0; i < index; i++) {
				currentNodeD = currentNodeD.next;
			}
			return currentNodeD.data;
		}
		return null;
	}

//	public void removeNode(NodeD node) {
//		if (node == null) {
//			return; // Node to remove is null, nothing to do
//		}
//
//		if (node == head) {
//			head = node.next; // Update head if the node is the head of the list
//		}
//
//		if (node == tail) {
//			tail = node.prev; // Update tail if the node is the tail of the list
//		}
//
//		if (node.prev != null) {
//			node.prev.next = node.next; // Link the previous node to the next node
//		}
//
//		if (node.next != null) {
//			node.next.prev = node.prev; // Link the next node to the previous node
//		}
//
//		// Clear the references of the removed node
//		node.prev = null;
//		node.next = null;
//	}

	public void removeAll() {
		head = null; // Set the head to null to remove all references
		tail = null; // Set the tail to null to remove all references
		Size=0;
	}

	public void removeNode(Object obj) {
		NodeD currentNode = head;

		while (currentNode != null) {
			if (currentNode.data.equals(obj)) {
				NodeD prevNode = currentNode.prev;
				NodeD nextNode = currentNode.next;

				if (prevNode != null) {
					prevNode.next = nextNode;
				} else {
					// If the node to be removed is the head
					head = nextNode;
				}

				if (nextNode != null) {
					nextNode.prev = prevNode;
				} else {
					// If the node to be removed is the tail
					tail = prevNode;
				}

				// Set references to null to remove the node
				currentNode.prev = null;
				currentNode.next = null;

				return; // Node removed, exit the method
			}

			currentNode = currentNode.next;
		}
		Size--;

	}
}
