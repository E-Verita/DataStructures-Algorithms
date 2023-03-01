package datastr;

public class MyNodeT<T> {
	private T element;
	private MyNodeT next;
	private MyNodeT previous;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		if (element != null) {
			this.element = element;
		} else {
			this.element = (T) new Object();
		}
	}

	public MyNodeT getNext() {
		return next;
	}

	// var būt null, jo var būt mezgls, aiz kura nekas neseko
	public void setNext(MyNodeT next) {
		this.next = next;
	}

	public MyNodeT getPrevious() {
		return previous;
	}

	public void setPrevious(MyNodeT previous) {
		this.previous = previous;
	}

	public MyNodeT(T element) {
		setElement(element);
	}

	public String toString() {
		return element.toString();
	}

}
