package jordan.sicherman.diffuser;

import java.io.IOException;

public class Wires {

	public Wires() throws IOException {
		System.out.println("Enter sequence (w,y,r,blu,bl).");
		String line = Main.console.readLine();
		if (line == null || line.isEmpty())
			return;
		String[] data = line.replaceAll(" ", "").toLowerCase().split(",");
		int r = 0, w = 0, y = 0, blu = 0, bl = 0;
		for (String s : data)
			if ("r".equals(s))
				r++;
			else if ("w".equals(s))
				w++;
			else if ("y".equals(s))
				y++;
			else if ("blu".equals(s))
				blu++;
			else if ("bl".equals(s))
				bl++;

		String serial = "";
		if (data.length >= 4)
			serial = Main.analytics.fetch("SERIAL");

		switch (data.length) {
		case 3:
			// Tip: Never first wire.
			System.out.println(r == 0 ? "Second wire" : "Last wire");
			break;
		case 4:
			System.out
					.println(r > 2 && Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 1
							? "Last red wire"
							: data[3].equals("y") && r == 0 ? "First wire"
									: blu == 1 ? "First wire" : y > 1 ? "Last wire" : "Second wire");
			break;
		case 5:
			System.out.println(data[4].equals("bl")
					&& Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 1 ? "Fourth wire"
							: r == 1 && y > 1 ? "First wire" : bl == 0 ? "Second wire" : "First wire");
			break;
		case 6:
			System.out
					.println(y == 0 && Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 1
							? "Third wire" : y == 1 && w > 1 ? "Fourth wire" : r == 0 ? "Last wire" : "Fourth wire");
			break;
		}
	}
}
