public class KMP {
    private final int R;
    private int[][] dfa;
    private String pat;
    private int m;

    public KMP(String pat) {
	this.R  = 10;
	this.pat = pat;

	int m = pat.length();
	this.m = m;
	dfa = new int[R][m];
	dfa[pat.charAt(0)][0] = 1;
	for (int x = 0, j = 1; j < m; j++) {
	    for (int c = 0; c < R; c++)
		dfa[c][j] = dfa[c][x];
	}
    }

    public int search(String txt) {
	return 0;
    }

    public static void main(String[] args) {
	String pat = args[0];
	StdOut.println(pat.charAt(0));

	KMP kmp1 = new KMP(pat);

	for (int i = 0; i < kmp1.R; i++){
	    for (int j = 0; j < kmp1.m; j++)
		StdOut.print(kmp1.dfa[i][j]);
	    StdOut.print('\n');
	}
    }
}
