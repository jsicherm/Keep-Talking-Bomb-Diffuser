package jordan.sicherman.diffuser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Symbols {

	private static String[] col1 = new String[] { "female", "AT", "lambda", "lightning", "monkey", "n", "backwards c" };
	private static String[] col2 = new String[] { "backwards e", "female", "backwards c", "squiggle", "star", "n",
			"?" };
	private static String[] col3 = new String[] { "copyright", "w", "squiggle", "k", "3", "lambda", "star" };
	private static String[] col4 = new String[] { "6", "paragraph", "b", "monkey", "k", "?", "smile" };
	private static String[] col5 = new String[] { "trident", "smile", "b", "c", "paragraph", "3 hook", "bold star" };
	private static String[] col6 = new String[] { "6", "backwards e", "not equal", "ae", "trident", "capital n",
			"delta" };
	private static List<String[]> columns = new ArrayList<String[]>();

	private static Map<String, List<String>> aliases = new HashMap<String, List<String>>();

	static {
		aliases.put("monkey", Arrays.asList("jellyfish"));
		aliases.put("backwards e", Arrays.asList("e", "backwards 3"));
		aliases.put("squiggle", Arrays.asList("swirl", "swirly"));
		aliases.put("k", Arrays.asList("mirrored k", "ks", "mirrored ks"));
		aliases.put("?", Arrays.asList("upside down question mark"));
		aliases.put("smile", Arrays.asList("smiley"));
		aliases.put("star", Arrays.asList("hollow star", "white star"));
		aliases.put("bold star", Arrays.asList("black star"));
		aliases.put("3", Arrays.asList("incomplete 3"));
		aliases.put("3 hook", Arrays.asList("hooked 3", "swirly 3"));
		aliases.put("not equal", Arrays.asList("unequal", "inequal", "inequality"));

		columns.addAll(Arrays.asList(col1, col2, col3, col4, col5, col6));
	}

	public Symbols() throws IOException {
		System.out.println("Please enter your symbols, comma delimited");
		String line = Main.console.readLine().toLowerCase();
		if (line == null || line.isEmpty())
			return;
		String[] data = line.split(",");

		boolean success;
		List<Integer> keys = new ArrayList<Integer>();
		Map<Integer, String> index = new HashMap<Integer, String>();
		for (String[] column : columns) {
			success = true;
			for (String s : data) {
				int ind = index(column, s);
				if (ind < 0) {
					keys.clear();
					index.clear();
					success = false;
					break;
				}

				index.put(ind, s);
				keys.add(ind);
			}
			if (success)
				break;
		}

		Collections.sort(keys);
		for (int i : keys)
			System.out.println(index.get(i));
	}

	private int index(String[] str, String s) {
		for (int i = 0; i <= str.length - 1; i++)
			if (str[i].equals(s) || aliases.containsKey(str[i]) && aliases.get(str[i]).contains(s))
				return i;
		return -1;
	}
}
