import java.util.*;

public class TestInsurance {

	public static void main(String[] args) {

		// Create random customers
		Customer makis = new Customer ("makis", 1981, "male");
		Customer takis = new Customer ("takis", 1987, "male");
		Customer anna = new Customer ("anna", 1977, "female");
		Customer inna = new Customer ("inna", 1997, "female");
		Customer stelios = new Customer ("stelios", 1963, "male");

		// Create random insurances
		Insurance ins1 = new Insurance(1, 10);
		Insurance ins2 = new Insurance(5, 5);
		Life life1 = new Life(1, 3, 5000);
		Life life2 = new Life(2, 8, 1000);
		Life life3 = new Life(4, 15, 10000);
		Health health1 = new Health(1, 8, 500);
		Health health2 = new Health(3, 10, 7000);
		Health health3 = new Health(4, 1, 100);


		Scanner scanner = new Scanner (System.in);

		do {
			System.out.println("\n***** Menu *****"); //cmd user interface
			System.out.println("1. Print all Insurances");
			System.out.println("2. Search insurances by customer id");
			System.out.println("3. Search insurance by insurance code");
			System.out.println("0. Quit");
			int input = scanner.nextInt();

			if (input == 1) {
				Insurance.printInsurances();
			}
			else if (input == 2) {
				do {
					System.out.print("\nEnter Customer Id: ");
					int id = scanner.nextInt();
					if (id <= Customer.getCounter() && id > 0){
						Insurance.getCustomerInsurances(id);
						break;
					}
					else
						System.out.printf("\nThere is no customer with such id. Try again.", id);
				} while (true);
			}
			else if (input == 3)  {
				do {
					System.out.print("\nEnter Insurance Code: ");
					int code = scanner.nextInt();
					if (code <= Insurance.getCounter() && code > 0) {
						Insurance.getInsurance(code);
						break;
					}
					else
						System.out.printf("\nThere is no insurance with this code. Try again.");
				} while (true);
			}
			else if (input == 0)
				break;
			else
				System.out.println("\nNo such option. Try again.");
		} while (true);
		System.out.println("\nGoodbye!");
	}
}