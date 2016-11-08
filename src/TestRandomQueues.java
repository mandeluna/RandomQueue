import static org.junit.Assert.*;

import org.junit.Test;


public class TestRandomQueues {

	@Test
	public void testAdding() {
		RandomizedQueue<String> q = new RandomizedQueue<>();
		q.enqueue("AA");
		q.enqueue("BB");
		q.enqueue("CC");
		assertTrue(q.size() == 3);
		for (String stringValue : q) {
			System.out.println(stringValue);
		}
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		assertTrue(q.isEmpty());
	}

}
