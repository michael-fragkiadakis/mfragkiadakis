import java.util.Scanner;
public class Java1ex2 {

    public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter number: ");
    	int input = scanner.nextInt();

    	if (input < 1)
    		System.out.println("Input not positive number... Abort, abooooort!!! ");
    	else
    		factorial(input);
	}

	public static void factorial (int x){
		int fact = 1;
		for (int i = 1; i <= x; i++)
			fact *= i;
		System.out.printf("The factorial of %d is: %d\n", x, fact);
	}

    	///Java1ex2 test = new Java1ex2(); object (test) of class (java1ex2) creation
}