package jordan.sicherman.diffuser;

import java.io.IOException;

public class Complex {

	public Complex() throws IOException {
		for (int i = 0; i < 6; i++) {
			System.out.println("Please enter the style of the wire (r,w,b,*,+)");
			String data = Main.console.readLine().toLowerCase();
			if (data == null || data.isEmpty())
				return;

			boolean cut = true;

			if (data.contains("r")) {
				if (data.contains("b")) {
					if (data.contains("*")) {
						if (data.contains("+"))
							cut = false;
						else
							cut = "y".equalsIgnoreCase(Main.analytics.fetch("PARALLEL"));
					} else {
						String serial = Main.analytics.fetch("SERIAL");
						cut = Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 0;
					}
				} else {
					if (data.contains("*")) {
						if (data.contains("+"))
							cut = Integer.parseInt(Main.analytics.fetch("BATTERY")) >= 2;
						else
							cut = true;
					} else if (data.contains("+"))
						cut = Integer.parseInt(Main.analytics.fetch("BATTERY")) >= 2;
					else {
						String serial = Main.analytics.fetch("SERIAL");
						cut = Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 0;
					}
				}
			} else if (data.contains("b")) {
				if (data.contains("*")) {
					if (data.contains("+"))
						cut = "y".equalsIgnoreCase(Main.analytics.fetch("PARALLEL"));
					else
						cut = false;
				} else if (data.contains("+"))
					cut = "y".equalsIgnoreCase(Main.analytics.fetch("PARALLEL"));
				else {
					String serial = Main.analytics.fetch("SERIAL");
					cut = Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 0;
				}
			} else if (data.contains("*")) {
				if (data.contains("+"))
					cut = Integer.parseInt(Main.analytics.fetch("BATTERY")) >= 2;
				else
					cut = true;
			} else
				cut = !data.contains("+");

			System.out.println(cut ? "Cut." : "Do not cut.");
		}
	}
}
