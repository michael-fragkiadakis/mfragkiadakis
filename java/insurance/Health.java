import java.util.*;

public class Health extends Insurance {

	private static ArrayList<Health> healthInsurances = new ArrayList<Health>();

	private int medical;

	public void setMedical (int medical){this.medical = medical;}
	public int getMedical(){return this.medical;}

	Health (int id, int duration, int medical) {
		super(id, duration);
		this.medical = medical;
		healthInsurances.add(this);
	}

	public String toString(){
		return super.toString()+ "\nMedical Expense: $" +this.medical
		+"\nCost: $" +this.getCost();
	}

	@Override
	public int getCost () {
		int cost = super.getCost();
		Customer customer = Customer.getCustomer(this.getId());
		int customerAge = customer.getAge();
		cost += (7* customerAge);
		if (customer.getSex().equals("male"))
			cost += 50;
		return cost;
	}

}