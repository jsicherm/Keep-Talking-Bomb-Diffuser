package jordan.sicherman.diffuser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Morse {

	private static String[] dictionary = new String[] { ".,", ",...", ",.,.", ",..", ".", "..,.", ",,.", "....", "..",
			".,,,", ",.,", ".,..", ",,", ",.", ",,,", ".,,.", ",,.,", ".,.", "...", ",", "..,", "...,", ".,,", ",..,",
			",.,,", ",,.." };
	private static String[] letters = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	private static Map<String, Double> frequencies = new HashMap<String, Double>();

	static {
		frequencies.put("shell", 3.505);
		frequencies.put("halls", 3.515);
		frequencies.put("slick", 3.522);
		frequencies.put("trick", 3.532);
		frequencies.put("boxes", 3.535);
		frequencies.put("leaks", 3.542);
		frequencies.put("strobe", 3.545);
		frequencies.put("bistro", 3.552);
		frequencies.put("flick", 3.555);
		frequencies.put("bombs", 3.565);
		frequencies.put("break", 3.572);
		frequencies.put("brick", 3.575);
		frequencies.put("steak", 3.582);
		frequencies.put("sting", 3.592);
		frequencies.put("vector", 3.595);
		frequencies.put("beats", 3.600);
	}

	public Morse() throws IOException {
		String growing = "";
		while (true) {
			System.out.println("Enter the sequence using dots (.) and dashes (,)");
			String data = Main.console.readLine();

			if (data == null || data.isEmpty()) {
				return;
			}

			for (int i = 0; i < 26; i++)
				if (data.equals(dictionary[i])) {
					growing += letters[i];
					break;
				}

			String word = null;
			boolean found = false, match = false, didMatch = false;
			String[] growingLetters = growing.split("");
			for (String s : frequencies.keySet()) {
				String[] wordLetters = s.split("");
				int start = 0;
				for (int i = 0; i < wordLetters.length; i++)
					if (wordLetters[i].equals(growingLetters[0])) {
						start = i;
						break;
					}

				match = true;
				for (int i = start; i < growingLetters.length + start; i++)
					if (!wordLetters[i < wordLetters.length ? i : i - wordLetters.length]
							.equals(growingLetters[i - start])) {
						match = false;
						break;
					}

				if (match)
					if (word == null) {
						found = true;
						didMatch = true;
						word = s;
					} else if (!word.equals(s)) {
						found = false;
						break;
					}
			}
			
			if (!didMatch) {
				System.out.println("No match could be found. Restarting.");
				new Morse();
				return;
			}
			
			if (found) {
				System.out.println(
						"Tune to " + frequencies.get(word) + (frequencies.get(word) == 3.6 ? "00" : "") + " MHz");
				return;
			}
		}
	}
}
