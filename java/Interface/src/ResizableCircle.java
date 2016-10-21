
public class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle(double radius) {
		super(radius);
	}

	@Override
	public void Resize(int percentage) {
		double multiplier = 100 +percentage /100;
		this.radius = this.radius * multiplier;
	}

}
