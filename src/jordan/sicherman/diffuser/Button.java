package jordan.sicherman.diffuser;

import java.io.IOException;

public class Button {

	public Button() throws IOException {
		System.out.println("Enter the button color (b,w,y,r) and label.");
		String line = Main.console.readLine();
		if (line == null || line.isEmpty())
			return;

		String[] data = line.toLowerCase().split(" ");

		boolean hold = true;

		if (data[0].equals("b") && data[1].equals("abort"))
			hold = true;
		else {
			int batteries = Integer.parseInt(Main.analytics.fetch("BATTERY"));
			if (batteries > 1 && data[1].equals("detonate"))
				hold = false;
			else if (data[0].equals("w") && "y".equalsIgnoreCase(Main.analytics.fetch("CAR")))
				hold = true;
			else if (batteries > 2 && "y".equalsIgnoreCase(Main.analytics.fetch("FRK")))
				hold = false;
			else if (data[0].equals("r") && data[1].equals("hold"))
				hold = false;
		}

		if (hold)
			System.out.println("Press and hold.\n\nBlue: 4\nYellow: 5\nOther: 1");
		else
			System.out.println("Press and release.");
	}
}
