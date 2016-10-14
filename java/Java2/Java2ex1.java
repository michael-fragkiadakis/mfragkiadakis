import java.util.Scanner;
public class Java2ex1 {

	public static int bootcamp (int x,int y){
			if (x < y)
				return ((int)Math.sqrt(Math.abs(x - y)));
			else
				return (x + y);
	}

    public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter first number: ");
    	int a = scanner.nextInt();
    	System.out.print("Enter second number: ");
    	int b = scanner.nextInt();
    	System.out.println(bootcamp (a, b));
	}


}