import java.util.Scanner;
public class Java1ex3 {

    public static void main(String[] args) {
		boolean validator = true;

		do {
			Scanner scanner = new Scanner (System.in);
			System.out.print("Enter side A length: ");
    		int a = scanner.nextInt();
    		System.out.print("Enter side B length: ");
    		int b = scanner.nextInt();
    		System.out.print("Enter side C length: ");
    		int c = scanner.nextInt();

    		int max = Math.max(c, (Math.max(a, b)));
    		int smallSides = a+b+c - max;

    		if (max >= smallSides){
    			System.out.println("Cannot create triangle with such sides. Reenter values.");
    			validator = false;
			}
			else {
    			equilateral(a,b,c);
    			System.out.printf("Perimeter: %d \n\n", perimeter(a,b,c));
    			validator = true;
			}

		} while (validator == false);
	}

	public static void equilateral (int x,int y, int z){
		if ((x == y) && (x == z))
			System.out.println("\nThis triangle is equilateral!");
		else
			System.out.println("\nThis triangle is NOT equilateral!");
	}

	public static int perimeter (int x, int y, int z){
		return (x+y+z);
	}
}