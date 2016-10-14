public class Python1ex1 {
    public static void main(String[] args) {
		int x = 0;
		while (x < 9){
			x ++;
			for (int i = 1; i < 10-x; i++){
				System.out.print("0");
			}
			for (int j = 1; j <= x; j++){
				System.out.print(x);

			}
			System.out.println("");
		}
    }
}