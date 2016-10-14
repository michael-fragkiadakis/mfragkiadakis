import java.util.Scanner;
public class Python2ex2 {
    public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter binary number: ");
    	int bin = scanner.nextInt();
    	int last = bin % 10;
    	int counter = 0;

		for (int i = 1; i <= 7; i++){
			bin /= 10;
			counter += bin % 10;
		}

		if ((counter % 2) == last)
			System.out.println("Parity check OK.");
		else
			System.out.println("Parity check NOT OK.");

    }
}