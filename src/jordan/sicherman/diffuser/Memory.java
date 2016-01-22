package jordan.sicherman.diffuser;

import java.io.IOException;

public class Memory {

	private final StageMemory[] memory = new StageMemory[5];

	private class StageMemory {
		private int[] buttons;
		private int index;

		public void assign(boolean position, int index) {
			if (position)
				this.index = index;
			else
				for (int i = 0; i < 4; i++)
					if (buttons[i] == index) {
						this.index = i;
						break;
					}
		}

		@Override
		public String toString() {
			return buttons[0] + " " + buttons[1] + " " + buttons[2] + " " + buttons[3] + "(" + index + ")";
		}
	}

	public Memory() throws IOException {
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter the display.");
			String[] data = Main.console.readLine().split("");

			memory[i] = new StageMemory();
			memory[i].buttons = new int[] { Integer.parseInt(data[0]), Integer.parseInt(data[1]),
					Integer.parseInt(data[2]), Integer.parseInt(data[3]) };

			switch (i) {
			case 0:
				switch (Integer.parseInt(data[4])) {
				case 1:
				case 2:
					memory[i].assign(true, 1);
					break;
				default:
					memory[i].assign(true, Integer.parseInt(data[4]) - 1);
					break;
				}
				break;
			case 1:
				switch (Integer.parseInt(data[4])) {
				case 1:
					memory[i].assign(false, 4);
					break;
				case 2:
				case 4:
					memory[i].assign(true, memory[0].index);
					break;
				case 3:
					memory[i].assign(true, 0);
				}
				break;
			case 2:
				switch (Integer.parseInt(data[4])) {
				case 1:
					memory[i].assign(false, memory[1].buttons[memory[1].index]);
					break;
				case 2:
					memory[i].assign(false, memory[0].buttons[memory[0].index]);
					break;
				case 3:
					memory[i].assign(true, 2);
					break;
				case 4:
					memory[i].assign(false, 4);
					break;
				}
				break;
			case 3:
				switch (Integer.parseInt(data[4])) {
				case 1:
					memory[i].assign(true, memory[0].index);
					break;
				case 2:
					memory[i].assign(true, 0);
					break;
				case 3:
				case 4:
					memory[i].assign(true, memory[1].index);
					break;
				}
				break;
			case 4:
				switch (Integer.parseInt(data[4])) {
				case 1:
					memory[i].assign(false, memory[0].buttons[memory[0].index]);
					break;
				case 2:
					memory[i].assign(false, memory[1].buttons[memory[1].index]);
					break;
				case 3:
					memory[i].assign(false, memory[3].buttons[memory[3].index]);
					break;
				case 4:
					memory[i].assign(false, memory[2].buttons[memory[2].index]);
					break;
				}
				break;
			}

			System.out.println("Press the " + memory[i].buttons[memory[i].index]);
		}
	}
}
