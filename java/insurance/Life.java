import java.util.*;

public class Life extends Insurance {

	private static ArrayList<Life> lifeInsurances = new ArrayList<Life>();

	private int invest;

	public void setInvest (int invest){this.invest = invest;}
	public int getInvest(){return this.invest;}

	Life (int id, int duration, int invest) {
		super(id, duration);
		this.invest = invest;
		lifeInsurances.add(this);
	}

	public String toString(){
		return super.toString()+ "\nInvest: $" +this.invest +"\nCost: $" +this.getCost();
	}

	@Override
	public int getCost () {
		int cost = super.getCost();
		Customer customer = Customer.getCustomer(this.getId());
		int customerAge = customer.getAge();
		cost += (5* customerAge);
		return cost;
	}

}