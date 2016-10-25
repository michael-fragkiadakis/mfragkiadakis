
public class TestRectangle {
	
	public static void main(String[] args) {

		Rectangle r1 = new Rectangle (3, 3);
		Rectangle r2 = new Rectangle (2, 5);
		Rectangle r3 = new Rectangle (3, 6);
		Rectangle r4 = new Rectangle (5, 2);
		Rectangle r5 = r3.copy();
		
		r1.isSquare();
		r2.isSquare();
		
		r1.areEqual(r5);
		r3.areEqual(r5);
		
		r1.draw();
		r2.draw();
		r3.draw();
		r4.draw();
		r5.draw();
		
		Shape rec1 = new Rectangle(2,5);
		Rectangle rec2 = new Rectangle(3,6);
		
		rec2.areEqual(r1);
		rec2.areEqual(r3);
		
		rec2.area();
		rec1.area();
		r1.area();
		
		r2.perimeter();
		rec1.perimeter();
		
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(2);
		
		c1.area();
		c2.perimeter();
		
		Shape[] shapes = {r1, r2, r3, r4, r5, rec1, rec2, c1, c2};
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		
	}

}
