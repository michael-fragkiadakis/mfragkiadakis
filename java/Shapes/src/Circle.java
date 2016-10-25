
public class Circle extends Shape {

	private static final int sides = 0;
	private int radius;
	
	public Circle() {}

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double perimeter() {
		double perimeter = 2 *Math.PI *radius;
		System.out.println("Perimeter of " +this + " is " +perimeter);
		return perimeter;
	}

	public double area() {
		double area = Math.PI * Math.pow(radius, 2);
		System.out.println("Area of " +this + " is " +area);
		return area;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
