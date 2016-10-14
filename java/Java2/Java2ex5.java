import java.util.Scanner;
import java.util.Arrays;

public class Java2ex5 {

	public static boolean win (int x, int y, String[][] triliza){
		boolean end = false;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		String s = triliza[x][y];

		for (int i = 1; i <=3; i++){
			if (triliza[x][i] == s) // vertical win?
				a++;
			if (triliza[i][y] == s) // horizontal win?
				b++;
			if ((x == y) && (triliza[i][i] == s)) // diagonal / win?
				c++;
			if ((x + y == 4) && (triliza[i][4-i] == s)) // diagonal \ win?
				d++;
		}
		if ((a == 3) || (b == 3) || (c == 3) || (d == 3))
			end = true;
		return end;
	}

	public static void draw (String next, int x, int y, String[][] triliza){
		triliza[x][y] = next;
		System.out.println();
		for (String[] i : triliza) {
			for (String j : i) {
				System.out.print(j + "\t");
			}
			System.out.println("\n");
		}
	}

    public static void main(String[] args) {

		String[][] triliza = new String [4][4];
		String next = "X";
		boolean winner = false;
		boolean invalid = false;
		int emptySpots = 9;
		int x = 0;
		int y = 0;

		triliza[0][0] = "x=>";
		for (int i = 1; i <=3; i++){
			triliza [0][i] = Integer.toString(i);
			triliza [i][0] = Integer.toString(i);
			for (int j = 1; j <=3; j++)
				triliza[i][j] = " ";
		}

		for (String[] i : triliza) {
			for (String j : i)
				System.out.print(j + "\t");
			System.out.println("\n");
		}

		do {
			do {
				Scanner scanner = new Scanner (System.in);
				System.out.print("Enter x (1 - 3): "); // so that x is horizontal and y vertical
				y = scanner.nextInt();
				System.out.print("Enter y (1 - 3): ");
    			x = scanner.nextInt();
    			if ((triliza[x][y] == "X") || (triliza[x][y] == "O")){
    				invalid = true;
    				System.out.println(" * Invalid spot - Retry * ");
				}
    			else
    				invalid = false;
			} while (invalid == true);

    		draw(next, x, y, triliza);
    		emptySpots --;
    		if (next ==  "X")
				next = "O";
			else
				next = "X";
    		winner = win(x, y, triliza);
		} while ((winner != true) && (emptySpots > 0));

		if (winner == true)
			System.out.println(" *** We have a winner!!! *** \n");
		else if (emptySpots < 1)
			System.out.println(" *** Game over - It's a tie! *** \n");
	}

}