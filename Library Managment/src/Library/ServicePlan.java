package Library;

public enum ServicePlan {
	SILVER(1000), GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private int cost;
	private ServicePlan(int cost)
	{
		this.cost=cost;
	}
	
	public int getCost() {
		return cost;
	}
	
}
