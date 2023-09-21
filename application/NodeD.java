package application;

public class NodeD {

	MartyrD data;
	NodeD prev;
	NodeD next;

	public NodeD() {

	}

	public NodeD(MartyrD data) {
		this.data = data;
		this.prev = null;
		this.next = null;

	}

	public MartyrD getData() {
		return data;
	}

	public void setData(MartyrD data) {
		this.data = data;
	}

	public NodeD getPrev() {
		return prev;
	}

	public void setPrev(NodeD prev) {
		this.prev = prev;
	}

	public NodeD getNext() {
		return next;
	}

	public void setNext(NodeD next) {
		this.next = next;

	}

}