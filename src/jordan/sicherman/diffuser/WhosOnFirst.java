package jordan.sicherman.diffuser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhosOnFirst {

	private static Map<String, Integer> labels = new HashMap<String, Integer>();

	private static Map<String, List<String>> options = new HashMap<String, List<String>>();

	static {
		labels.put("yes", 2);
		labels.put("first", 1);
		labels.put("display", 5);
		labels.put("okay", 1);
		labels.put("says", 5);
		labels.put("nothing", 2);
		labels.put(" ", 4);
		labels.put("blank", 3);
		labels.put("no", 5);
		labels.put("led", 2);
		labels.put("lead", 5);
		labels.put("read", 3);
		labels.put("red", 3);
		labels.put("reed", 4);
		labels.put("leed", 4);
		labels.put("hold on", 5);
		labels.put("you", 3);
		labels.put("you are", 5);
		labels.put("your", 3);
		labels.put("you're", 3);
		labels.put("ur", 0);
		labels.put("there", 5);
		labels.put("they're", 4);
		labels.put("their", 3);
		labels.put("they are", 2);
		labels.put("see", 5);
		labels.put("c", 1);
		labels.put("cee", 5);

		options.put("ready",
				Arrays.asList("yes", "okay", "what", "middle", "left", "press", "right", "blank", "ready"));
		options.put("first", Arrays.asList("left", "okay", "yes", "middle", "no", "right", "nothing", "uhhh", "wait",
				"ready", "blank", "what", "press", "first"));
		options.put("no", Arrays.asList("blank", "uhhh", "wait", "first", "what", "ready", "right", "yes", "nothing",
				"left", "press", "okay", "no"));
		options.put("blank", Arrays.asList("wait", "right", "okay", "middle", "blank"));
		options.put("nothing", Arrays.asList("uhhh", "right", "okay", "middle", "yes", "blank", "no", "press", "left",
				"what", "wait", "first", "nothing"));
		options.put("yes",
				Arrays.asList("okay", "right", "uhhh", "middle", "first", "what", "press", "ready", "nothing", "yes"));
		options.put("what", Arrays.asList("uhhh", "what"));
		options.put("uhhh", Arrays.asList("ready", "nothing", "left", "what", "okay", "yes", "right", "no", "press",
				"blank", "uhhh"));
		options.put("left", Arrays.asList("right", "left"));
		options.put("right", Arrays.asList("yes", "nothing", "ready", "press", "no", "wait", "what", "right"));
		options.put("middle",
				Arrays.asList("blank", "ready", "okay", "what", "nothing", "press", "no", "wait", "left", "middle"));
		options.put("okay", Arrays.asList("middle", "no", "first", "yes", "uhhh", "nothing", "wait", "okay"));
		options.put("wait",
				Arrays.asList("uhhh", "no", "blank", "okay", "yes", "left", "first", "press", "what", "wait"));
		options.put("press", Arrays.asList("right", "middle", "yes", "ready", "press"));
		options.put("you",
				Arrays.asList("sure", "you are", "your", "you're", "next", "uh huh", "ur", "hold", "what?", "you"));
		options.put("you are", Arrays.asList("your", "next", "like", "uh huh", "what?", "done", "uh uh", "hold", "you",
				"u", "you're", "sure", "ur", "you are"));
		options.put("your", Arrays.asList("uh uh", "you are", "uh huh", "your"));
		options.put("you're", Arrays.asList("you", "you're"));
		options.put("ur", Arrays.asList("done", "u", "ur"));
		options.put("u", Arrays.asList("uh huh", "sure", "next", "what?", "you're", "ur", "uh uh", "done", "u"));
		options.put("uh huh", Arrays.asList("uh huh"));
		options.put("uh uh", Arrays.asList("ur", "u", "you are", "you're", "next", "uh uh"));
		options.put("what?", Arrays.asList("you", "hold", "you're", "your", "u", "done", "uh uh", "like", "you are",
				"uh huh", "ur", "next", "what?"));
		options.put("done", Arrays.asList("sure", "uh huh", "next", "what?", "your", "ur", "you're", "hold", "like",
				"you", "u", "you are", "uh uh", "done"));
		options.put("next", Arrays.asList("what?", "uh huh", "uh uh", "your", "hold", "sure", "next"));
		options.put("hold",
				Arrays.asList("you are", "u", "done", "uh uh", "you", "ur", "sure", "what?", "you're", "next", "hold"));
		options.put("sure", Arrays.asList("you are", "done", "like", "you're", "you", "hold", "uh huh", "ur", "sure"));
		options.put("like",
				Arrays.asList("you're", "next", "u", "ur", "hold", "done", "uh uh", "what?", "uh huh", "you", "like"));
	}

	public WhosOnFirst() throws IOException {
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter the display, followed by all 6 words (comma delimited).");

			String line = Main.console.readLine().toLowerCase();
			if (line == null || line.isEmpty())
				return;
			String[] data = line.split(",");

			boolean found = false;
			for (String option : options.get(data[labels.get(data[0]) + 1])) {
				for (int j = 1; j < data.length; j++)
					if (data[j].equals(option)) {
						System.out.println(option.toUpperCase());
						found = true;
						break;
					}
				if (found)
					break;
			}
		}
	}
}
