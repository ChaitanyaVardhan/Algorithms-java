public class QuickSort {
    public static void sort(Comparable[] a) {
	StdRandom.shuffle(a);
	sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
	if (hi <= lo) return;
	int j = partition(a, lo, hi);
	sort(a, lo, j-1);
	sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
	int i = lo, j = hi + 1;
	while(true) {
	    while (less(a[++i], a[lo]))
		if (i == hi) break;
	    while (less(a[lo], a[--j]))
		if (j == lo) break;
	    
	    if (i >= j) break;
	    
	    exch(a, i, j);
	}

	exch(a, lo, j);
	return j;
    }

    private static boolean less(Comparable u, Comparable v) {
	if ( u == v) return false;
	return u.compareTo(v) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
	Object swap = a[i];
	a[i] = a[j];
	a[j] = swap;
    }

    private static void show(Comparable[] a) {
	for (int i = 0; i < a.length; i++) {
	    StdOut.println(a[i]);
	}
    }

    private static boolean isSorted(Comparable[] a) {
	return isSorted(a, 0, a.length - 1);
    }

    private  static boolean isSorted(Comparable[] a, int lo, int hi) {
	for (int i =0; i <= hi; i++) {
	    if (less(a[i], a[i-1])) return false;
	}
	return true;
    }

    public static void main(String[] args) {
	String[] a = StdIn.readAllStrings();
	QuickSort.sort(a);
	show(a);
	assert isSorted(a);

	StdRandom.shuffle(a);

	StdOut.println();
	show(a);
    }
}
