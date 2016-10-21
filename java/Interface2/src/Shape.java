
public class Shape implements Agreeable {
	
	private int width;
	private int height;

	public Shape() {}
	

	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean isSmallerThan(Shape other) {
		if (this.calcArea() < other.calcArea()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int calcArea() {
		int area = this.width * this.height;
		return area;
	}

}
