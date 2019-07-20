package a;

import java.util.Scanner;

public class GameofLife {

	/**
	 * 
	 */

	public static class life {
		private static char game[][];
		private static boolean cell[][];
		public static int row = 20;
		public static int col = 20;
		public static int count = 20;
		public static int time = 250;
		public static int pop = 0, p;

		private static char live = 'Å°';
		private static char dead = 'Å†';

		public life() {
			game = new char[row][col];
			cell = new boolean[row][col];

			for (int r = 0; r < game.length; r++) {
				for (int c = 0; c < game[0].length; c++) {
					game[r][c] = dead;

				}
			}
		}

		public static void clear() {
			for (int r = 0; r < game.length; r++) {
				for (int c = 0; c < game[0].length; c++) {
					game[r][c] = dead;

				}
			}

			for (int r = 0; r < cell.length; r++) {
				for (int c = 0; c < cell[0].length; c++) {
					cell[r][c] = false;

				}
			}

		}

		public void showGame() {

			for (int r = 0; r < cell.length; r++) {
				for (int c = 0; c < cell[0].length; c++) {
					if (game[r][c] == live) {
						cell[r][c] = true;
					} else {
						cell[r][c] = false;
					}

				}
			}

			for (int r = 0; r < game.length; r++) {
				for (int c = 0; c < game[0].length; c++) {
					System.out.print(" " + game[r][c]);
				}
				System.out.print("\n");
			}
			System.out.println();
		}

		public void liveorDie(int a, int b) {
			int alive = 0;

			try {
				if (cell[a - 1][b - 1] == true) {
					alive++;
				}
				if (cell[a - 1][b] == true) {
					alive++;
				}
				if (cell[a - 1][b + 1] == true) {
					alive++;
				}
				if (cell[a][b - 1] == true) {
					alive++;
				}
				if (cell[a][b + 1] == true) {
					alive++;
				}
				if (cell[a + 1][b - 1] == true) {
					alive++;
				}
				if (cell[a + 1][b] == true) {
					alive++;
				}
				if (cell[a + 1][b + 1] == true) {
					alive++;
				}

			} catch (ArrayIndexOutOfBoundsException e) {
			}

			if (cell[a][b] == true) {
				if (alive == 2 || alive == 3) {

				} else {
					game[a][b] = dead;

				}

			} else {
				if (cell[a][b] == false) {
					if (alive == 3) {
						game[a][b] = live;
					} else {
					}
				}
			}

		}

		public void cellpop() {
			int rand;
			int x = row, y = col;
			Scanner input = new Scanner(System.in);

			switch (pop) {

			case 0:
				for (int e = 0; e < game.length; e++) {
					for (int b = 0; b < game[0].length; b++) {
						rand = (int) (2 * Math.random() + 1);

						if (rand == 1) {
							game[e][b] = live;
						}
					}
				}
				break;
			case -1:

				do {

					System.out.println("Enter the row (-1 to quit)");
					while (x >= col) {
						x = input.nextInt();
						if (x == -1) {
							return;
						}
						if (x >= row) {
							System.out
									.println("You must input a value between 0 and "
											+ (row - 1));
						}
					}

					System.out.println("Enter the column (-1 to quit)");
					while (y >= col) {
						y = input.nextInt();
						if (y == -1) {
							return;
						}
						if (y >= col) {
							System.out
									.println("You must input a value between 0 and "
											+ (col - 1));
						}
					}

					game[x][y] = live;
					showGame();

					x = row;
					y = col;

				} while (x != -1 || y != -1);
				break;
			case -2:
				do {
					System.out
							.println("Enter how many cells to distribute (Enter 0 or a negative to return)");
					p = input.nextInt();
					if (p < 0) {
						return;
					}

					if (p > (row * col) || p < 3) {
						System.out
								.println("you have to input a number between 3 to "
										+ (row * col));
					}
				} while (p > (row * col));

				for (int i = 0; i < p; i++) {

					game[(int) (row * Math.random())][(int) (col * Math
							.random())] = live;
				}

				break;

			}

			for (int r = 0; r < game.length; r++) {
				for (int c = 0; c < game[0].length; c++) {
					if (game[r][c] == live) {
						cell[r][c] = true;
					} else {
						cell[r][c] = false;
					}

				}

			}
		}

		public static void main(String[] args) {
			int x = 0;
			Scanner input = new Scanner(System.in);

			System.out.println("Welcome to The Game of Life");

			while (x != -1) {
				System.out
						.println("Enter an amount of rows (Enter a integer less then or equal to 0 for the default value: "
								+ row + ")");
				x = input.nextInt();
				if (x > 0) {
					row = x;
				} else {
				}

				System.out
						.println("Enter an amount of columns (Enter a integer less then or equal to 0 for the default value: "
								+ col + ")");
				x = input.nextInt();
				if (x > 0) {
					col = x;
				} else {
				}
				life l = new life();

				System.out
						.println("Enter how long you would like the program to wait before it displays the output?(Enter a integer less then or equal to 0 for the default value: "
								+ time + ")");
				x = input.nextInt();
				if (x > 0) {
					time = x;
				} else {
				}

				System.out
						.println("Enter how many 'days' the program should run (Enter a integer less then or equal to 0 for the default value: "
								+ count + ")");
				x = input.nextInt();
				if (x > 0) {
					count = x;
				} else {
				}

				do {
					System.out
							.println("Enter how many cells you would like to be initally alive? (Enter -1 to manually place alive cells, or enter -2 for a number of alive cells to be placed randomly, Enter 0 or any other number to use the default (50% of the cells),)");
					x = input.nextInt();
					if (x == -1) {
						pop = -1;
					}
					if (x == -2) {
						pop = -2;
						clear();
					}
					if (x >= 0 || x < -2) {
						pop = 0;
						clear();
					}

					l.cellpop();
					l.showGame();

					System.out.println("Enter 1 to start the game");
					x = input.nextInt();

				} while (x != 1);

				x = 0;

				while (x != count && x != -1) {
					for (int a = 0; a < game.length; a++) {
						for (int b = 0; b < game[0].length; b++) {
							l.liveorDie(a, b);
						}
					}
					l.showGame();
					x++;
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
					}

				}
				System.out
						.println("Would you like this program to run again? (-1 to quit program)");
				x = input.nextInt();
			}

		}

	}

}
