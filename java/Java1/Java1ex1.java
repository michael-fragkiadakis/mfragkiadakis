import java.util.Scanner;
public class Java1ex1 {

    public static void main(String[] args) {

    	Scanner scanner = new Scanner (System.in);
    	System.out.print("Enter TIN: ");
    	int TIN = scanner.nextInt();
    	if (check (TIN) == true)
    		System.out.println ("Tax Identification Number valid.");
    	else
    		System.out.println ("Tax Identification Number NOT valid.");


	}

	public static boolean check(int x) {
		int last = x % 10; /// Gets last digit.
		int sum = 0;

		for (int i = 1; i <= 8; i++){
			x /= 10;
			sum += (x % 10) * (Math.pow(2,i));
		}

		int rem = (sum % 11) % 10;

		if (rem == last)
			return true;
		else
			return false;
    }
}