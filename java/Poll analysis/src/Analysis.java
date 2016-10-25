
public class Analysis {

	public Analysis() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		int table[] = {1, 2, 6, 4, 8, 5, 9, 7, 8, 10, 1, 6, 3, 8, 6, 10, 3, 8, 2, 7, 6, 5, 7, 6, 8, 6, 7, 5, 6, 6, 5, 6, 7, 5, 6, 8, 4, 6, 8, 10};
		double avg = 0;
		int table2[] = new int [11];
		
		for (int i : table) {
			switch (i) {
            case 1:  table2[1] ++;
                     break;
            case 2:  table2[2] ++;
                     break;
            case 3:  table2[3] ++;
                     break;
            case 4:  table2[4] ++;
                     break;
            case 5:  table2[5] ++;
                     break;
            case 6:  table2[6] ++;
                     break;
            case 7:  table2[7] ++;
                     break;
            case 8:  table2[8] ++;
                     break;
            case 9:  table2[9] ++;
                     break;
            case 10: table2[10] ++;
                     break;
			}
			
			avg += i;
		}
		System.out.println("Rating \t Frequency");
		for (int i = 1; i <= 10; i++) {
			System.out.println("   " +i +"\t    " +table2[i]);
		}
				
		avg /= table.length;
		System.out.println("\nThe average rating is: " +avg);

	}

}
