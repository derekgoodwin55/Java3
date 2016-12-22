import java.util.ArrayList;

public class SortedList<T extends Comparable<T>> {

	private Node topNode;
	private int size;

	private class Node {
		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public SortedList() {
		topNode = null;
		size = 0;
	}

	/**
	 * Determine whether the list  is empty, by checking if the top node is null
	 * 
	 * @return true if and only if the list is empty
	 */
	public boolean isEmpty() {
		if (size == 0) {
			assert topNode == null;
			return true;
		} else {
			assert topNode != null;
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	/**
	 * Adds an item in the properly sorted location of the list, in descending
	 * order (highest to lowest, according to the compareTo() method of the
	 * item).
	 * 
	 * You will need to implement the logic for adding the item. In general,
	 * this means comparing the item you're trying to add against both the 
	 * current item in the list, and the next item in the list and ensuring 
	 * that the item is placed in the proper location.
	 * 
	 * @param item
	 *            the item you wish to add to the list. Will be added in the ordered
	 *            location
	 * @return true or false, depending on whether an element was successfully
	 *         added.
	 */
	public boolean add(T item){

		Node temp = new Node(item);
		if ( size == 0){
			topNode = new Node(item);
			size++;
			return true;
		}
		else {
			Node current;
			Node prev = null;
			current = topNode;

			while (current != null && (current.data.compareTo(item) > 0)) {
				prev = current;
				current = current.next;
			}
			if(prev != null){
				prev.next = temp;
				temp.next = current;
			} else {
				temp.next = current;
				topNode = temp;
			}
			size++;
		}
		return true;
	}


	/**
	 * Finds the item at index i, and returns the item to the caller.
	 * 
	 * You will need to implement this method. In general, this means stepping
	 * through the list and maintaining a count until you reach the proper
	 * element, then returning that item.
	 * 
	 * @param i the index of the requested item
	 * @return the data field of node i, null if i does not exist
	 */
	public T get(int i) {
		Node current = topNode;
		if ( i < 0 || i >= getSize() || getSize() == 0){
			return null;
		}
		for ( int index = 0; index < i; index++) {

			if (current == null) {
				return null;
			}
			else{
				current = current.next;
			}
		}
		return current.data;
	}

	/**
	 * Returns an ArrayList that maintains the proper order of this SortedList.
	 * 
	 * You will need to implement this method. In general, this means adding the
	 * stepping through each node in the SortedList and adding it in the proper
	 * location to the ArrayList.
	 * 
	 * @return An ArrayList representation of this SortedList. null if this list
	 *         is empty.
	 */
	public ArrayList<T> toList() {
		int index = 0;
		Node cur = topNode;
		ArrayList <T> num = new ArrayList<>();

		while ( cur != null) {
			num.add(index,cur.data);
			index++;
			cur = cur.next;
		}
		return num;
	}
}
