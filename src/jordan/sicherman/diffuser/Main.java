package jordan.sicherman.diffuser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<Integer, String> index = new HashMap<Integer, String>();
	public static BombInfo analytics = new BombInfo();

	public static class BombInfo {
		private final Map<String, String> tag = new HashMap<String, String>();

		private static Map<String, String> index = new HashMap<String, String>();

		static {
			index.put("SERIAL", "What is the serial number?");
			index.put("BATTERY", "How many batteries are there?");
			index.put("CAR", "Is there a lit CAR label? (y/n)");
			index.put("FRK", "Is there a lit FRK label? (y/n)");
			index.put("PARALLEL", "Is there a parallel port? (y/n)");
		}

		public String fetch(String key) throws IOException {
			if (tag.containsKey(key))
				return tag.get(key);

			System.out.println(index.get(key));
			tag.put(key, console.readLine());
			return tag.get(key);
		}
	}

	static {
		index.put(0, "Wires");
		index.put(1, "Button");
		index.put(2, "Symbols");
		index.put(3, "Simon");
		index.put(4, "Who's on First");
		index.put(5, "Memory");
		index.put(6, "Morse");
		index.put(7, "Complex Wires");
		index.put(8, "Wire Sequences");
		index.put(9, "Maze");
		index.put(10, "Password");
		index.put(11, "Knobs");
	}

	public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("Please enter a number to continue.\n\n" + help());
			try {
				int ind = Integer.parseInt(console.readLine());
				System.out.println(lookup(ind) + "\n");
				switch (ind) {
				case 0:
					new Wires();
					break;
				case 1:
					new Button();
					break;
				case 2:
					new Symbols();
					break;
				case 3:
					break;
				case 4:
					new WhosOnFirst();
					break;
				case 5:
					new Memory();
					break;
				case 6:
					new Morse();
					break;
				case 7:
					new Complex();
					break;
				case 8:
					new Sequence();
					break;
				case 9:
					break;
				case 10:
					new Password();
					break;
				case 11:
					new Knobs();
					break;
				}
			} catch (Exception exc) {
				System.exit(0);
				break;
			}

			System.out.println("\nPress enter to continue diffusing.");
			console.readLine();
		}
	}

	private static String help() {
		StringBuilder sb = new StringBuilder();
		for (int i : index.keySet()) {
			sb.append(i);
			sb.append(": ");
			sb.append(index.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	private static String lookup(int ind) {
		return index.get(ind);
	}
}
