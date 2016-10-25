
public class Rectangle extends Shape {

	//fields
	private int a, b;
	private static final int sides = 2;
	
	//constructors
	public Rectangle(int sides) {
		super(sides);
	}

	public Rectangle(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	//getters & setters
	public int getA() {return a;}
	public void setA(int a) {this.a = a;}
	public int getB() {return b;}
	public void setB(int b) {this.b = b;}
	
	//methods
	@Override
	public String toString() {
		return "Rectangle [a=" + a + ", b=" + b + "]";
	}
	
	public boolean areEqual (Rectangle other) {
		if (this.a == other.getA() && this.b == other.getB()) {
			System.out.println(this +" is equal to " +other);
			return true;
		}
		System.out.println(this +" is NOT equal to " +other);
		return false;
	}
	
	public boolean isSquare () {
		if (this.a == this.b) {
			System.out.println(this + " is a square.");
			return true;
		}
		System.out.println(this + " is NOT a square.");
		return false;
	}
	
	public Rectangle copy(){
		Rectangle copy = new Rectangle(this.a, this.b);
		return copy;
	}
	
	//inherited methods
	public void draw() {
		String line = "---";
		String line2 = "|  ";
		String line3 = "   ";
		String line4 = "  |";
		for (int i = 0; i <= b+1; i ++) {
			System.out.println();
			for (int j = 1; j <= a; j ++) {
				if (i == 0 || i == b+1) {
					System.out.print(line);
				}
				else if (j == 1) {
					System.out.print(line2);
				}
				else if (j == a) {
					System.out.print(line4);
				}
				else {
					System.out.print(line3);
				}
			}
		}
		System.out.println();
		System.out.println(this);
	}
	
	public double perimeter() {
		double perimeter = 2*a + 2*b;
		System.out.println("Perimeter of " +this + " is " +perimeter);
		return perimeter;
	}
	
	public double area() {
		double area = a * b;
		System.out.println("Area of " +this + " is " +area);
		return area;
	}
	
}
