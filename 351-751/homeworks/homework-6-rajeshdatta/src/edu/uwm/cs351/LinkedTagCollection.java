package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

//import edu.uwm.cs351.LinkedPartSeq.Node;

public class LinkedTagCollection<E> extends AbstractCollection<E> implements TagCollection<E>// need to add parameter,
																								// extends and
																								// implements
{
	private static Consumer<String> reporter = (s) -> System.out.println("Invariant error: " + s);

	private boolean report(String error) {
		reporter.accept(error);
		return false;
	}

	int size = 0;
	int version = 0;
	Node<E> dummy;

	// TODO: Data structure
	private static class Node<U> {
		String tag;
		U data;
		Node<U> prev;
		Node<U> next;

		Node(U d, String t, Node<U> p, Node<U> n) {
			data = d;
			tag = t;
			prev = p;
			next = n;
		}
	}

	private boolean wellFormed() {
		// TODO: Complete this. Cyclic doubly-linked list with a dummy node.
		// Think: What could possibly go wrong?
		// If no problems discovered, return true

//		 The dummy is not null.
		if (dummy == null) {
			return report("dummy can't be null");
		}

//		 The dummy’s data and tag fields are both null.
		if (dummy.tag != null || dummy.data != null) {
			return report("dummy can't be null");
		}

//		 The node are linked in a cycle beginning and ending with the dummy;
		if (dummy.next == null || dummy.next.prev != dummy) {
			return report("List does not end with dummy node");
		}

		if (dummy != null) {
			Node<E> slow = dummy;
			Node<E> fast = dummy.next;
			while (fast != null) {
				if (slow == fast) {
					break;
				}
				slow = slow.next;
				fast = fast.next;
				if (fast != null)
					fast = fast.next;
			}
			if (slow != fast) {
				return report("Found cycle in list");
			}
		}

//	    The “prev” links of a node always point back to the node whose “next” field pointed
//	    to them;
		Node<E> current = dummy.next;
		while (current != dummy) {
			if (current.prev == null) {
				return report("Prev link inconsistency");
			}
			if (current.prev.next != current) {
				return report("Prev link inconsistency");
			}
			current = current.next;
		}

//	     None of the links in any of the nodes (including the dummy) are null;
		current = dummy.next;
		while (current != dummy) {
			if (current.tag == null || current.next == null || current.prev == null) {
				return report("Next or Prev link is null");
			}
			current = current.next;
		}

//	     The size correctly counts the number of non-dummy nodes in the cyclic list.
		int count = 0;
		current = dummy.next;
		while (current != dummy) {
			count++;
			current = current.next;
		}
		if (count != size) {
			return report("Size is incorrect");
		}
		int c = 0;
		Node<E> temp = dummy.prev;
		while (temp != dummy && temp != null) {
			c++;
			temp = temp.prev;
		}
		if (c != count) {
			return report("size wrong");
		}
		return true;
	}

	private LinkedTagCollection(boolean ignored) {
	} // do not change this constructor

	/**
	 * Construct an empty tagged collection.
	 */
	public LinkedTagCollection() {
		// DO NOT ASSERT invariant at beginning of constructor!
		// TODO: set up data structure

		version = 0;
		size = 0;

		dummy = new Node<E>(null, null, null, null);
		dummy.next = dummy;
		dummy.prev = dummy;

		assert wellFormed() : "invariant broken by constructor";
	}

	// TODO: All the methods!
	// Make sure to properly document each.
	// NB: "clone" may suppress warnings about "unchecked"
	// (Follow the textbook and previous homeworks on the structure for clone.)

	private class MyIterator implements Iterator<E> // TODO: implements ...
	{
		Node<E> cur, next;
		int colVersion;
		String tag;

		private boolean wellFormed() {
			// TODO: check outer and version and then
			// what could go wrong?

			if (!LinkedTagCollection.this.wellFormed()) {
				return false;
			}

			if (version != colVersion) {
				return true;
			}

			if (cur == null || next == null) {
				return report("current or next node is null");
			}

			Node<E> currentNode = dummy.next;
			boolean curFound = false;
			boolean nextFound = false;
			while (currentNode != dummy) {
				if (currentNode == cur) {
					curFound = true;
				}
				if (currentNode == next) {
					nextFound = true;
				}
				currentNode = currentNode.next;
//				if (currentNode == dummy) {
//					break;
//				}
			}

			if (!curFound) {
				return report("cur node is not in the cyclic linked list");
			}

			if (!nextFound) {
				return report("next node is not in the cyclic linked list");
			}
			Node<E> slow = dummy;
			Node<E> fast = dummy;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;

				if (slow == fast) {
					return report("Found cycle in list");
				}
			}

			if (fast == null) {
				return report("List does not end with dummy node");
			}

			return true;
		}

		MyIterator(boolean ignored) {
		} // do not change this constructor

		MyIterator(String t) {
			// TODO: initialize fields
			// (We use a helper method)
			
			tag = t;
			colVersion = version;
			next = dummy;
			moveToMatch();
			cur = next;
			
			
			assert wellFormed() : "iterator constructor didn't satisfy invariant";
		}

		private void moveToMatch() {
			// TODO Auto-generated method stub
			while (tag != null && next != dummy && !tag.equals(next.tag)) {
		        next = next.next;
		    }
			
		}
//		void moveToMatch() {
//			while(function != null && next != size && !function.equls(functions[next])) {
//				++next;
//			}
//		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		// TODO: Body of iterator class
	}

	public static class Spy<T> {
		/**
		 * A public version of the data structure's internal node class. This class is
		 * only used for testing.
		 */
		public static class Node<U> extends LinkedTagCollection.Node<U> {
			/**
			 * Create a node with null data, tag, prev, and next fields.
			 */
			public Node() {
				this(null, null, null, null);
			}

			/**
			 * Create a node with the given values
			 * 
			 * @param d data for new node, may be null
			 * @param t tag for new node,may be null
			 * @param p prev for new node, may be null
			 * @param n next for new node, may be null
			 */
			public Node(U d, String t, Node<U> p, Node<U> n) {
				super(null, null, null, null);
				this.tag = t;
				this.data = d;
				this.prev = p;
				this.next = n;
			}
		}

		/**
		 * Create a node for testing.
		 * 
		 * @param d data for new node, may be null
		 * @param t tag for new node,may be null
		 * @param p prev for new node, may be null
		 * @param n next for new node, may be null
		 * @return newly created test node
		 */
		public Node<T> newNode(T d, String t, Node<T> p, Node<T> n) {
			return new Node<T>(d, t, p, n);
		}

		/**
		 * Create a node with all null fields for testing.
		 * 
		 * @return newly created test node
		 */
		public Node<T> newNode() {
			return new Node<T>();
		}

		/**
		 * Change a node's next field
		 * 
		 * @param n1 node to change, must not be null
		 * @param n2 node to point to, may be null
		 */
		public void setNext(Node<T> n1, Node<T> n2) {
			n1.next = n2;
		}

		/**
		 * Change a node's prev field
		 * 
		 * @param n1 node to change, must not be null
		 * @param n2 node to point to, may be null
		 */
		public void setPrev(Node<T> n1, Node<T> n2) {
			n1.prev = n2;
		}

		/**
		 * Return the sink for invariant error messages
		 * 
		 * @return current reporter
		 */
		public Consumer<String> getReporter() {
			return reporter;
		}

		/**
		 * Change the sink for invariant error messages.
		 * 
		 * @param r where to send invariant error messages.
		 */
		public void setReporter(Consumer<String> r) {
			reporter = r;
		}

		/**
		 * Create a testing instance of a linked tag collection with the given data
		 * structure.
		 * 
		 * @param d the dummy node
		 * @param s the size
		 * @param v the version
		 * @return a new testing linked tag collection with this data structure.
		 */
		public <U> LinkedTagCollection<U> newInstance(Node<U> d, int s, int v) {
			LinkedTagCollection<U> result = new LinkedTagCollection<U>(false);
			result.dummy = d;
			result.size = s;
			result.version = v;
			return result;
		}

		/**
		 * Creates a testing instance of an iterator
		 * 
		 * @param outer the collection attached to the iterator
		 * @param t     the tag
		 * @param c     the current node
		 * @param n     the next node
		 * @param cv    the colVersion
		 */
		public <E> Iterator<E> newIterator(LinkedTagCollection<E> outer, String t, Node<E> c, Node<E> n, int cv) {
			LinkedTagCollection<E>.MyIterator result = outer.new MyIterator(false);
			result.tag = t;
			result.cur = c;
			result.next = n;
			result.colVersion = cv;
			return result;
		}

		/**
		 * Check the invariant on the given dynamic array robot.
		 * 
		 * @param r robot to check, must not be null
		 * @return whether the invariant is computed as true
		 */
		public boolean wellFormed(LinkedTagCollection<?> r) {
			return r.wellFormed();
		}

		/**
		 * Check the invariant on the given Iterator.
		 * 
		 * @param it iterator to check, must not be null
		 * @return whether the invariant is computed as true
		 */
		public <E> boolean wellFormed(Iterator<E> it) {
			LinkedTagCollection<E>.MyIterator myIt = (LinkedTagCollection<E>.MyIterator) it;
			return myIt.wellFormed();
		}
	}

	@Override
	public boolean add(Object element, String tag) {
		// TODO Auto-generated method stub
		E data = (E) element;
		if (tag == null || element == null) {
			throw new NullPointerException("Element or tag must not be null");
		}
		Node<E> newNode = new Node<E>(data, tag, null, null);
		
		Node<E> current = dummy.next;
//		newNode.next = dummy.next;
//		newNode.prev = dummy;
//		dummy.next.prev = newNode;
//		dummy.next = newNode;

			newNode.next = current.next;
			current.next = newNode;
			
			newNode.prev = current.prev;
			current.prev = newNode;

		
		
		
		size++;
		version++;
		return true;
	}

	@Override
	public Iterator<E> iterator(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
