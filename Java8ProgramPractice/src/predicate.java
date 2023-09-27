import java.util.function.Predicate;

public class predicate {

	public static void main(String[] args) {
		/*
		 * Predicate<Integer> p = i -> (i > 10); System.out.println(p.test(100));
		 * System.out.println(p.test(7)); System.out.println(p.test(true)); //CE
		 */
		int[] x = { 0, 5, 10, 15, 20, 25, 30 };

		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i % 2 == 0;

		System.out.println("The Numbers Greater Than 10:");
		m1(p1, x);

		System.out.println("The Even Numbers Are");
		m1(p2, x);

		System.out.println("The Numbers Not Greater Than 10:");
		m1(p1.negate(), x);

		System.out.println("The Numbers Greater Than 10 And Even Are");
		m1(p1.and(p2), x);

		System.out.println("The Numbers Greater Than 10 OR Even");
		m1(p1.or(p2), x);
	}

	public static void m1(Predicate<Integer> p, int[] x) {
		for (int x1 : x) {
			if (p.test(x1))
				System.out.println(x1);
		}

	}
}
