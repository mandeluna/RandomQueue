import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeques {

	@Test
	public void testAdd() {
		Deque<Integer> d = new Deque<>();
		d.addFirst(10);
		assertTrue(d.size() == 1);
		Integer ten = d.removeFirst();
		assertTrue(d.isEmpty());
		assertTrue(ten == 10);
		d.addFirst(20);
		d.addLast(30);
		d.addFirst(10);
		assertTrue(d.size() == 3);
		assertTrue(d.removeFirst() == 10);
		assertTrue(d.removeFirst() == 20);
		assertTrue(d.removeFirst() == 30);
		d.addFirst(20);
		d.addLast(30);
		d.addFirst(10);
		for (Integer i : d) {
			System.out.println(i);
		}
		assertTrue(d.removeLast() == 30);
		assertTrue(d.removeLast() == 20);
		assertTrue(d.removeLast() == 10);
	}

}
