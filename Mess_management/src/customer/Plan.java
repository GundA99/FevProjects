package customer;

public enum Plan {
	MONTHLY (3000), QUATERLY (11700), HALFYEAR (17500), YEARLY (32000);
	public double cost;
	private Plan(double c)
	{
		this.cost = c;
	}
	public double getCost() {
		return cost;
	}
	public String getPlanName()
	{
		return this.name();
	}
}
