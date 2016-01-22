package jordan.sicherman.diffuser;

import java.io.IOException;

public class Knobs {

	private static String[] up = new String[] { "001011111101", "101010011011" };
	private static String[] down = new String[] { "011001111101", "101010010001" };
	private static String[] left = new String[] { "000010100111", "000010000110" };
	private static String[] right = new String[] { "101111111010", "101100111010" };

	public Knobs() throws IOException {
		System.out.println("Enter the light configuration.");
		String data = Main.console.readLine();

		for (int i : new int[] { 0, 1 })
			if (up[i].equals(data))
				System.out.println("UP");
			else if (down[i].equals(data))
				System.out.println("DOWN");
			else if (left[i].equals(data))
				System.out.println("LEFT");
			else if (right[i].equals(data))
				System.out.println("RIGHT");
			else
				System.out.println("UNKNOWN");
	}
}
