import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {

	   public static void main(String[] args) {
		   if (args.length < 1) {
			   System.out.println("Argument missing: number of strings to read from stdin");
			   return;
		   }
		   int count = Integer.parseInt(args[0]);

		   RandomizedQueue<String> queue = new RandomizedQueue<>();
		   while (!StdIn.isEmpty()) {
			   String input = StdIn.readString();
			   queue.enqueue(input);
		   }

		   for (int i=0; i < count; i++) {
			   StdOut.println(queue.dequeue());
		   }
	   }

}
