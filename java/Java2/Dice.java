public class Dice {

	public static void roll (){
		int totalRolls = 0;
		int sum = 0;
		do {
			int dice1 =(int)(Math.random()*6 +1);
			int dice2 =(int)(Math.random()*6 +1);
			System.out.printf("Roll 1: %d / Roll 2: %d\n", dice1, dice2);
    		sum = dice1 + dice2;
    		totalRolls ++ ;
		} while (sum != 2);
		System.out.printf ("\nThe dice were rolled %d times in order to get two 1s.\n", totalRolls);

	}

    public static void main(String[] args) {
		roll();
	}

}