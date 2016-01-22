package jordan.sicherman.diffuser;

import java.io.IOException;

public class Sequence {

	private static String[] red = new String[] { "c", "b", "a", "ac", "b", "ac", "abc", "ab", "b" };
	private static String[] blue = new String[] { "b", "ac", "b", "a", "b", "bc", "c", "ac", "a" };
	private static String[] black = new String[] { "abc", "ac", "b", "ac", "b", "bc", "ab", "c", "c" };

	private int r = 0, blu = 0, bl = 0;

	public Sequence() throws IOException {
		while (true) {
			System.out.println("Enter the color (r,bl,blu) and it's destination (A,B,C)");
			String line = Main.console.readLine();
			if (line == null || line.isEmpty())
				return;
			String[] data = line.toLowerCase().split(" ");

			boolean cut = false;
			if ("blu".equalsIgnoreCase(data[0])) {
				for (String s : blue[blu].split(""))
					if (s.equals(data[1])) {
						cut = true;
						break;
					}
				blu++;
			} else if ("bl".equalsIgnoreCase(data[0])) {
				for (String s : black[bl].split(""))
					if (s.equals(data[1])) {
						cut = true;
						break;
					}
				bl++;
			} else if ("r".equalsIgnoreCase(data[0])) {
				for (String s : red[r].split(""))
					if (s.equals(data[1])) {
						cut = true;
						break;
					}
				r++;
			}

			System.out.println(cut ? "Cut." : "Do not cut.");
		}
	}
}
