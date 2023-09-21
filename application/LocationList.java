package application;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import application.Node;

public class LocationList {

	// private String name;
	private MartyrL data;
	private Node head;
	private Node tail;
	private int Size;

	public LocationList(MartyrL name) {
		this.head = null;
		this.Size = 0;
	}

	public MartyrL getName() {
		return getName();
	}

	public void setName(MartyrL name) {
		this.data = name;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LocationList() {
		Node dummy = new Node(null);
		head = dummy;
	}

	public int getSize() {
		return Size;
	}

	public void insertAtHead(MartyrL data) {
		Node newNode = new Node(data);
		if (head.getNext() != null) {
			newNode.setNext(head.getNext());
			head.getNext().setPrev(newNode);
		}
		head.setNext(newNode);
		newNode.setPrev(head);

	}

	public void insertAtLast(MartyrL data) {
		Node newNode = new Node(data);
		Node current = head.getNext();
		while (current.getNext() != null)
			current = current.getNext();
		current.setNext(newNode);
	}

	public void insertSorted(MartyrL data) {
		Node newNode = new Node(data);
		Node current = head;

		while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0)
			current = current.getNext();

		if (current.getNext() == null) {
			newNode.setPrev(current);
			current.setNext(newNode);
		} else {
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			current.getNext().setPrev(newNode);
			current.setNext(newNode);
		}
	}

	public MartyrL delete(MartyrL data) {
		Node current = head;

		while (current.getNext() != null && current.getNext().getData().compareTo(data) <= 0)
			current = current.getNext();
		if (current != head && current.getNext().getData().compareTo(data) < 0) {
			MartyrL temp = current.getData();
			if (current.getNext() == null)
				current.getPrev().setNext(null);
			else {
				current.getNext().setPrev(current.getPrev());
				current.getPrev().setNext(current.getNext());
			}

		}
		return null;
	}

	public void traverase() {
		System.out.print("Head -> ");
		Node current = head.getNext();
		while (current != null) {
			System.out.print(current.data.toString() + "->");// " "current.getAge() +" "+current.getLocation()+"
			// "+current.getD
			current = current.getNext();
		}
		System.out.print("null");
	}

	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	public String getDataAsString() {
		Node currentNode = head;
		String FullData = " ";
		try {
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.next;
				FullData += currentNode.data + " ";
			}
			FullData += "/n";
		} catch (NullPointerException ex) {
			FullData = "";
		}
		return FullData;
		// System.out.println();
	}

	public void add(MartyrL martyr) {
		Node newNode = new Node(martyr);
		if (head == null) {
			// List is empty
			head = newNode;
			tail = newNode;
		} else {
			// Add new node to the end of the list
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		Size++;
	}

	public void insertSorted1(MartyrL value) {
		Node newNode = new Node(value);

		if (head.getData() == null) {
			System.out.println("test");
			head = newNode;
			tail = newNode;
		} else if (value.compareTo(head.getData()) < 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else if (value.compareTo(tail.getData()) >= 0) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else {
			Node current = head.next;

			while (current != null && current.data.compareTo(value) < 0) {
				current = current.next;
			}

			Node prev = current.prev;

			prev.next = newNode;
			newNode.prev = prev;
			newNode.next = current;
			current.prev = newNode;
		}
		Size++;
	}

//	public MartyrL get(int index) {
//		if (index < 0 || index >= getSize()) {
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
//		}
//
//		Node currentNode = head;
//		for (int i = 0; i < index; i++) {
//			currentNode = currentNode.next;
//		}
//
//		return currentNode.data;
//	}
//
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return Size;
//	}

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
			Node current;
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

	public Node search(String location) {
		Node temp = head;
		while (temp != null) {
			if (temp.data != null && temp.data.getLocation().equalsIgnoreCase(location)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;

	}

	public MartyrD searchByName(String name) {
		Node temp = head;
		while (temp != null) {
			NodeD temp2 = temp.data.list_Martry.head;
			while (temp2 != null) {
				if (temp2.data.getName().equalsIgnoreCase(name)) {
					return temp2.data;
				}
				temp2 = temp2.next;
			}
			temp = temp.next;

		}
		return null;

	}

	public MartyrD searchByage(String name) {
		Node temp = head;
		while (temp != null) {
			NodeD temp2 = temp.data.list_Martry.head;
			while (temp2 != null) {
				if (temp2.data.getAge().equalsIgnoreCase(name)) {
					return temp2.data;
				}
				temp2 = temp2.next;

			}
			temp = temp.next;

		}
		return null;

	}

	public void displayList() {
		Node current = getHead();
		while (current != null) {
			// data.
			current = current.getNext();
			printList();
		}
	}

	public String getItem(int index) {
		if (index < Size) {
			Node currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			return currentNode.data + " ";
		}
		return null;
	}

	public void removeNode(Node node) {
		if (node == null) {
			return; 
		}

		if (node == head) {
			head = node.next; 
		}

		if (node == tail) {
			tail = node.prev; 
		}

		if (node.prev != null) {
			node.prev.next = node.next; 
		}

		if (node.next != null) {
			node.next.prev = node.prev; 		}

		node.prev = null;
		node.next = null;
		Size--;
	}

	public void removeAll() {
		head = null;
		tail = null;
		Size = 0;
	}

	public void insertNode(MartyrL martyr) {
		Node newNode = new Node(martyr);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		Size++;
	}

	public void writeToFile(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			Node currentNode = head;

			while (currentNode != null) {
				String data = currentNode.data.toString();
				writer.println(data);
				// writer.println(data.);

				currentNode = currentNode.next;
			}

			System.out.println("Data written to file successfully.");
		} catch (Exception e) {
			System.out.println("An error occurred while writing the data to the file: " + e.getMessage());
		}
	}

	public void removeNode(Object obj) {
		Node currentNode = head;

		while (currentNode != null) {
			if (currentNode.data.equals(obj)) {
				Node prevNode = currentNode.prev;
				Node nextNode = currentNode.next;

				if (prevNode != null) {
					prevNode.next = nextNode;
				} else {
					head = nextNode;
				}

				if (nextNode != null) {
					nextNode.prev = prevNode;
				} else {
					tail = prevNode;
				}

				currentNode.prev = null;
				currentNode.next = null;

				return; 
			}

			currentNode = currentNode.next;
			Size--;
		}


	}

	public String get(int indexe) {
		if (indexe < 0 || indexe >= Size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		Node current = head;
		for (int i = 0; i < indexe; i++) {
			current = current.getNext();
		}
		return current.getData().getLocation();
	}


}
