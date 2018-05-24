public class SubstringSearch {
    public static int bruteSearch(String pat, String txt) {
	int M = pat.length();
	int N = txt.length();
	StdOut.println("M :" + M);
	StdOut.println("N :" + N);
	for (int i=0; i<=N-M; i++) {
	    int j;
	    for (j=0; j < M; j++) {
		if (txt.charAt(i+j) != pat.charAt(j))
		    break;
	    }
	    if (j == M) return i;
	}
	return N;
    }

    public static int bruteSearchAlt(String pat, String txt) {
	int i, N = txt.length();
	int j, M = pat.length();
	for (i=0, j=0; i < N && j < M; i++) {
	    StdOut.println("i :" + i + " j :" + j);
	    if (txt.charAt(i) == pat.charAt(j)) j++;
	    else {i -= j; j = 0; }
	}
	if (j == M) return i - M;
	else return N;
    }

    public static void main(String[] args) {
	String pat = args[0], txt = args[1];
	//	int begin = SubstringSearch.bruteSearch(pat, txt);
	int begin = SubstringSearch.bruteSearchAlt(pat, txt);
	StdOut.println("Found at: " + begin);
    }
}
