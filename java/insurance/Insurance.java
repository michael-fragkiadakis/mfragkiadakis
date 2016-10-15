import java.util.*;

public class Insurance {

	private static int counter = 0;
	//private static Insurance[] insurances = new Insurance[10];
	private static ArrayList<Insurance> insurances = new ArrayList<Insurance>();

	private int id;
	private int code;
	private int duration;

	public static int getCounter() {return counter;}
	public void setId (int id){this.id = id;}
	public int getId(){return this.id;}
	public void setCode (int code){this.code = code;}
	public int getCode(){return this.code;}
	public void setDuration (int duration){this.duration = duration;}
	public int getDuration(){return this.duration;}

	Insurance (int id, int duration) {
		this.id = id;
		this.duration = duration;
		counter++;
		code = counter;
		insurances.add(this);
		//insurances[code-1] = this;
	}

	public String toString(){
		String insurance_details = "\nCustomer Id: " +this.id +"\nInsurance Code: " +this.code
		+"\nDuration: " + this.duration +" years" + "\nCost :" +this.getCost();
		return insurance_details;
	}

	public int getCost () {
		return 100;
	}

	public static void printInsurances () {
		for (Insurance insurance : insurances)
			System.out.println(insurance.toString());
	}

	public static void getInsurance (int code) {
		for (Insurance insurance : insurances) {
			if (insurance.getCode() == code) {
				System.out.println(insurance.toString());
				break;
			}
		}
	}

	public static void getCustomerInsurances (int id) {
		for (Insurance insurance : insurances) {
			if (insurance.getId() == id)
				System.out.println(insurance.toString());
		}
	}

}