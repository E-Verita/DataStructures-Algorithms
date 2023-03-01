package datastr;

public class myLinkedListT<T> {
	private MyNodeT first = null;
	private MyNodeT last = null;
	private int elementCount = 0;

	public boolean isEmpty() {
		return (elementCount == 0);
	}

	public boolean isFull() {
		try {
			MyNodeT<String> temp = new MyNodeT<String>("testing");
			return false;
		} catch (OutOfMemoryError e) {
			return true;
		}
	}

	public int howManyElements() {
		return elementCount;
	}

	public void append(T inputElement) {
		if (!isFull()) {
			MyNodeT<T> newNode = new MyNodeT<>(inputElement);
			if (isEmpty()) {
				first = newNode;
			} else {
				// ? Vai vajadzīgs, vai nevar ar this.last
				MyNodeT<T> lastNode = last;
				lastNode.setNext(newNode);
				newNode.setPrevious(lastNode);
			}
			last = newNode;
			elementCount++;
		}
	}

}
