import java.util.Scanner;
public class Java2ex3 {

	public static void shift (int x, int[] list){

		for (int i = 1; i <= x; i ++){
			int last = list[9];
			for (int j = 8; j >= 0; j--)
				list[j+1] = list[j];
			list[0] = last;
		}

		for (int i = 0; i < 10; i++)
			System.out.print (list[i] + " ");
		System.out.println ();
	}

    public static void main(String[] args) {

		int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int i = 0; i < 10; i++)
			System.out.print (lista[i] + " ");
		System.out.println ();

		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter number of shifts: ");
    	int counter = scanner.nextInt();

    	shift(counter, lista);
	}

}