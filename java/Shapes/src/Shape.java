
public abstract class Shape {

	// field
	int sides;
	static Shape[] shapes;
	
	// constructors
	public Shape() {}

	public Shape(int sides) {
		this.sides = sides;
	}
	
	// getters & setters
	public int getSides() {return sides;}
	public void setSides(int sides) {this.sides = sides;}
	
	// methods
	public abstract double perimeter();
	public abstract double area();
	public void draw() {}

	@Override
	public String toString() {
		return "Shape [sides=" + sides + "]";
	}
	
}
