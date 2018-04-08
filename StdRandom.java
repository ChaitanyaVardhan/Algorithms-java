import java.util.Random;

public final class StdRandom {
    private static Random random;

    public static int uniform(int n) {
	if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
	return random.nextInt(n);
    }

    public static void shuffle(Object[] a) {
	validateNotNull(a);
	int n = a.length;
	for (int i = 0; i < n; i++) {
	    int r = i + uniform(n-i-1);
	    Object temp = a[i];
	    a[i] = a[r];
	    a[r] = temp;
	}
    }

    private static void validateNotNull(Object x) {
	if (x == null) {
	    throw new IllegalArgumentException("argument is null");
	}
    }
}
