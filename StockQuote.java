public class StockQuote {
    public static void main(String[] args) {
	String name = "https://in.finance.yahoo.com/quote/";
	In in = new In(name + args[0] + "?p=" + args[0]);
	String text = in.readAll();
	int start = text.indexOf("currentPrice", 0);
	int from = text.indexOf("raw", start);
	int to = text.indexOf("fmt", from);
	String price = text.substring(from + 5, to - 2);
	StdOut.println(price);
    }
}
