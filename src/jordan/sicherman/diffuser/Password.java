package jordan.sicherman.diffuser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Password {

	String[] passwords = new String[] { "about", "after", "again", "below", "could", "every", "first", "found", "great",
			"house", "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound", "spell",
			"still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world",
			"would", "write" };

	public Password() throws IOException {
		List<String> possible = new ArrayList<String>(Arrays.asList(passwords));

		for (int offset = 0; offset < 5; offset++) {
			List<String> possibleThisRound = new ArrayList<String>();
			List<String> impossibleThisRound = new ArrayList<String>();

			System.out
					.println(
							"Enter all of the possible "
									+ (offset == 0 ? "first"
											: offset == 1 ? "second"
													: offset == 2 ? "third" : offset == 3 ? "fourth" : "fifth")
									+ " letters.");

			String[] letters = Main.console.readLine().toLowerCase().replaceAll(" ", "").split("");

			for (String password : passwords)
				for (String letter : letters)
					if (password.startsWith(letter, offset)) {
						possibleThisRound.add(password);
						break;
					}

			for (String possibility : possible)
				if (!possibleThisRound.contains(possibility))
					impossibleThisRound.add(possibility);

			possible.removeAll(impossibleThisRound);

			if (possible.size() == 1) {
				System.out.println(possible.get(0).toUpperCase());
				return;
			}
		}
	}
}
